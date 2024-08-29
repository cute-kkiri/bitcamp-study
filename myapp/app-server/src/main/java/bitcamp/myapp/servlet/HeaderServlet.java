package bitcamp.myapp.servlet;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/header")
public class HeaderServlet extends GenericServlet {

  @Override
  public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
    PrintWriter out = res.getWriter();
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("    <meta charset='UTF-8'>");
    out.println("    <title>Title</title>");
    out.println("    <link href='/css/common.css' rel='stylesheet'>");
    out.println("</head>");
    out.println("<body>");

    out.println("<header>");
    out.println("  <a href='/'><img src='/images/home.png'></a>");
    out.println("        프로젝트 관리 시스템");
    out.println("</header>");
  }
}
