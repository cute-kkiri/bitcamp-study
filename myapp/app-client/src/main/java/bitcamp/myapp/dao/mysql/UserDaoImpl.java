package bitcamp.myapp.dao.mysql;

import bitcamp.myapp.dao.UserDao;
import bitcamp.myapp.vo.User;
import java.sql.Connection;
import java.util.List;

public class UserDaoImpl implements UserDao {

  private Connection con;

  public UserDaoImpl(Connection con) {
    this.con = con;
  }

  @Override
  public boolean insert(User user) throws Exception {
    return false;
  }

  @Override
  public List<User> list() throws Exception {
    return List.of();
  }

  @Override
  public User findBy(int no) throws Exception {
    return null;
  }

  @Override
  public boolean update(User user) throws Exception {
    return false;
  }

  @Override
  public boolean delete(int no) throws Exception {
    return false;
  }
}
