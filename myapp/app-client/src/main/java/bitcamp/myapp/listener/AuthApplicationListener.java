package bitcamp.myapp.listener;

import bitcamp.context.ApplicationContext;
import bitcamp.listener.ApplicationListener;
import bitcamp.myapp.dao.UserDao;
import bitcamp.myapp.vo.User;
import bitcamp.util.Prompt;

public class AuthApplicationListener implements ApplicationListener {

  @Override
  public void onStart(ApplicationContext ctx) throws Exception {
    String email = Prompt.input("이메일?");
    String password = Prompt.input("암호?");

    UserDao userDao = (UserDao) ctx.getAttribute("userDao");

    User user = userDao.findByEmailAndPassword(email, password);
    if (user == null) {
      // 프로그램 종료
    } else {
      // 프로그램 계속 실행 
    }

  }

}
