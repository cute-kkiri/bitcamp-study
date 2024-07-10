package bitcamp.myapp.util;

public class Stack extends LinkedList {

  public static void main(String[] args) {
    Stack s = new Stack();
    s.push("1111");
    s.push("2222");
    s.push("3333");

    System.out.println(s.pop());
    System.out.println(s.pop());
    System.out.println(s.pop());
    System.out.println(s.pop());

  }

  public void push(Object value) {
    add(value);
  }

  public Object pop() {
    return remove(size() - 1);
  }

  public boolean isEmpty() {
    return size() == 0;
  }
}
