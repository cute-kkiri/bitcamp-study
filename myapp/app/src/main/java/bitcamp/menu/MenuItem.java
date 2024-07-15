package bitcamp.menu;

import java.util.Objects;

public class MenuItem implements Menu {

  private String title;

  public MenuItem(String title) {
    this.title = title;
  }

  @Override
  public void execute() {
    System.out.println(title);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof MenuItem menuItem)) {
      return false;
    }
    return Objects.equals(title, menuItem.title);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(title);
  }
}
