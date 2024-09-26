package bitcamp.myapp.config;

import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.dao.DaoFactory;
import bitcamp.myapp.dao.ProjectDao;
import bitcamp.myapp.dao.UserDao;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;

@ComponentScan("bitcamp.myapp")
@EnableWebMvc
@PropertySource("classpath:config/jdbc.properties")
public class AppConfig {

  @Value("${jdbc.driver}")
  String jdbcDriver;

  @Value("${jdbc.url}")
  String jdbcUrl;

  @Value("${jdbc.username}")
  String jdbcUsername;

  @Value("${jdbc.password}")
  String jdbcPassword;

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

  @Bean
  public DataSource dataSource() {
    DriverManagerDataSource ds = new DriverManagerDataSource();
    ds.setDriverClassName(jdbcDriver);
    ds.setUrl(jdbcUrl);
    ds.setUsername(jdbcUsername);
    ds.setPassword(jdbcPassword);
    return ds;
  }

  @Bean
  public SqlSessionFactory sqlSessionFactory(DataSource ds) throws Exception {
//    InputStream inputStream = Resources.getResourceAsStream("config/mybatis-config.xml");
//    SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
//    SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
//
//    return new SqlSessionFactoryProxy(sqlSessionFactory);
    SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
    factoryBean.setDataSource(ds);
  }

  @Bean
  public DaoFactory daoFactory(SqlSessionFactory sqlSessionFactory) throws Exception {
    return new DaoFactory(sqlSessionFactory);
  }

  @Bean
  public UserDao userDao(DaoFactory daoFactory) throws Exception {
    return daoFactory.createObject(UserDao.class);
  }

  @Bean
  public BoardDao boardDao(DaoFactory daoFactory) throws Exception {
    return daoFactory.createObject(BoardDao.class);
  }

  @Bean
  public ProjectDao projectDao(DaoFactory daoFactory) throws Exception {
    return daoFactory.createObject(ProjectDao.class);
  }
}
