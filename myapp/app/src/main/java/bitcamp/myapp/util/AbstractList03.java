package bitcamp.myapp.util;

public abstract class AbstractList03 implements List {

  protected int size = 0;

  @Override
  public int size() {
    return this.size;
  }

  public boolean contains(Object obj) {
    return indexOf(obj) != -1;
  }

  @Override
  public Iterator iterator() {

    // 3) local class
    class ListIterator implements Iterator {

      private int cursor;

      @Override
      public boolean hasNext() {
        return cursor < size();
      }

      @Override
      public Object next() {
        return get(cursor++);
      }
    }

    return new ListIterator();
  }
}
