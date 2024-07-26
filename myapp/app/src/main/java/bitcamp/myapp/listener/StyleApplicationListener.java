package bitcamp.myapp.listener;

public class StyleApplicationListener implements ApplicationListener {

  @Override
  public void onStart() {
    System.out.println("---------------------:)---------------------------");
  }

  @Override
  public void onShutdown() {
    System.out.println("-----------------------^^-------------------------");
  }
}
