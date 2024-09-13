package bitcamp.myapp.servlet;

import bitcamp.myapp.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

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

      String viewName = (String) requestHandler.invoke(pageController, req, res);

      // 페이지 컨트롤러가 정상적으로 실행했으면, viewName을 가져와서 포워딩 한다.
      if (viewName == null) {
        return;

      } else if (viewName.startsWith("redirect:")) {
        res.sendRedirect(viewName.substring(9));

      } else {
        String refresh = (String) req.getAttribute("refresh");
        if (refresh != null) {
          res.setHeader("Refresh", refresh);
        }
        req.getRequestDispatcher(viewName).forward(req, res);
      }

    } catch (Exception e) {
      req.setAttribute("exception", e);
      req.getRequestDispatcher("/error.jsp").forward(req, res);
    }
  }

}
