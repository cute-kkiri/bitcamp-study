package bitcamp.myapp;

public class UserCommand01 {

  static final int MAX_SIZE = 100;
  static String[] name = new String[MAX_SIZE];
  static String[] email = new String[MAX_SIZE];
  static String[] password = new String[MAX_SIZE];
  static String[] tel = new String[MAX_SIZE];
  static int memberLength = 0;

  static void executeUserCommand(String command) {
    System.out.printf("[%s]\n", command);
    switch (command) {
      case "등록":
        addUser();
        break;
      case "조회":
        viewUser();
        break;
      case "목록":
        listUser();
        break;
      case "변경":
        updateUser();
        break;
      case "삭제":
        deleteUser();
        break;
    }
  }

  static void addUser() {
    name[memberLength] = Prompt.input("이름?");
    email[memberLength] = Prompt.input("이메일?");
    password[memberLength] = Prompt.input("암호?");
    tel[memberLength] = Prompt.input("연락처?");
    memberLength++;
  }

  static void listUser() {
    System.out.println("번호 이름 이메일");
    for (int i = 0; i < memberLength; i++) {
      System.out.printf("%d %s %s\n", (i + 1), name[i], email[i]);
    }
  }

  static void viewUser() {
    int userNo = Integer.parseInt(Prompt.input("회원번호?"));
    if (userNo < 1 || userNo > memberLength) {
      System.out.println("없는 회원입니다.");
      return;
    }
    System.out.printf("이름: %s\n", name[userNo - 1]);
    System.out.printf("이메일: %s\n", email[userNo - 1]);
    System.out.printf("연락처: %s\n", tel[userNo - 1]);
  }

  static void updateUser() {
    int userNo = Integer.parseInt(Prompt.input("회원번호?"));
    if (userNo < 1 || userNo > memberLength) {
      System.out.println("없는 회원입니다.");
      return;
    }
    name[userNo - 1] = Prompt.input(String.format("이름(%s)?", name[userNo - 1]));
    email[userNo - 1] = Prompt.input(String.format("이메일(%s)?", email[userNo - 1]));
    password[userNo - 1] = Prompt.input("암호?");
    tel[userNo - 1] = Prompt.input(String.format("연락처(%s)?", tel[userNo - 1]));
    System.out.println("변경했습니다.");
  }

  static void deleteUser() {
    int userNo = Integer.parseInt(Prompt.input("회원번호?"));
    if (userNo < 1 || userNo > memberLength) {
      System.out.println("없는 회원입니다.");
      return;
    }
    for (int i = userNo; i < memberLength; i++) {
      name[i - 1] = name[i];
      email[i - 1] = email[i];
      password[i - 1] = password[i];
      tel[i - 1] = tel[i];
    }
    memberLength--;
    name[memberLength] = null;
    email[memberLength] = null;
    password[memberLength] = null;
    tel[memberLength] = null;
  }

}
