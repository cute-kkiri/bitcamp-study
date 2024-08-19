package bitcamp.bitbatis;

import java.lang.reflect.Constructor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SqlSession {

  Connection con;

  public SqlSession(Connection con) {
    this.con = con;
  }

  public int insert(String sql, Object... values) throws Exception {
    try (PreparedStatement stmt = con.prepareStatement(sql)) {

      int inparameterIndex = 1;
      for (Object value : values) {
        stmt.setString(inparameterIndex++, value.toString());
      }

      return stmt.executeUpdate();
    }
  }

  public <T> List<T> selectList(String sql, Class<T> type, Object... values) throws Exception {
    try (PreparedStatement stmt = con.prepareStatement(sql)) {

      int inparameterIndex = 1;
      for (Object value : values) {
        stmt.setString(inparameterIndex++, value.toString());
      }

      try (ResultSet rs = stmt.executeQuery()) {

        java.util.List<T> list = new ArrayList<>();

        while (rs.next()) {
          Constructor<T> constructor = type.getConstructor();
          T obj = constructor.newInstance();

          user.setNo(rs.getInt("user_id"));
          user.setName(rs.getString("name"));
          user.setEmail(rs.getString("email"));
          list.add(user);
        }
        return list;
      }
    }
  }
}
