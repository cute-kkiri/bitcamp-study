package bitcamp.myapp.servlet.project;

import bitcamp.myapp.dao.ProjectDao;
import bitcamp.myapp.vo.Project;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/project/list")
public class ProjectListServlet implements Servlet {

  private ServletConfig config;
  private ProjectDao projectDao;

  @Override
  public void init(ServletConfig config) throws ServletException {
    this.config = config;
    projectDao = (ProjectDao) config.getServletContext().getAttribute("projectDao");
  }

  @Override
  public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
    res.setContentType("text/plain;charset=UTF-8");

    PrintWriter out = res.getWriter();

    out.println("[프로젝트 목록]");
    out.println("번호 프로젝트 기간");

    try {
      for (Project project : projectDao.list()) {
        out.printf("%d %s %s ~ %s\n",
                project.getNo(), project.getTitle(), project.getStartDate(), project.getEndDate());
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
    return "프로젝트 목록 조회";
  }

  @Override
  public ServletConfig getServletConfig() {
    return this.config;
  }
}
