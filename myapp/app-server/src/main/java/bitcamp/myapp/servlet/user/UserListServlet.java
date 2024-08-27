package bitcamp.myapp.servlet.user;

import bitcamp.myapp.dao.UserDao;
import bitcamp.myapp.vo.User;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/user/list")
public class UserListServlet implements Servlet {

  private ServletConfig config;
  private UserDao userDao;

  @Override
  public void init(ServletConfig config) throws ServletException {
    // 서블릿 객체를 생성한 후 바로 호출됨(물론, 생성자가 먼저 호출된다.)
    // 서블릿이 작업할 사용할 의존 객체를 준비하는 일을 이 메서드에서 수행한다.
    this.config = config;

    ServletContext ctx = config.getServletContext();
    userDao = (UserDao) ctx.getAttribute("userDao");
  }

  @Override
  public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
    // 웹브라우저에서 이 서블릿을 실행해달라고 요청이 들어오면 이 메서드가 호출된다.
    // 누가 호출하는가? 서블릿 컨테이너가 호출한다.

    // 출력할 콘텐트의 타입을 먼저 지정한 후 출력 스트림을 얻는다.
    res.setContentType("text/plain;charset=UTF-8");
    
    PrintWriter out = res.getWriter();

    try {
      out.println("[게시글 목록]");
      out.println("번호 이름 이메일");
      for (User user : userDao.list()) {
        out.printf("%d %s %s\n", user.getNo(), user.getName(), user.getEmail());
      }

    } catch (Exception e) {
      out.println("목록 조회 중 오류 발생!");
    }
  }

  @Override
  public void destroy() {
    // 서블릿 컨테이너가 종료되기 전에 해제할 자원이 있다면 이 메서드에서 수행한다.
  }

  @Override
  public String getServletInfo() {
    // 서블릿 컨테이너 관리 화면에서 서블릿을 정보를 출력할 때 이 메서드가 호출된다.
    // 서블릿에 대한 간단한 정보를 문자열로 리턴하면 된다.
    return "회원 목록 조회";
  }

  @Override
  public ServletConfig getServletConfig() {
    // 서블릿의 정보를 조회할 때 사용할 ServletConfig 객체를 리턴해 준다.
    // 이 메서드가 리턴할 ServletConfig 객체는
    // init() 메서드가 호출될 때 파라미터로 넘어온 객체다.
    // 따라서 init() 메서드가 호출될 때 ServletConfig 객체를 보관해 둬야 한다.
    return this.config;
  }
}
