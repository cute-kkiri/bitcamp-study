package bitcamp.myapp.controller;

import bitcamp.myapp.service.ProjectService;
import bitcamp.myapp.service.UserService;
import bitcamp.myapp.vo.Project;
import bitcamp.myapp.vo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ProjectController {

  private ProjectService projectService;
  private UserService userService;

  public ProjectController(ProjectService projectService, UserService userService) {
    this.projectService = projectService;
    this.userService = userService;
  }

  @GetMapping("/project/form1")
  public String form1() {
    return "/project/form1.jsp";
  }

  @PostMapping("/project/form2")
  public ModelAndView form2(Project project, HttpSession session) throws Exception {
    session.setAttribute("project", project);
    List<User> users = userService.list();

    ModelAndView mv = new ModelAndView();
    mv.addObject("users", users);
    mv.setViewName("/project/form2.jsp");
    return mv;
  }

  @PostMapping("/project/form3")
  public String form3(
          int[] memberNos,
          HttpSession session) throws Exception {

    Project project = (Project) session.getAttribute("project");

    if (memberNos.length > 0) {
      ArrayList<User> members = new ArrayList<>();
      for (int memberNo : memberNos) {
        User user = userService.get(memberNo);
        members.add(user);
      }
      project.setMembers(members);
    }

    return "/project/form3.jsp";
  }

  @PostMapping("/project/add")
  public String add(HttpSession session) throws Exception {
    Project project = (Project) session.getAttribute("project");
    projectService.add(project);
    session.removeAttribute("project");
    return "redirect:list";
  }

  @GetMapping("/project/list")
  public String list(Model model) throws Exception {
    List<Project> list = projectService.list();
    model.addAttribute("list", list);
    return "/project/list.jsp";
  }

  @GetMapping("/project/view")
  public String view(int no, Model model) throws Exception {
    Project project = projectService.get(no);
    model.addAttribute("project", project);

    List<User> users = userService.list();
    model.addAttribute("users", users);
    return "/project/view.jsp";
  }

  @PostMapping("/project/update")
  public String update(
          Project project,
          int[] memberNos) throws Exception {

    if (memberNos.length > 0) {
      ArrayList<User> members = new ArrayList<>();
      for (int memberNo : memberNos) {
        members.add(new User(memberNo));
      }
      project.setMembers(members);
    }

    if (!projectService.update(project)) {
      throw new Exception("없는 프로젝트입니다!");
    }
    return "redirect:list";
  }

  @GetMapping("/project/delete")
  public String delete(int no) throws Exception {
    if (projectService.delete(no)) {
      return "redirect:list";
    } else {
      throw new Exception("없는 프로젝트입니다.");
    }
  }
}
