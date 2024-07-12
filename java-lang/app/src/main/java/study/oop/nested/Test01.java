package study.oop.nested;

public class Test01 {

  interface Printer {
    void print();
  }

  interface A {
    void m();
  }

  interface B {
    void x();
  }

  public static void main(String[] args) {

    new Printer() {
      @Override
      public void print() {
        System.out.println("Hello!");
      }
    }.print();

    //    Printer obj;
    //    obj = () -> {System.out.println("Hello!");};



  }

}
