package bitcamp.myapp.listener;

public class HelloApplicationListener implements ApplicationListener {

  @Override
  public void onStart() {
    System.out.println("안녕하세요!!!");
  }

  @Override
  public void onShutdown() {
    System.out.println("또 만나요!!!");
  }
}
