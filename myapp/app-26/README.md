# 26. 메뉴 UI를 캡슐화하기: GoF의 Composite 패턴 적용

## 학습목표

- SOLID 설계 원칙의 SRP(Single Responsibility Principle)를 이해하고 적용할 수 있다.
- GoF의 Composite 설계 패턴의 구동 원리를 이해하고 적용할 수 있다.

## 요구사항

- 메뉴 UI 처리 기능을 별도의 객체로 분리하여 캡슐화 하기 

## 실행 결과

- 이전과 같다.

## 작업

- 메뉴 기능 분리
  - Menu 인터페이스 정의
  - AbstractMenu 추상 클래스 정의
  - MenuItem과 MenuGroup 클래스 정의
  - TestMenu 클래스를 통해 기능 구현을 테스트
- Command 객체 변경
  - AbstractCommand 클래스 삭제
  - Command 인터페이스 변경: execute() 변경
  - XxxCommand 클래스 변경
- App 클래스 변경
  - Menu 구성
- Prompt 클래스의 패키지 변경: bitcamp.util 패키지로 이동

## 소스 파일

- 