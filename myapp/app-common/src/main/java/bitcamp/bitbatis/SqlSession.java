package bitcamp.bitbatis;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

  public int update(String sql, Object... values) throws Exception {
    return insert(sql, values);
  }

  public int delete(String sql, Object... values) throws Exception {
    return insert(sql, values);
  }

  public <T> List<T> selectList(String sql, Class<T> type, Object... values) throws Exception {
    try (PreparedStatement stmt = con.prepareStatement(sql)) {

      int inparameterIndex = 1;
      for (Object value : values) {
        stmt.setString(inparameterIndex++, value.toString());
      }

      try (ResultSet rs = stmt.executeQuery()) {

        Map<String, Method> setterMap = getSetterMap(type, rs);
        Set<String> columnNames = setterMap.keySet();

        java.util.List<T> list = new ArrayList<>();
        while (rs.next()) {
          T obj = createObject(type);
          for (String columnName : columnNames) {
            Method setter = setterMap.get(columnName);
            callSetter(obj, setter, rs, columnName);
          }
          list.add(obj);
        }
        return list;
      }
    }
  }

  public <T> T selectOne(String sql, Class<T> type, Object... values) throws Exception {
    try (PreparedStatement stmt = con.prepareStatement(sql)) {

      int inparameterIndex = 1;
      for (Object value : values) {
        stmt.setString(inparameterIndex++, value.toString());
      }

      try (ResultSet rs = stmt.executeQuery()) {

        Map<String, Method> setterMap = getSetterMap(type, rs);
        Set<String> columnNames = setterMap.keySet();

        if (rs.next()) {
          T obj = createObject(type);
          for (String columnName : columnNames) {
            Method setter = setterMap.get(columnName);
            callSetter(obj, setter, rs, columnName);
          }
          return obj;
        }
        return null;
      }
    }
  }

  private <T> Map<String, Method> getSetterMap(Class<T> type, ResultSet rs) throws Exception {
    ResultSetMetaData metaData = rs.getMetaData();

    Map<String, Method> setterMap = new HashMap<>();

    for (int i = 1; i <= metaData.getColumnCount(); i++) {
      String columnName = metaData.getColumnLabel(i);
      setterMap.put(columnName, findSetter(type, columnName));
    }

    return setterMap;
  }

  private <T> Method findSetter(Class<T> type, String columnName) {
    String setterName = "set" + Character.toUpperCase(columnName.charAt(0)) +
        columnName.substring(1);
    Method[] methods = type.getMethods();
    for (Method m : methods) {
      if (m.getName().equals(setterName)) {
        return m;
      }
    }
    return null;
  }

  private <T> T createObject(Class<T> type) throws Exception {
    Constructor<T> constructor = type.getConstructor();
    return constructor.newInstance();
  }

  private void callSetter(Object obj, Method setter, ResultSet rs, String columnName)
      throws Exception {
    if (setter == null) {
      return;
    }
    Type parameterType = setter.getParameterTypes()[0];
    if (parameterType == int.class) {
      setter.invoke(obj, rs.getInt(columnName));
    } else if (parameterType == String.class) {
      setter.invoke(obj, rs.getString(columnName));
    } else if (parameterType == Date.class || parameterType == java.sql.Date.class) {
      setter.invoke(obj, rs.getDate(columnName));
    }
  }

}
