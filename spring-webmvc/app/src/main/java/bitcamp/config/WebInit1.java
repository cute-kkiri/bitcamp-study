package bitcamp.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public class WebInit1 /*implements WebApplicationInitializer*/ {

  //@Override
  public void onStartup(ServletContext ctx) throws ServletException {
    System.out.println("WebInit1.onStartup() 호출됨!");
    /*
    // DispatcherServlet의 IoC 컨테이너 생성
    AnnotationConfigWebApplicationContext iocContainer =
        new AnnotationConfigWebApplicationContext();
    iocContainer.setServletContext(ctx);
    iocContainer.register(bitcamp.AppConfig.class);

    // DispatcherServlet 객체 생성
    DispatcherServlet frontController = new DispatcherServlet(iocContainer);

    // 서블릿 컨테이너에 등록
    Dynamic options = ctx.addServlet("app", frontController);

    // 서블릿 설정
    options.addMapping("/app/*");
     */
  }
}
