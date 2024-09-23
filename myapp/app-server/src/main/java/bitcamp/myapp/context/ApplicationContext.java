package bitcamp.myapp.context;

import bitcamp.myapp.annotation.Bean;
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
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApplicationContext {

  private Map<Class<?>, Object> dependencyMap = new HashMap<>();
  private List<Object> controllers = new ArrayList<>();

  public ApplicationContext(ServletContext ctx) throws Exception {
    try {
      dependencyMap.put(ServletContext.class, ctx);

      processBeanAnnotation();

      createControllers();

    } catch (Exception e) {
      System.out.println("객체 준비 중 오류 발생!");
      e.printStackTrace();
    }
  }

  private void processBeanAnnotation() {
    Class<?> type = this.getClass();

    List<Method> factoryMethods = getFactoryMethods(type);

    int beforeSize = 0;
    do {
      beforeSize = factoryMethods.size();
      if (beforeSize == 0) {
        break;
      }
      System.out.println(beforeSize);
      factoryMethods = callFactoryMethods(factoryMethods);
    } while (beforeSize > factoryMethods.size());
    
    System.out.println("남아 있는 팩토리 메서드:");
    for (Method m : factoryMethods) {
      System.out.println("  - " + m.getName());
    }
  }

  private List<Method> callFactoryMethods(List<Method> factoryMethods) {
    ArrayList<Method> waitingFactoryMethods = new ArrayList<>();
    for (Method factoryMethod : factoryMethods) {
      try {
        Class<?>[] paramTypes = factoryMethod.getParameterTypes();
        Object[] args = prepareMethodArguments(paramTypes);
        dependencyMap.put(factoryMethod.getReturnType(), factoryMethod.invoke(this, args));
      } catch (Exception e) {
        // 메서드를 호출할 때 넘겨줄 아규먼트의 값 중 한 개라도 없다면 대기열에 추가
        waitingFactoryMethods.add(factoryMethod);
      }
    }
    return waitingFactoryMethods;
  }

  private List<Method> getFactoryMethods(Class<?> type) {
    Method[] methods = type.getDeclaredMethods();
    ArrayList<Method> list = new ArrayList<>();

    for (Method m : methods) {
      Bean beanAnno = m.getAnnotation(Bean.class);
      if (beanAnno == null) {
        continue;
      }
      list.add(m);
    }
    return list;
  }

  public Object getBean(Class<?> type) {
    return dependencyMap.get(type);
  }

  public List<Object> getControllers() {
    return controllers;
  }

  @Bean
  public SqlSessionFactory createSqlSessionFactory() throws Exception {
    InputStream inputStream = Resources.getResourceAsStream("config/mybatis-config.xml");
    SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
    SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);

    return new SqlSessionFactoryProxy(sqlSessionFactory);
  }

  @Bean
  public DaoFactory createDaoFactory(SqlSessionFactory sqlSessionFactory) throws Exception {
    return new DaoFactory(sqlSessionFactory);
  }

  @Bean
  public UserDao createUserDao(DaoFactory daoFactory) throws Exception {
    return daoFactory.createObject(UserDao.class);
  }

  @Bean
  public BoardDao createBoardDao(DaoFactory daoFactory) throws Exception {
    return daoFactory.createObject(BoardDao.class);
  }

  @Bean
  public ProjectDao createProjectDao(DaoFactory daoFactory) throws Exception {
    return daoFactory.createObject(ProjectDao.class);
  }

  @Bean
  public UserService createUserService(UserDao userDao, SqlSessionFactory sqlSessionFactory) throws Exception {
    return new DefaultUserService(userDao, sqlSessionFactory);
  }

  @Bean
  public BoardService createBoardService(BoardDao boardDao, SqlSessionFactory sqlSessionFactory) throws Exception {
    return new DefaultBoardService(boardDao, sqlSessionFactory);
  }

  @Bean
  public ProjectService createProjectService(ProjectDao projectDao, SqlSessionFactory sqlSessionFactory) throws Exception {
    return new DefaultProjectService(projectDao, sqlSessionFactory);
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

        createObject(clazz);
      }
    }
  }

  private void createObject(Class<?> clazz) throws Exception {
    Constructor<?> constructor = clazz.getConstructors()[0];

    Class<?>[] paramTypes = constructor.getParameterTypes();
    Object[] args = prepareMethodArguments(paramTypes);

    controllers.add(constructor.newInstance(args));
  }

  private Object[] prepareMethodArguments(Class<?>[] paramTypes) throws Exception {
    Object[] args = new Object[paramTypes.length];
    for (int i = 0; i < paramTypes.length; i++) {
      Object arg = dependencyMap.get(paramTypes[i]);
      if (arg == null) {
        throw new Exception("해당 타입의 값을 찾을 수 없습니다.");
      }
      args[i] = arg;
    }
    return args;
  }
}
