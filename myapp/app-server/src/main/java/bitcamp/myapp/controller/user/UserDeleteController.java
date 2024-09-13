package bitcamp.myapp.controller.user;

import bitcamp.myapp.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserDeleteController {

  private UserService userService;

  public UserDeleteController(UserService userService) {
    this.userService = userService;
  }

  public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
    int userNo = Integer.parseInt(req.getParameter("no"));
    if (userService.delete(userNo)) {
      return "redirect:list";
    } else {
      throw new Exception("없는 회원입니다.");
    }
  }
}
