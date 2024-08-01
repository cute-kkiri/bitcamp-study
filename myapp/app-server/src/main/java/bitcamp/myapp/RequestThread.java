package bitcamp.myapp;

import bitcamp.context.ApplicationContext;
import bitcamp.myapp.dao.skel.BoardDaoSkel;
import bitcamp.myapp.dao.skel.ProjectDaoSkel;
import bitcamp.myapp.dao.skel.UserDaoSkel;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class RequestThread extends Thread {

  private Socket socket;
  private ApplicationContext appCtx;

  public RequestThread(Socket socket, ApplicationContext appCtx) {
    this.socket = socket;
    this.appCtx = appCtx;
  }

  @Override
  public void run() {
    String remoteHost = null;
    int port = 0;

    // 클라이언트의 데이터 처리 요청을 수행할 Dao Skeloton 객체를 준비한다.
    UserDaoSkel userDaoSkel = (UserDaoSkel) appCtx.getAttribute("userDaoSkel");
    BoardDaoSkel boardDaoSkel = (BoardDaoSkel) appCtx.getAttribute("boardDaoSkel");
    ProjectDaoSkel projectDaoSkel = (ProjectDaoSkel) appCtx.getAttribute("projectDaoSkel");

    try (Socket s = socket) {

      InetSocketAddress addr = (InetSocketAddress) socket.getRemoteSocketAddress();
      remoteHost = addr.getHostString();
      port = addr.getPort();

      System.out.printf("%s:%d 클라이언트와 연결되었음!\n", remoteHost, port);

      ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
      ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());

      String dataName = in.readUTF();
      switch (dataName) {
        case "users":
          userDaoSkel.service(in, out);
          break;
        case "projects":
          projectDaoSkel.service(in, out);
          break;
        case "boards":
          boardDaoSkel.service(in, out);
          break;
        default:
      }
    } catch (Exception e) {
      System.out.printf("%s:%d 클라이언트 요청 처리 중 오류 발생!\n", remoteHost, port);
    }
  }
}
