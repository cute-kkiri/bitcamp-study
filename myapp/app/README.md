# 21. 스택과 큐 다루기

## 학습목표

- 스택과 큐의 구동 원리를 이해하고 구현할 수 있다.
- 스택과 큐를 활용할 수 있다.

## 요구사항

- 프롬프트에서 메뉴 경로를 breadcrumb 방식으로 다루기
- 사용자가 입력한 명령어 내역을 다루기 

## 실행 결과

- 이전과 같다.

## 작업

### 스택 구현

- LinkedList를 상속 받아 스택을 구현한다.
  - Stack 클래스 추가
- 프롬프트 메뉴 경로를 출력할 때 스택을 적용한다.
  - App 클래스
    - 메뉴 경로를 저장하는 스택 객체 준비
    - 메인 메뉴 이름을 스택에 저장
  - AbstractCommand 클래스
    - 서브 메뉴 이름을 스택에 보관 및 꺼내기
    - 메뉴 경로를 리턴하는 메서드 추가: getMenuPath()

### 큐 구현

- LinkedList를 상속 받아 큐를 구현한다.
  - Queue 클래스 추가
  


### 의존 객체를 외부에서 주입하기(SOLID의 DIP 적용)

- UserCommand, ProjectCommand, BoardCommand 클래스의 의존 객체를 외부에서 주입
  - 생성자 변경
- Command 객체가 사용할 List 객체 준비
  - App 클래스 변경: 생성자 변경

## 소스 파일

- UserCommand.java
- ProjectCommand.java
- BoardCommand.java
- App.java