package bitcamp.myapp.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebApplicationInitializerImpl extends AbstractAnnotationConfigDispatcherServletInitializer {
  @Override
  protected Class<?>[] getRootConfigClasses() {
    // ContextLoaderListener의 IoC 컨테이너 설정
    // - DB 관련 객체 준비
    // - 서비스 관련 객체 준비
    return new Class[]{RootConfig.class};
  }

  @Override
  protected Class<?>[] getServletConfigClasses() {
    // DispatcherServlet의 IoC 컨테이너 설정
    // - 웹 관련 객체 준비
    return new Class[]{AppConfig.class};
  }

  @Override
  protected String[] getServletMappings() {
    return new String[]{"/app/*"};
  }
  
}
