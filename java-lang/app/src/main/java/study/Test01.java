package study;

import java.util.HashMap;
import java.util.Objects;

public class Test01 {
  static class My {
    String a;
    public My(String a) {
      this.a = a;
    }
    @Override
    public int hashCode() {
      return Objects.hash(a);
    }
    @Override
    public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      }
      if (obj == null) {
        return false;
      }
      if (getClass() != obj.getClass()) {
        return false;
      }
      My other = (My) obj;
      return Objects.equals(a, other.a);
    }

  }

  public static void main(String[] args) {
    HashMap<Integer,My> map = new HashMap<>();

    for (int i = 0; i < 40; i = i + 2) {
      My my = new My(String.valueOf(Math.random() * 10000));
      System.out.println(my.a);
      map.put(i + 1, my);
    }

    System.out.println("----------------------------");

    for (My my : map.values()) {
      System.out.println(my.a);
    }
  }
}
