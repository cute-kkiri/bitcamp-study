package bitcamp.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebInit4 extends AbstractAnnotationConfigDispatcherServletInitializer {

  @Override
  protected Class<?>[] getRootConfigClasses() {
    // ContextLoaderListener가 사용할
    // IoC 컨테이너를 만들 때 주입하는 Java Config 클래스를 리턴한다.
    // 만약 IoC 설정 클래스를 리턴하지 않으면
    // IoC 컨테이너를 만들지 않을 것이고,
    // IoC 컨테이너를 만들지 않으면
    // ContextLoaderListener도 생성하지 않을 것이다.
    return null;
  }

  @Override
  protected Class<?>[] getServletConfigClasses() {
    // DispatcherServlet이 사용할
    // IoC 컨테이너를 만들 때 주입하는 Java Config 클래스를 리턴한다.
    return new Class<?>[] {bitcamp.AppConfig.class};
  }

  @Override
  protected String[] getServletMappings() {
    return new String[] {"/app/*"};
  }
}
