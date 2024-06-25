package bitcamp.myapp.command;

public class LinkedList {

  Node first;
  Node last;
  int size;

  public static void main(String[] args) {
    LinkedList list = new LinkedList();
    list.append("홍길동");
    list.append("임꺽정");
    list.append("유관순");

    //list.printAll();
    for (int i = 0; i < list.size(); i++) {
      System.out.println(list.getValue(i));
    }
  }

  public void append(Object value) {
    Node newNode = new Node(value);

    if (first == null) {
      last = first = newNode;
    } else {
      last.next = newNode;
      last = newNode;
    }
    size++;
  }

  public Object getValue(int index) {
    if (index < 0 || index >= size) {
      throw null;
    }

    Node cursor = first;
    int currentIndex = 0;

    while (cursor != null) {
      if (currentIndex == index) {
        return cursor.value;
      }
      cursor = cursor.next;
      currentIndex++;
    }
    return null;
  }

  public int size() {
    return size;
  }

  public void printAll() {
    Node cursor = first;
    while (cursor != null) {
      System.out.println(cursor.value);
      cursor = cursor.next;
    }
  }
}
