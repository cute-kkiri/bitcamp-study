package bitcamp.myapp.util;

import java.util.Scanner;

public class Prompt {

  static Scanner keyboardScanner = new Scanner(System.in);

  public static String input(String title) {
    System.out.printf("%s ", title);
    return keyboardScanner.nextLine();
  }

  public static void close() {
    keyboardScanner.close();
  }
}
