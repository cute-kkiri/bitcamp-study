package bitcamp.myapp.controller.user;

import bitcamp.myapp.service.UserService;
import bitcamp.myapp.vo.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class UserListController {

  private UserService userService;

  public UserListController(UserService userService) {
    this.userService = userService;
  }

  public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
    try {
      List<User> list = userService.list();
      req.setAttribute("list", list);
      req.setAttribute("viewName", "/user/list.jsp");

    } catch (Exception e) {
      req.setAttribute("exception", e);
    }
  }
}
