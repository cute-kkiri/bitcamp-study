package bitcamp.context;

import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.dao.DaoFactory;
import bitcamp.myapp.dao.ProjectDao;
import bitcamp.myapp.dao.UserDao;
import bitcamp.myapp.service.*;
import bitcamp.mybatis.SqlSessionFactoryProxy;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApplicationContext {

  private Map<Class<?>, Object> dependencyMap = new HashMap<>();
  private List<Object> controllers = new ArrayList<>();

  public ApplicationContext(String packageName) throws Exception {
    try {
      dependencyMap.put(
              SqlSessionFactory.class,
              createSqlSessionFactory());
      dependencyMap.put(
              DaoFactory.class,
              createDaoFactory((SqlSessionFactory) dependencyMap.get(SqlSessionFactory.class)));
      dependencyMap.put(
              UserDao.class,
              createUserDao((DaoFactory) dependencyMap.get(DaoFactory.class)));
      dependencyMap.put(
              BoardDao.class,
              createBoardDao((DaoFactory) dependencyMap.get(DaoFactory.class)));
      dependencyMap.put(
              ProjectDao.class,
              createProjectDao((DaoFactory) dependencyMap.get(DaoFactory.class)));

      dependencyMap.put(
              UserService.class,
              createUserService(
                      (UserDao) dependencyMap.get(UserDao.class),
                      (SqlSessionFactory) dependencyMap.get(SqlSessionFactory.class)));

      dependencyMap.put(
              BoardService.class,
              createBoardService(
                      (BoardDao) dependencyMap.get(BoardDao.class),
                      (SqlSessionFactory) dependencyMap.get(SqlSessionFactory.class)));

      dependencyMap.put(
              ProjectService.class,
              createProjectService(
                      (ProjectDao) dependencyMap.get(ProjectDao.class),
                      (SqlSessionFactory) dependencyMap.get(SqlSessionFactory.class)));

    } catch (Exception e) {
      System.out.println("객체 준비 중 오류 발생!");
      e.printStackTrace();
    }
  }

  public SqlSessionFactory createSqlSessionFactory() throws Exception {
    InputStream inputStream = Resources.getResourceAsStream("config/mybatis-config.xml");
    SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
    SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);

    return new SqlSessionFactoryProxy(sqlSessionFactory);
  }

  public DaoFactory createDaoFactory(SqlSessionFactory sqlSessionFactory) throws Exception {
    return new DaoFactory(sqlSessionFactory);
  }

  public UserDao createUserDao(DaoFactory daoFactory) throws Exception {
    return daoFactory.createObject(UserDao.class);
  }

  public BoardDao createBoardDao(DaoFactory daoFactory) throws Exception {
    return daoFactory.createObject(BoardDao.class);
  }

  public ProjectDao createProjectDao(DaoFactory daoFactory) throws Exception {
    return daoFactory.createObject(ProjectDao.class);
  }

  public UserService createUserService(UserDao userDao, SqlSessionFactory sqlSessionFactory) throws Exception {
    return new DefaultUserService(userDao, sqlSessionFactory);
  }

  public BoardService createBoardService(BoardDao boardDao, SqlSessionFactory sqlSessionFactory) throws Exception {
    return new DefaultBoardService(boardDao, sqlSessionFactory);
  }

  public ProjectService createProjectService(ProjectDao projectDao, SqlSessionFactory sqlSessionFactory) throws Exception {
    return new DefaultProjectService(projectDao, sqlSessionFactory);
  }
}
