package bitcamp.config;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

public class WebInit3 /*extends AbstractDispatcherServletInitializer*/ {

  //@Override
  protected WebApplicationContext createRootApplicationContext() {
    // ContextLoaderListener가 사용할 IoC 컨테이너를 리턴한다.
    // 만약 IoC 컨테이너를 리턴하지
    // ContextLoaderListener는 생성하지 않는다.

    return null;
  }

  //@Override
  protected WebApplicationContext createServletApplicationContext() {
    // DispatcherServlet이 사용할 IoC 컨테이너를 리턴한다.
    System.out.println("WebInit3.createServletApplicationContext() 호출됨!");

    AnnotationConfigWebApplicationContext iocContainer =
        new AnnotationConfigWebApplicationContext();
    //iocContainer.setServletContext(this.get);
    iocContainer.register(bitcamp.AppConfig.class);

    return iocContainer;
  }

  //@Override
  protected String[] getServletMappings() {
    return new String[] {"/app/*"};
  }
}
