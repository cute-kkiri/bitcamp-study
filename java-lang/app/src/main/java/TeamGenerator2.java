import java.util.ArrayList;
import java.util.Scanner;

public class TeamGenerator2 {
  public static void main(String[] args) throws Exception {
    Scanner keyboard = new Scanner(System.in);


    String[] students = {
        //"강슬기", "권준성","정찬우", "최동인","임상우",
        "강윤상", "권기윤", "김민수", "김재우", "김재정", "이건학",
        "김주연", "백현기", "신승민", "양지윤", "이가람", "이민석",
        "이선아", "이우성", "이재욱", "이태정", "장혜정", "황민지"
    };

    ArrayList<String> list = new ArrayList<>();
    for (String s : students) {
      list.add(s);
    }

    System.out.println("팀 생성!!");
    for (int i = 0; i < 7; i++) {
      System.out.print(".");
      Thread.sleep(1000);
    }
    System.out.println();

    int s1 = 0, s2 = 0, s3 = 0, s4 = 0, s5 = 0, s6 = 0;
    while (list.size() > 1) {
      for (int i = 0; i < (int)(Math.random() * 100) + 1; i++) {
        s1 = (int) (Math.random() * list.size());
      }
      String name1 = list.remove(s1);

      for (int i = 0; i < (int)(Math.random() * 100) + 1; i++) {
        s2 = (int) (Math.random() * list.size());
      }
      String name2 = list.remove(s2);

      for (int i = 0; i < (int)(Math.random() * 100) + 1; i++) {
        s3 = (int) (Math.random() * list.size());
      }
      String name3 = list.remove(s3);

      for (int i = 0; i < (int)(Math.random() * 100) + 1; i++) {
        s4 = (int) (Math.random() * list.size());
      }
      String name4 = list.remove(s4);

      for (int i = 0; i < (int)(Math.random() * 100) + 1; i++) {
        s5 = (int) (Math.random() * list.size());
      }
      String name5 = list.remove(s5);

      for (int i = 0; i < (int)(Math.random() * 100) + 1; i++) {
        s6 = (int) (Math.random() * list.size());
      }
      String name6 = list.remove(s6);


      System.out.printf("%s, %s, %s, %s, %s, %s\n", name1, name2, name3, name4, name5, name6);
      keyboard.nextLine();
    }

    keyboard.close();
  }
}
