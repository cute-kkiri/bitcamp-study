package bitcamp.myapp;

import bitcamp.menu.MenuGroup;
import bitcamp.menu.MenuItem;
import bitcamp.myapp.command.HelpCommand;
import bitcamp.myapp.command.HistoryCommand;
import bitcamp.myapp.command.board.BoardAddCommand;
import bitcamp.myapp.command.board.BoardDeleteCommand;
import bitcamp.myapp.command.board.BoardListCommand;
import bitcamp.myapp.command.board.BoardUpdateCommand;
import bitcamp.myapp.command.board.BoardViewCommand;
import bitcamp.myapp.command.project.ProjectAddCommand;
import bitcamp.myapp.command.project.ProjectDeleteCommand;
import bitcamp.myapp.command.project.ProjectListCommand;
import bitcamp.myapp.command.project.ProjectMemberHandler;
import bitcamp.myapp.command.project.ProjectUpdateCommand;
import bitcamp.myapp.command.project.ProjectViewCommand;
import bitcamp.myapp.command.user.UserAddCommand;
import bitcamp.myapp.command.user.UserDeleteCommand;
import bitcamp.myapp.command.user.UserListCommand;
import bitcamp.myapp.command.user.UserUpdateCommand;
import bitcamp.myapp.command.user.UserViewCommand;
import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.dao.ListBoardDao;
import bitcamp.myapp.dao.ListProjectDao;
import bitcamp.myapp.dao.ListUserDao;
import bitcamp.myapp.dao.ProjectDao;
import bitcamp.myapp.dao.UserDao;
import bitcamp.myapp.listener.ApplicationListener;
import bitcamp.myapp.listener.StyleApplicationListener;
import bitcamp.util.Prompt;
import java.util.ArrayList;
import java.util.List;

public class App {


  MenuGroup mainMenu = new MenuGroup("메인");

  List<ApplicationListener> listeners = new ArrayList<>();

  UserDao userDao;
  BoardDao boardDao;
  ProjectDao projectDao;

  public static void main(String[] args) {
    App app = new App();

    // 애플리케이션이 시작되거나 종료될 때 알림 받을 객체의 연락처를 등록한다.
    //app.addApplicationListener(new HelloApplicationListener());
    app.addApplicationListener(new StyleApplicationListener());

    app.execute();
  }

  public void init() {

    // 애플리케이션이 시작될 때 리스너에게 알린다.
    for (ApplicationListener listener : listeners) {
      try {
        listener.onStart();
      } catch (Exception e) {
        System.out.println("리스너 실행 중 오류 발생!");
      }
    }

//    userDao = new MapUserDao("data.xlsx");
//    boardDao = new MapBoardDao("data.xlsx");
//    projectDao = new MapProjectDao("data.xlsx", userDao);

    userDao = new ListUserDao("data.xlsx");
    boardDao = new ListBoardDao("data.xlsx");
    projectDao = new ListProjectDao("data.xlsx", userDao);

    MenuGroup userMenu = new MenuGroup("회원");
    userMenu.add(new MenuItem("등록", new UserAddCommand(userDao)));
    userMenu.add(new MenuItem("목록", new UserListCommand(userDao)));
    userMenu.add(new MenuItem("조회", new UserViewCommand(userDao)));
    userMenu.add(new MenuItem("변경", new UserUpdateCommand(userDao)));
    userMenu.add(new MenuItem("삭제", new UserDeleteCommand(userDao)));
    mainMenu.add(userMenu);

    MenuGroup projectMenu = new MenuGroup("프로젝트");
    ProjectMemberHandler memberHandler = new ProjectMemberHandler(userDao);
    projectMenu.add(
        new MenuItem("등록", new ProjectAddCommand(projectDao, memberHandler)));
    projectMenu.add(new MenuItem("목록", new ProjectListCommand(projectDao)));
    projectMenu.add(new MenuItem("조회", new ProjectViewCommand(projectDao)));
    projectMenu.add(new MenuItem("변경", new ProjectUpdateCommand(projectDao, memberHandler)));
    projectMenu.add(new MenuItem("삭제", new ProjectDeleteCommand(projectDao)));
    mainMenu.add(projectMenu);

    MenuGroup boardMenu = new MenuGroup("게시판");
    boardMenu.add(new MenuItem("등록", new BoardAddCommand(boardDao)));
    boardMenu.add(new MenuItem("목록", new BoardListCommand(boardDao)));
    boardMenu.add(new MenuItem("조회", new BoardViewCommand(boardDao)));
    boardMenu.add(new MenuItem("변경", new BoardUpdateCommand(boardDao)));
    boardMenu.add(new MenuItem("삭제", new BoardDeleteCommand(boardDao)));
    mainMenu.add(boardMenu);

    mainMenu.add(new MenuItem("도움말", new HelpCommand()));
    mainMenu.add(new MenuItem("명령내역", new HistoryCommand()));

    mainMenu.setExitMenuTitle("종료");
  }

  private void addApplicationListener(ApplicationListener listener) {
    listeners.add(listener);
  }

  private void removeApplicationListener(ApplicationListener listener) {
    listeners.remove(listener);
  }

  void execute() {

    init();

    String appTitle = "[프로젝트 관리 시스템]";
    String line = "----------------------------------";

    try {
      mainMenu.execute();

    } catch (Exception ex) {
      System.out.println("실행 오류!");
      ex.printStackTrace();

    } finally {
      try {
        //((MapUserDao) userDao).save();
        ((ListUserDao) userDao).save();
      } catch (Exception e) {
        System.out.println("회원 데이터 저장 중 오류 발생!");
        e.printStackTrace();
        System.out.println();
      }

      try {
        //((MapBoardDao) boardDao).save();
        ((ListBoardDao) boardDao).save();
      } catch (Exception e) {
        System.out.println("게시글 데이터 저장 중 오류 발생!");
        e.printStackTrace();
        System.out.println();
      }

      try {
        //((MapProjectDao) projectDao).save();
        ((ListProjectDao) projectDao).save();
      } catch (Exception e) {
        System.out.println("프로젝트 데이터 저장 중 오류 발생!");
        e.printStackTrace();
        System.out.println();
      }
    }

    System.out.println("종료합니다.");

    Prompt.close();

    // 애플리케이션이 종료될 때 리스너에게 알린다.
    for (ApplicationListener listener : listeners) {
      try {
        listener.onShutdown();
      } catch (Exception e) {
        System.out.println("리스너 실행 중 오류 발생!");
      }
    }
  }
}
