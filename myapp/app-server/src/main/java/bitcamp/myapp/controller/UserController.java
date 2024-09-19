package bitcamp.myapp.controller;

import bitcamp.myapp.annotation.RequestMapping;
import bitcamp.myapp.annotation.RequestParam;
import bitcamp.myapp.service.UserService;
import bitcamp.myapp.vo.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public class UserController {

  private UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @RequestMapping("/user/add")
  public String add(HttpServletRequest req) throws Exception {
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

  @RequestMapping("/user/list")
  public String list(Map<String, Object> map) throws Exception {
    List<User> list = userService.list();
    map.put("list", list);
    return "/user/list.jsp";
  }

  @RequestMapping("/user/view")
  public String view(@RequestParam("no") int userNo, Map<String, Object> map) throws Exception {
    User user = userService.get(userNo);
    map.put("user", user);
    return "/user/view.jsp";
  }

  @RequestMapping("/user/update")
  public String update(HttpServletRequest req) throws Exception {
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

  @RequestMapping("/user/delete")
  public String delete(HttpServletRequest req) throws Exception {
    int userNo = Integer.parseInt(req.getParameter("no"));
    if (userService.delete(userNo)) {
      return "redirect:list";
    } else {
      throw new Exception("없는 회원입니다.");
    }
  }
}
