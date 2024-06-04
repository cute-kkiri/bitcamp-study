package study.lang.variable;

// 실습
// - 문자 코드를 저장하는 방법을 확인하라.
//

public class Test02 {
  public static void main(String[] args) {
    // 코드를 완성하라.
    char c1 = 44032; // 변수에 '가' 문자의 코드를 정수 값으로 저장하라.
    char c2 = 0xac00;
    char c3 = '\uac00'; // 변수에 '가' 문자의 코드를 \u0000 형태의 유니코드 표현법으로 저장하라.
    char c4 = '가'; // 변수에 '가' 문자의 코드를 가장 쉬운 방법으로 저장하라.


    System.out.println(c1);
    System.out.println(c2);
    System.out.println(c3);
    System.out.println(c4);
  }
}
