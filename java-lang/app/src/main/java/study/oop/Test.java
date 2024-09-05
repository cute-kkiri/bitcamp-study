package study.oop;

public class Test {
  public static void main(String[] args) {
    A obj = new C();
    obj.m1(); // m1() 메서드를 호출할 때, obj의 클래스부터 찾아 올라 간다.
  }
}
