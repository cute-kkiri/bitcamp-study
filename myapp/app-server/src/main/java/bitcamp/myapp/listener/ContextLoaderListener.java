package bitcamp.myapp.listener;

import bitcamp.myapp.annotation.Controller;
import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.dao.DaoFactory;
import bitcamp.myapp.dao.ProjectDao;
import bitcamp.myapp.dao.UserDao;
import bitcamp.myapp.service.*;
import bitcamp.mybatis.SqlSessionFactoryProxy;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@WebListener // 서블릿 컨테이너에 이 클래스를 배치하는 태그다.
public class ContextLoaderListener implements ServletContextListener {

  private List<Object> controllers = new ArrayList<>();

  @Override
  public void contextInitialized(ServletContextEvent sce) {
    // 서블릿 컨테이너가 실행될 때 호출된다.
    try {
      System.out.println("서비스 관련 객체 준비!");

      InputStream inputStream = Resources.getResourceAsStream("config/mybatis-config.xml");
      SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
      SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);

      SqlSessionFactoryProxy sqlSessionFactoryProxy = new SqlSessionFactoryProxy(sqlSessionFactory);

      DaoFactory daoFactory = new DaoFactory(sqlSessionFactoryProxy);

      UserDao userDao = daoFactory.createObject(UserDao.class);
      BoardDao boardDao = daoFactory.createObject(BoardDao.class);
      ProjectDao projectDao = daoFactory.createObject(ProjectDao.class);

      UserService userService = new DefaultUserService(userDao, sqlSessionFactoryProxy);
      BoardService boardService = new DefaultBoardService(boardDao, sqlSessionFactoryProxy);
      ProjectService projectService = new DefaultProjectService(projectDao, sqlSessionFactoryProxy);

      ServletContext ctx = sce.getServletContext();
      ctx.setAttribute("sqlSessionFactory", sqlSessionFactoryProxy);
      ctx.setAttribute("controllers", controllers);

      createControllers();

    } catch (Exception e) {
      System.out.println("서비스 객체 준비 중 오류 발생!");
      e.printStackTrace();
    }
  }

  private void createControllers() throws Exception {
    // 컴파일된 클래스 파일이 놓이는 폴더에서 클래스 파일을 찾는다.
    File dir = new File("build/classes/java/main");

    searchClasses(dir, "");
  }

  private void searchClasses(File dir, String packageName) throws Exception {
    File[] files = dir.listFiles();

    if (packageName.length() > 0) {
      packageName += ".";
    }

    for (File file : files) {
      if (file.isDirectory()) {
        searchClasses(file, packageName + file.getName());
      } else {
        if (file.getName().contains("$")) {
          continue;
        }
        String className = packageName + file.getName().replace(".class", "");

        Class<?> clazz = Class.forName(className);
        Controller controllerAnno = clazz.getAnnotation(Controller.class);
        if (controllerAnno == null) {
          continue;
        }

        System.out.println(className);
      }
    }
  }

}
