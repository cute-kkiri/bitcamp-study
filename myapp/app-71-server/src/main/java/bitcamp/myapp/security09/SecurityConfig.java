package bitcamp.myapp.security09;

import bitcamp.myapp.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandlerImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  private static final Log log = LogFactory.getLog(SecurityConfig.class);

  public SecurityConfig() {
    log.debug("SecurityConfig 객체 생성됨!");
  }

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    return http
            .csrf().disable()
            .authorizeHttpRequests((authorize) -> authorize
                    .mvcMatchers("/auth/**", "/css/**", "/images/**", "/home", "/", "*/list", "*/view").permitAll()
                    .mvcMatchers("/users/**").hasRole("ADMIN")
                    .anyRequest().authenticated()
            )
            .formLogin(formLoginConfigurer -> {
              formLoginConfigurer
                      .loginPage("/auth/form") // 로그인 폼을 제공하는 URL
                      .loginProcessingUrl("/auth/login") // 클라이언트가 로그인을 하기 위해 요청하는 URL (페이지 컨트롤러와 상관없다)
                      .usernameParameter("email") // 로그인 수행할 때 사용할 사용자 아이디 또는 이메일(principal) 파라미터 명
                      .passwordParameter("password") // 로그인 수행할 때 사용할 사용자 암호(credential) 파라미터 명
                      .successForwardUrl("/auth/success") // 로그인 성공 후 포워딩 할 URL
                      .failureForwardUrl("/auth/failure") // 로그인 실패 후 포워딩 할 URL
                      .permitAll(); // 모든 권한 부여
            })

            // 로그아웃 기본 URL: /logout
            // CSRF가 활성화된 경우:
            // - POST 요청을 해야 한다.
            // - 서버에서 받은 CSRF 토큰을 요청 헤더에 넣어야 한다.
            .logout(Customizer.withDefaults())

            // 권한 오류를 다룰 핸들러 설정
            .exceptionHandling(exceptionHandling -> {
              AccessDeniedHandlerImpl accessDeniedHandler = new AccessDeniedHandlerImpl();
              accessDeniedHandler.setErrorPage("/auth/access-denied");
              exceptionHandling.accessDeniedHandler(accessDeniedHandler);
            })
            .build();
  }

  @Bean
  public UserDetailsService userDetailsService(UserService userService) {
    return new DbUserDetailsService(userService);
  }

  // Spring Security에서 제공하는 암호 인코더 사용하기
  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder() {
      @Override
      public boolean matches(CharSequence rawPassword, String encodedPassword) {
        log.debug("입력 암호(인코딩 전) ===> " + rawPassword);
        log.debug("입력 암호(인코딩 후) ===> " + this.encode(rawPassword));
        log.debug("DB에서 가져온 암호 ===> " + encodedPassword);
        return super.matches(rawPassword, encodedPassword);
      }
    };
  }
}
