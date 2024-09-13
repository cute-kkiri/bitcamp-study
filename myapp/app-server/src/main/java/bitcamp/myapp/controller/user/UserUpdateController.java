package bitcamp.myapp.controller.user;

import bitcamp.myapp.service.UserService;
import bitcamp.myapp.vo.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserUpdateController {

  private UserService userService;

  public UserUpdateController(UserService userService) {
    this.userService = userService;
  }

  public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
    User user = new User();
    user.setNo(Integer.parseInt(req.getParameter("no")));
    user.setName(req.getParameter("name"));
    user.setEmail(req.getParameter("email"));
    user.setPassword(req.getParameter("password"));
    user.setTel(req.getParameter("tel"));

    if (userService.update(user)) {
      return "redirect:list";
    } else {
      throw new Exception("없는 회원입니다!");
    }
  }

}
