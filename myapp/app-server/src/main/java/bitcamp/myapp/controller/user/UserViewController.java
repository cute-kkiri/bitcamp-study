package bitcamp.myapp.controller.user;

import bitcamp.myapp.service.UserService;
import bitcamp.myapp.vo.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserViewController {

  private UserService userService;

  public UserViewController(UserService userService) {
    this.userService = userService;
  }

  public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
    int userNo = Integer.parseInt(req.getParameter("no"));
    User user = userService.get(userNo);
    req.setAttribute("user", user);
    return "/user/view.jsp";
  }
}
