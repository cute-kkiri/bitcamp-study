package bitcamp.myapp.servlet.board;

import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.vo.Board;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/board/list")
public class BoardListServlet implements Servlet {

  private ServletConfig config;
  private BoardDao boardDao;

  @Override
  public void init(ServletConfig config) throws ServletException {
    this.config = config;

    boardDao = (BoardDao) config.getServletContext().getAttribute("boardDao");
  }

  @Override
  public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
    res.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = res.getWriter();
    try {
      out.println("[게시글 목록]");
      out.println("번호 제목 작성자 작성일 조회수");

      for (Board board : boardDao.list()) {
        out.printf("%d %s %s %tY-%4$tm-%4$td %d\n",
                board.getNo(),
                board.getTitle(),
                board.getWriter().getName(),
                board.getCreatedDate(),
                board.getViewCount());
      }
    } catch (Exception e) {
      out.println("목록 조회 중 오류 발생!");
      e.printStackTrace();
    }
  }

  @Override
  public void destroy() {
  }

  @Override
  public String getServletInfo() {
    return "게시글 목록 조회";
  }

  @Override
  public ServletConfig getServletConfig() {
    return this.config;
  }
}
