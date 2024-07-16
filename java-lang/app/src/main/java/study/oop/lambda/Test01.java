package study.oop.lambda;

public class Test01 {

  interface Player {
    void play();
  }

  public static void main(String[] args) {
    //1) 일반 클래스
    class MyPlayer implements Player{
      @Override
      public void play() {
        System.out.println("1");
      }
    }
    Player p1 = new MyPlayer();
    p1.play();

    //2) 익명 클래스
    Player p2 = new Player() {
      @Override
      public void play() {
        System.out.println("2");
      }
    };
    p2.play();

    //3) 익명 클래스 + 메서드 호출
    new Player() {
      @Override
      public void play() {
        System.out.println("3");
      }
    }.play();

    //4) 람다
    Player p4 = () -> {
      System.out.println("4");
    };
    p4.play();

    //5) 람다 + 중괄호 생략
    Player p5 = () -> System.out.println("4");

    p5.play();

  }
}
