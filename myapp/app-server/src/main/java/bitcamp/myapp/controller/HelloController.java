package bitcamp.myapp.controller;

import bitcamp.myapp.annotation.Controller;
import bitcamp.myapp.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@Controller
public class HelloController {

  @RequestMapping("/hello")
  public void hello(HttpServletResponse res) throws Exception {
    PrintWriter out = res.getWriter();
    out.println("Hello!");
  }
}
