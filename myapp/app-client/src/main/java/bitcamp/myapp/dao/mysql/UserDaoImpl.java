package bitcamp.myapp.dao.mysql;

import bitcamp.myapp.dao.UserDao;
import bitcamp.myapp.vo.User;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoImpl implements UserDao {

  private SqlSession sqlSession;

  public UserDaoImpl(SqlSession sqlSession) {
    this.sqlSession = sqlSession;
  }

  @Override
  public boolean insert(User user) throws Exception {
    sqlSession.insert("aaa.sql2", user);
    return true;
  }

  @Override
  public List<User> list() throws Exception {
    return sqlSession.selectList("aaa.sql1");
  }

  @Override
  public User findBy(int no) throws Exception {
    return sqlSession.selectOne("aaa.sql3", no);
  }

  @Override
  public User findByEmailAndPassword(String email, String password) throws Exception {
    Map<String, Object> values = new HashMap<>();
    values.put("email", email);
    values.put("password", password);

    return sqlSession.selectOne("aaa.sql4", values);
  }

  @Override
  public boolean update(User user) throws Exception {
    int count = sqlSession.update("aaa.sql5", user);
    return count > 0;
  }

  @Override
  public boolean delete(int no) throws Exception {
    int count = sqlSession.delete("aaa.sql6", no);
    return count > 0;
  }
}
