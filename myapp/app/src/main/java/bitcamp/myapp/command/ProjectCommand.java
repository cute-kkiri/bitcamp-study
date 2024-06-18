package bitcamp.myapp.command;

import bitcamp.myapp.util.Prompt;
import bitcamp.myapp.vo.Project;

public class ProjectCommand {

  private static final int MAX_SIZE = 100;
  private static Project[] projects = new Project[MAX_SIZE];
  private static int projectLength = 0;

  public static void executeProjectCommand(String command) {
    System.out.printf("[%s]\n", command);
    switch (command) {
      case "등록":
        addProject();
        break;
      case "조회":
        viewProject();
        break;
      case "목록":
        listProject();
        break;
      case "변경":
        updateProject();
        break;
      case "삭제":
        deleteProject();
        break;
    }
  }

  private static void addProject() {
    Project project = new Project();
    project.setTitle(Prompt.input("프로젝트명?"));
    project.setDescription(Prompt.input("설명?"));
    project.setStartDate(Prompt.input("시작일?"));
    project.setEndDate(Prompt.input("종료일?"));

    projects[projectLength++] = project;
    System.out.println("등록했습니다.");
  }

  private static void listProject() {
    System.out.println("번호 프로젝트 기간");
    for (int i = 0; i < projectLength; i++) {
      Project project = projects[i];
      System.out.printf("%d %s %s ~ %s\n",
          (i + 1), project.getTitle(), project.getStartDate(), project.getEndDate());
    }
  }

  private static void viewProject() {
    int projectNo = Integer.parseInt(Prompt.input("프로젝트 번호?"));
    if (projectNo < 1 || projectNo > projectLength) {
      System.out.println("없는 프로젝트입니다.");
      return;
    }
    Project project = projects[projectNo - 1];
    System.out.printf("프로젝트명: %s\n", project.getTitle());
    System.out.printf("설명: %s\n", project.getDescription());
    System.out.printf("기간: %s ~ %s\n", project.getStartDate(), project.getEndDate());
  }

  private static void updateProject() {
    int projectNo = Integer.parseInt(Prompt.input("프로젝트 번호?"));
    if (projectNo < 1 || projectNo > projectLength) {
      System.out.println("없는 프로젝트입니다.");
      return;
    }
    Project project = projects[projectNo - 1];
    project.setTitle(Prompt.input(String.format("프로젝트명(%s)?", project.getTitle())));
    project.setDescription(Prompt.input(String.format("설명(%s)?", project.getDescription())));
    project.setStartDate(Prompt.input(String.format("시작일(%s)?", project.getStartDate())));
    project.setEndDate(Prompt.input(String.format("종료일(%s)?", project.getEndDate())));
    System.out.println("변경 했습니다.");
  }

  private static void deleteProject() {
    System.out.println("프로젝트 삭제...");
  }

}
