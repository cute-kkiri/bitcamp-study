package study.lang.operator;

// 실습
// - 산술 연산자를 사용하여 연산을 수행한 후 결과를 확인하라.
//
// 학습 내용
// - byte, short, char를 산술연산할 때 int로 변환한 후 수행한다.
// - int와 int의 연산 결과는 int이다.
//
//

public class Test02 {
  public static void main(String[] args) {
    byte b1 = 100;
    byte b2 = 20;
    byte b3;

    // 다음 테스트 해 보고, 컴파일 오류가 나는 이유를 설명하고
    // 컴파일 오류가 나지 않도록 해결하라.
    b3 = 100 + 20; // 리터럴 끼리의 연산 결과는 리터럴이다.
    b3 = (byte) (b1 + b2); // byte, char, short는 int로 변환된 후 실행된다.
    System.out.println(b3);

    int r = b1 + b2; // OK

    char c = 20;
    short s = 30;
    // short r2 = c + s;

    long i1 = 22_0000_0000L;
    long i2 = 21_0000_0000;
    long i3 = i1 + i2;
    System.out.println(i3); // -xxx


  }
}
