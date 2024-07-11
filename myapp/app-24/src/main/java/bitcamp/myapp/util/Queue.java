package bitcamp.myapp.util;

import bitcamp.myapp.vo.User;

public class Queue<E> extends LinkedList<E> {

  public static void main(String[] args) {
    Queue q = new Queue();
    q.offer("111");
    q.offer(true);
    q.offer(3.14f);
    q.offer(new User(100));

    System.out.println(q.poll());
    System.out.println(q.poll());
    System.out.println(q.poll());
    System.out.println(q.poll());
  }

  public void offer(E value) {
    add(value);
  }

  public E poll() {
    return remove(0);
  }

  public boolean isEmpty() {
    return size() == 0;
  }
}
