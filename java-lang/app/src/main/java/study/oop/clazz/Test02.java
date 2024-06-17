package study.oop.clazz;

// 연습: 클래스 문법을 데이터 타입을 정의하는 용도로 사용
//1) 클래스 사용전:
//2) 데이터 타입 정의: 성적 데이터를 저장할 메모리를 새로 정의 - Score 클래스
//3) 리팩토링: printScore() 메서드
//4) 리팩토링: compute() 메서드
//5) GRASP(General Responsibility Assignment Software Patterns) 패턴: compute() 멧서드 이동
//6) 인스턴스 메서드: compute() 메서드를 non-static 메서드로 전환
//7) 클래스를 역할에 따라 패키지로 분류: vo 패키지 생성 및 Score 클래스를 vo 패키지로 이동, import 문
//8) Score 멤버의 접근 제어 변경: public modifier
//9) 생성자 도입: Score() 생성자
//10) private과 getter 도입: sum, aver 필드는 private, 대신에 getSum(), getAver() 추가
//11) 국,영,수 점수 변경 후 합계 평균 자동 계산: kor, eng, math 필드는 private, setter/getter 추가
//12) 코딩의 일관성을 위해 다른 필드도 getter/setter로 접근하게 만든다.
//
public class Test02 {
  public static void main(String[] args) {
    String name;
    int kor;
    int eng;
    int math;
    int sum;
    float aver;

    name = "홍길동";
    kor = 100;
    eng = 90;
    math = 85;
    sum = kor + eng + math;
    aver = (float) sum / 3;

    System.out.printf("%s: %d, %d, %d, %d, %.1f\n", name, kor, eng, math, sum, aver);

    name = "임꺽정";
    kor = 90;
    eng = 80;
    math = 75;
    sum = kor + eng + math;
    aver = (float) sum / 3;

    System.out.printf("%s: %d, %d, %d, %d, %.1f\n", name, kor, eng, math, sum, aver);

    name = "유관순";
    kor = 80;
    eng = 70;
    math = 65;
    sum = kor + eng + math;
    aver = (float) sum / 3;

    System.out.printf("%s: %d, %d, %d, %d, %.1f\n", name, kor, eng, math, sum, aver);
  }
}


















