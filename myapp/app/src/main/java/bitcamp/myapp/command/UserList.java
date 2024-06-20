package bitcamp.myapp.command;

import bitcamp.myapp.vo.User;

public class UserList {

  private static final int MAX_SIZE = 100;
  private static User[] users = new User[MAX_SIZE];
  private static int userLength = 0;

  public static void add(User user) {
    users[userLength++] = user;
  }
}
