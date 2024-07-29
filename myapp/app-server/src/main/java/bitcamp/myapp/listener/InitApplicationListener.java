package bitcamp.myapp.listener;

import bitcamp.context.ApplicationContext;
import bitcamp.listener.ApplicationListener;
import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.dao.ListBoardDao;
import bitcamp.myapp.dao.ListProjectDao;
import bitcamp.myapp.dao.ListUserDao;
import bitcamp.myapp.dao.ProjectDao;
import bitcamp.myapp.dao.UserDao;
import bitcamp.myapp.dao.skel.UserDaoSkel;

public class InitApplicationListener implements ApplicationListener {

  UserDao userDao;
  BoardDao boardDao;
  ProjectDao projectDao;

  @Override
  public void onStart(ApplicationContext ctx) {
    userDao = new ListUserDao("data.xlsx");
    boardDao = new ListBoardDao("data.xlsx");
    projectDao = new ListProjectDao("data.xlsx", userDao);

    UserDaoSkel userDaoSkel = new UserDaoSkel(userDao);

    ctx.setAttribute("userDaoSkel", userDaoSkel);
  }

  @Override
  public void onShutdown(ApplicationContext ctx) {
    try {
      ((ListUserDao) userDao).save();
    } catch (Exception e) {
      System.out.println("회원 데이터 저장 중 오류 발생!");
      e.printStackTrace();
      System.out.println();
    }

    try {
      ((ListBoardDao) boardDao).save();
    } catch (Exception e) {
      System.out.println("게시글 데이터 저장 중 오류 발생!");
      e.printStackTrace();
      System.out.println();
    }

    try {
      ((ListProjectDao) projectDao).save();
    } catch (Exception e) {
      System.out.println("프로젝트 데이터 저장 중 오류 발생!");
      e.printStackTrace();
      System.out.println();
    }
  }
}
