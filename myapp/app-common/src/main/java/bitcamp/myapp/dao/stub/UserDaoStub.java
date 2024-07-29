package bitcamp.myapp.dao.stub;

import bitcamp.myapp.dao.UserDao;
import bitcamp.myapp.vo.User;
import bitcamp.net.ResponseStatus;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

public class UserDaoStub implements UserDao {

  private ObjectInputStream in;
  private ObjectOutputStream out;
  private String dataName;

  public UserDaoStub(Socket socket, String dataName) throws Exception {
    in = new ObjectInputStream(socket.getInputStream());
    out = new ObjectOutputStream(socket.getOutputStream());
    this.dataName = dataName;
  }

  @Override
  public boolean insert(User user) throws Exception {
    out.writeUTF(dataName);
    out.writeUTF("insert");
    out.writeObject(user);
    out.flush();

    if (in.readUTF().equals(ResponseStatus.SUCCESS)) {
      return true;
    }

    return false;
  }

  @Override
  public List<User> list() throws Exception {
    out.writeUTF(dataName);
    out.writeUTF("list");
    out.flush();

    if (in.readUTF().equals(ResponseStatus.SUCCESS)) {
      return (List<User>) in.readObject();
    }

    return null;
  }

  @Override
  public User findBy(int no) throws Exception {
    out.writeUTF(dataName);
    out.writeUTF("get");
    out.writeInt(no);
    out.flush();

    if (in.readUTF().equals(ResponseStatus.SUCCESS)) {
      return (User) in.readObject();
    }

    return null;
  }

  @Override
  public boolean update(User user) throws Exception {
    out.writeUTF(dataName);
    out.writeUTF("update");
    out.writeObject(user);
    out.flush();

    if (in.readUTF().equals(ResponseStatus.SUCCESS)) {
      return true;
    }

    return false;
  }

  @Override
  public boolean delete(int no) throws Exception {
    out.writeUTF(dataName);
    out.writeUTF("delete");
    out.writeInt(no);
    out.flush();

    if (in.readUTF().equals(ResponseStatus.SUCCESS)) {
      return true;
    }

    return false;
  }
}
