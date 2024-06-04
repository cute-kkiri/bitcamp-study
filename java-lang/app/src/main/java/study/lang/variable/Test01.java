package study.lang.variable;

// 실습
// - primitive type의 변수를 선언하라.
// - 각 변수에 최소값, 최대값을 할당하라.
// - 각 변수에 최소값, 최대값 범위를 벗어나는 값을 넣은 후 오류를 확인하라.
// - 예)
// byte b1 = -128;
// byte b2 = 127;
//

public class Test01 {
  public static void main(String[] args) {
    // 코드를 완성하라.
    byte b1 = -128; // 최소값
    byte b2 = 127; // 최대값

    short s1 = -32768; // 최소값
    short s2 = 32767; // 최대값

    int i1 = -21_4748_3648; // 최소값
    int i2 = 21_4748_3647; // 최대값

    long l1 = -922_3372_0368_5477_5808L; // 최소값
    long l2 = 922_3372_0368_5477_5807L; // 최대값

    float f1 = -9876.543f; // 최소값
    float f2 = 9876.5437f; // 최대값

    double d1 = -987654323456.789; // 최소값
    double d2 = 98765432.34567898; // 최대값

    char c1 = 0; // 최소값
    char c2 = 65535; // 최대값

    boolean bool1 = false; // 최소값
    boolean bool2 = true; // 최대값
  }
}
