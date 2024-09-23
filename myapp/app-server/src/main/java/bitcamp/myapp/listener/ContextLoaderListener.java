package bitcamp.myapp.listener;

import bitcamp.myapp.context.ApplicationContext;
import org.apache.ibatis.session.SqlSessionFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener // 서블릿 컨테이너에 이 클래스를 배치하는 태그다.
public class ContextLoaderListener implements ServletContextListener {


  @Override
  public void contextInitialized(ServletContextEvent sce) {

    try {
      ServletContext ctx = sce.getServletContext();

      ApplicationContext iocContainer = new ApplicationContext(ctx);

      ctx.setAttribute("sqlSessionFactory", iocContainer.getBean(SqlSessionFactory.class));
      ctx.setAttribute("controllers", iocContainer.getControllers());


    } catch (Exception e) {
      System.out.println("서비스 객체 준비 중 오류 발생!");
      e.printStackTrace();
    }
  }


}
