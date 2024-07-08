package bitcamp.myapp.command;

public class HelpCommand implements Command {

  String menuTitle;

  public HelpCommand(String menuTitle) {
    this.menuTitle = menuTitle;
  }

  public void execute() {
    System.out.println("도움말입니다!");
  }
}
