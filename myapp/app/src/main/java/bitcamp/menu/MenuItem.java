package bitcamp.menu;

public class MenuItem extends AbstractMenu {

  public MenuItem(String title) {
    super(title);
  }

  @Override
  public void execute() {
    System.out.println(title);
  }
}
