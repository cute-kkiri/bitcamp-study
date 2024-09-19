package bitcamp.myapp.servlet;

import bitcamp.myapp.annotation.RequestMapping;
import bitcamp.myapp.annotation.RequestParam;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@MultipartConfig(
        maxFileSize = 1024 * 1024 * 60,
        maxRequestSize = 1024 * 1024 * 100)
@WebServlet("/app/*")
public class DispatcherServlet extends HttpServlet {

  private List<Object> controllers;

  @Override
  public void init() throws ServletException {
    controllers = (List<Object>) this.getServletContext().getAttribute("controllers");
  }

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    try {
      // 클라이언트가 요청한 URL을 가지고 페이지 컨트롤러와 요청핸들러(메서드)를 찾는다.
      String controllerPath = req.getPathInfo();

      Object pageController = null;
      Method requestHandler = null;

      loop:
      for (Object controller : controllers) {
        Method[] methods = controller.getClass().getDeclaredMethods();
        for (Method m : methods) {
          RequestMapping requestMapping = m.getAnnotation(RequestMapping.class);
          if (requestMapping == null || !requestMapping.value().equals(controllerPath)) {
            continue;
          }
          requestHandler = m;
          pageController = controller;
          break loop;
        }
      }

      if (pageController == null) {
        throw new Exception("해당 URL을 처리할 수 없습니다.");
      }

      if (requestHandler.getReturnType() == void.class) {
        requestHandler.invoke(pageController, req, res);
        return;
      }

      Map<String, Object> map = new HashMap<>();

      Object[] arguments = prepareRequestHandlerArguments(requestHandler, req, res, map);

      String viewName = (String) requestHandler.invoke(pageController, arguments);

      if (map.size() > 0) {
        copyMapToServletRequest(map, req);
      }

      // 페이지 컨트롤러가 정상적으로 실행했으면, viewName을 가져와서 포워딩 한다.
      if (viewName.startsWith("redirect:")) {
        res.sendRedirect(viewName.substring(9));

      } else {
        req.getRequestDispatcher(viewName).forward(req, res);
      }

    } catch (Exception e) {
      req.setAttribute("exception", e);
      req.getRequestDispatcher("/error.jsp").forward(req, res);
    }
  }

  private Object[] prepareRequestHandlerArguments(
          Method requestHandler,
          HttpServletRequest req,
          HttpServletResponse res,
          Map<String, Object> requestAttributesMap) {

    Parameter[] params = requestHandler.getParameters();
    ArrayList<Object> args = new ArrayList<>();

    for (Parameter param : params) {
      Class<?> paramType = param.getType();
      if (paramType == ServletRequest.class || paramType == HttpServletRequest.class) {
        args.add(req);
      } else if (paramType == ServletResponse.class || paramType == HttpServletResponse.class) {
        args.add(res);
      } else if (paramType == Map.class) {
        args.add(requestAttributesMap);
      } else if (paramType == int.class) {
        RequestParam paramAnno = param.getAnnotation(RequestParam.class);
        args.add(Integer.parseInt(req.getParameter(paramAnno.value())));
      } else {
        args.add(null);
      }
    }

    return args.toArray();
  }

  private void copyMapToServletRequest(Map<String, Object> map, ServletRequest req) {
    for (Map.Entry<String, Object> entry : map.entrySet()) {
      req.setAttribute(entry.getKey(), entry.getValue());
    }
  }

}
