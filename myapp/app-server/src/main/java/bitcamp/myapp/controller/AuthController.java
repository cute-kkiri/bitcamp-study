package bitcamp.myapp.controller;


import bitcamp.myapp.service.UserService;
import bitcamp.myapp.vo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class AuthController {

  private UserService userService;

  public AuthController(UserService userService) {
    this.userService = userService;
  }

  @RequestMapping("/auth/form")
  public String form() throws Exception {
    return "/auth/form.jsp";
  }

  @RequestMapping("/auth/login")
  public String login(
          @RequestParam("email") String email,
          @RequestParam("password") String password,
          @RequestParam("saveEmail") boolean saveEmail,
          HttpServletResponse res,
          HttpSession session) throws Exception {

    User user = userService.exists(email, password);
    if (user == null) {
      res.setHeader("Refresh", "2; url=login");
      return "/auth/fail.jsp";
    }

    if (saveEmail) {
      Cookie cookie = new Cookie("email", email);
      cookie.setMaxAge(60 * 60 * 24 * 7);
      res.addCookie(cookie);
    } else {
      Cookie cookie = new Cookie("email", "test@test.com");
      cookie.setMaxAge(0);
      res.addCookie(cookie);
    }

    session.setAttribute("loginUser", user);
    return "redirect:/";
  }

  @RequestMapping("/auth/logout")
  public String logout(HttpSession session) throws Exception {
    session.invalidate();
    return "redirect:/";
  }

}
