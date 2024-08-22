package bitcamp.myapp.dao;

import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DaoFactory {

  private SqlSession sqlSession;

  public DaoFactory(SqlSession sqlSession) {
    this.sqlSession = sqlSession;
  }

  public <T> T createObject(Class<T> daoType) throws Exception {
    return (T) Proxy.newProxyInstance(
            this.getClass().getClassLoader(),
            new Class[]{daoType},
            this::invoke);
  }

  public Object invoke(Object proxy, Method method, Object[] args) throws Exception {
    String namespace = proxy.getClass().getInterfaces()[0].getSimpleName();
    String sqlId = method.getName();

    if (method.getName().equals("list")) {
      return sqlSession.selectList(namespace + "." + sqlId);
    }
    return null;
  }
}
