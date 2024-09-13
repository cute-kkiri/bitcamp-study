package bitcamp.myapp.controller.user;

import bitcamp.myapp.service.UserService;
import bitcamp.myapp.vo.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserAddController {

  private UserService userService;

  public UserAddController(UserService userService) {
    this.userService = userService;
  }

  public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
    if (req.getMethod().equals("GET")) {
      return "/user/form.jsp";
      
    } else {
      User user = new User();
      user.setName(req.getParameter("name"));
      user.setEmail(req.getParameter("email"));
      user.setPassword(req.getParameter("password"));
      user.setTel(req.getParameter("tel"));

      userService.add(user);
      return "redirect:list";
    }
  }
}
