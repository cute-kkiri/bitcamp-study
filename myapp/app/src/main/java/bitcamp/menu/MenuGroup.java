package bitcamp.menu;

import java.util.ArrayList;
import java.util.Objects;

public class MenuGroup implements Menu {

  private String title;
  private ArrayList<Menu> children = new ArrayList<>();

  public MenuGroup(String title) {
    this.title = title;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof MenuGroup menuGroup)) {
      return false;
    }
    return Objects.equals(title, menuGroup.title);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(title);
  }

  @Override
  public void execute() {

  }

  public void addMenu(Menu menu) {
    children.add(menu);
  }

  public void removeMenu(Menu menu) {
    children.remove(menu);
  }

  public Menu getMenu(int index) {
    return children.get(index);
  }

  public int countMenus() {
    return children.size();
  }
}
