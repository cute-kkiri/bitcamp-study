package bitcamp.myapp.listener;

import bitcamp.myapp.annotation.Controller;
import bitcamp.myapp.service.BoardService;
import bitcamp.myapp.service.ProjectService;
import bitcamp.myapp.service.UserService;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.File;
import java.lang.reflect.Constructor;

@WebListener // 서블릿 컨테이너에 이 클래스를 배치하는 태그다.
public class ContextLoaderListener implements ServletContextListener {


  @Override
  public void contextInitialized(ServletContextEvent sce) {

    try {
      ServletContext ctx = sce.getServletContext();
      ctx.setAttribute("sqlSessionFactory", sqlSessionFactoryProxy);
      ctx.setAttribute("controllers", controllers);

      dependencyMap.put(ServletContext.class, ctx);
      dependencyMap.put(UserService.class, userService);
      dependencyMap.put(BoardService.class, boardService);
      dependencyMap.put(ProjectService.class, projectService);

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

        createObject(clazz);
      }
    }
  }

  private void createObject(Class<?> clazz) throws Exception {
    Constructor<?> constructor = clazz.getConstructors()[0];

    Class<?>[] paramTypes = constructor.getParameterTypes();
    Object[] args = prepareConstructorArguments(paramTypes);

    controllers.add(constructor.newInstance(args));
  }

  private Object[] prepareConstructorArguments(Class<?>[] paramTypes) throws Exception {
    Object[] args = new Object[paramTypes.length];
    for (int i = 0; i < paramTypes.length; i++) {
      args[i] = dependencyMap.get(paramTypes[i]);
    }
    return args;
  }

}
