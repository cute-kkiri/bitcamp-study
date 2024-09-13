package bitcamp.myapp.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.Map;

@MultipartConfig(
        maxFileSize = 1024 * 1024 * 60,
        maxRequestSize = 1024 * 1024 * 100)
@WebServlet("/app/*")
public class DispatcherServlet extends HttpServlet {

  private Map<String, Object> controllerMap;

  @Override
  public void init() throws ServletException {
    controllerMap = (Map<String, Object>) this.getServletContext().getAttribute("controllerMap");
  }

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    try {
      // 클라이언트가 요청한 URL을 가지고 페이지 컨트롤러를 찾는다.
      String controllerPath = req.getPathInfo();
      Object pageController = controllerMap.get(controllerPath);
      if (pageController == null) {
        throw new Exception("해당 URL을 처리할 수 없습니다.");
      }

      // 페이지 컨트롤러의 메서드를 호출한다.
      Method requestHandler = pageController.getClass().getMethod(
              "execute",
              HttpServletRequest.class,
              HttpServletResponse.class);
      requestHandler.invoke(pageController, req, res);

      // 쿠키 처리
      Enumeration<String> attrNames = req.getAttributeNames();
      while (attrNames.hasMoreElements()) {
        Object attrValue = req.getAttribute(attrNames.nextElement());
        if (attrValue instanceof Cookie) {
          res.addCookie((Cookie) attrValue);
        }
      }

      // 페이지 컨트롤러가 정상적으로 실행했으면, viewName을 가져와서 포워딩 한다.
      String viewName = (String) req.getAttribute("viewName");
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
