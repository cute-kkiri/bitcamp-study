package bitcamp.menu;

public class TestMenu {

  public static void main(String[] args) {
    MenuGroup root = new MenuGroup("메인");

    MenuGroup file = new MenuGroup("파일");
    root.addMenu(file);

    MenuGroup edit = new MenuGroup("편집");
    root.addMenu(edit);

    MenuItem help = new MenuItem("도움말");
    root.addMenu(help);

    root.execute();

  }
}
