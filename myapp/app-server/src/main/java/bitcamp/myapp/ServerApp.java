package bitcamp.myapp;

import bitcamp.context.ApplicationContext;
import bitcamp.listener.ApplicationListener;
import bitcamp.myapp.listener.InitApplicationListener;
import bitcamp.util.Prompt;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerApp {

  List<ApplicationListener> listeners = new ArrayList<>();
  ApplicationContext appCtx = new ApplicationContext();

  public static void main(String[] args) {
    ServerApp app = new ServerApp();

    // 애플리케이션이 시작되거나 종료될 때 알림 받을 객체의 연락처를 등록한다.
    app.addApplicationListener(new InitApplicationListener());

    app.execute();
  }

  private void addApplicationListener(ApplicationListener listener) {
    listeners.add(listener);
  }

  private void removeApplicationListener(ApplicationListener listener) {
    listeners.remove(listener);
  }

  void execute() {

    // 애플리케이션이 시작될 때 리스너에게 알린다.
    for (ApplicationListener listener : listeners) {
      try {
        listener.onStart(appCtx);
      } catch (Exception e) {
        System.out.println("리스너 실행 중 오류 발생!");
      }
    }

    System.out.println("서버 프로젝트 관리 시스템 시작!");

    try (ServerSocket serverSocket = new ServerSocket(8888);) {
      System.out.println("서버 실행 중...");

      // 클라이언트 연결을 기다림 => 대기열에 클라이언트가 등록되는 순간 즉시 통신 연결
      try (Socket socket = serverSocket.accept();) {
        System.out.println("클라이언트와 연결되었음!");

        // 클라이언트와 데이터를 주고 받기 위해 스트림 객체에 적절한 데코레이터를 붙인다.
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        // 클라이언트가 문자열을 보낼 때까지 기다리고 있다가
        // 클라이언트가 문자열을 보내면 즉시 읽어서 String 객체로 리턴한다.
        String message = in.readUTF();

        // 클라이언트에게 보낼 문자열을 네트워크 카드의 메모리에 전송해 둔다.
        // 데이터를 전송하는 것은 OS가 할 일이다.
        // 데이터가 도착하는지 확인하지 않고 즉시 리턴한다.
        out.writeUTF(message + "!!(강사)");
      }

    } catch (Exception e) {
      System.out.println("통신 중 오류 발생!");
      e.printStackTrace();
    }

    System.out.println("종료합니다.");

    Prompt.close();

    // 애플리케이션이 종료될 때 리스너에게 알린다.
    for (ApplicationListener listener : listeners) {
      try {
        listener.onShutdown(appCtx);
      } catch (Exception e) {
        System.out.println("리스너 실행 중 오류 발생!");
      }
    }
  }
}
