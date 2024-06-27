import java.util.ArrayList;
import java.util.Scanner;

public class TeamGenerator {
  public static void main(String[] args) throws Exception {
    Scanner keyboard = new Scanner(System.in);

    String[] students = {
        "강슬기", "강윤상", "권기윤", "권준성", "김민수", "김재우", "김재정",
        "김주연", "백현기", "신승민", "양지윤", "이가람", "이건학", "이민석",
        "이선아", "이우성", "이재욱", "이태정", "임상우", "장혜정", "정찬우", "최동인",
        "황민지"
    };

    ArrayList<String> list = new ArrayList();
    for (String s : students) {
      list.add(s);
    }

    System.out.println("팀 생성!!");
    for (int i = 0; i < 10; i++) {
      System.out.print(".");
      Thread.sleep(1000);
    }
    System.out.println();

    int s1 = 0, s2 = 0;
    while (list.size() > 1) {
      for (int i = 0; i < (int)(Math.random() * 100) + 1; i++) {
        s1 = (int) (Math.random() * list.size());
      }
      String name1 = list.remove(s1);

      for (int i = 0; i < (int)(Math.random() * 100) + 1; i++) {
        s2 = (int) (Math.random() * list.size());
      }
      String name2 = list.remove(s2);

      System.out.printf("%s, %s\n", name1, name2);
      keyboard.nextLine();
    }

    keyboard.close();
  }
}
