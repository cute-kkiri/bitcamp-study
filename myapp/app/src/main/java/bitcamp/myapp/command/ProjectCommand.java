package bitcamp.myapp.command;

public class ProjectCommand {

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
    System.out.println("프로젝트 등록...");
  }

  private static void listProject() {
    System.out.println("프로젝트 목록...");
  }

  private static void viewProject() {
    System.out.println("프로젝트 조회...");
  }

  private static void updateProject() {
    System.out.println("프로젝트 변경...");
  }

  private static void deleteProject() {
    System.out.println("프로젝트 삭제...");
  }

}
