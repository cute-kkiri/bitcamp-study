package bitcamp.myapp;

import bitcamp.myapp.interceptor.AdminInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@SpringBootApplication
@PropertySource("file:${user.home}/config/ncp.properties")
@EnableTransactionManagement
@Controller
public class ServerApp implements WebMvcConfigurer {

  @Autowired
  ApplicationContext appCtx;

  public ServerApp() {
    // AWS 경고 메시지 로깅 비활성화
    System.getProperties().setProperty("aws.java.v1.disableDeprecationAnnouncement", "true");
  }

  public static void main(String[] args) {
    SpringApplication.run(ServerApp.class, args);
  }

  @GetMapping("/hello")
  @ResponseBody
  public String hello() {
    return "Hello!";
  }

  @Bean
  public ViewResolver viewResolver() {
    InternalResourceViewResolver vr = new InternalResourceViewResolver();
    vr.setPrefix("/WEB-INF/jsp/");
    vr.setSuffix(".jsp");
    return vr;
  }

  @Bean
  public MultipartResolver multipartResolver() {
    return new StandardServletMultipartResolver();
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(new AdminInterceptor())
            .addPathPatterns("/users*");
  }
}
