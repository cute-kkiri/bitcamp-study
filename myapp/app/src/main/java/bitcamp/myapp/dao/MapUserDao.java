package bitcamp.myapp.dao;

import bitcamp.myapp.vo.User;
import java.util.List;

public class MapUserDao implements UserDao {

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
