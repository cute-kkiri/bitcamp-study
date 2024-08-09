package bitcamp.myapp.dao.mysql;

import bitcamp.myapp.dao.ProjectDao;
import bitcamp.myapp.vo.Project;
import java.sql.Connection;
import java.util.List;

public class ProjectDaoImpl implements ProjectDao {

  private Connection con;

  public ProjectDaoImpl(Connection con) {
    this.con = con;
  }

  @Override
  public boolean insert(Project project) throws Exception {
    return false;
  }

  @Override
  public List<Project> list() throws Exception {

    return List.of();
  }

  @Override
  public Project findBy(int no) throws Exception {
    return null;
  }

  @Override
  public boolean update(Project project) throws Exception {
    return false;
  }

  @Override
  public boolean delete(int no) throws Exception {
    return false;
  }
}
