# 18. 리팩토링: GRASP의 High Cohesion 적용

## 학습목표

- GRASP 객체 지향 설계 지침 중에서 High Cohesion을 적용할 수 있다.

## 요구사항

- 서브 메뉴 처리를 각 Command 구현체에 이전하기

## 실행 결과

- 이전과 같다.

## 작업

- Command 인터페이스 변경
  - execute() 메서드 변경
- 회원 서브 메뉴 관련 코드 이전
  - UserCommand 클래스 변경
- 프로젝트 서브 메뉴 관련 코드 이전
  - ProjectCommand 클래스 변경
- 게시판 서브 메뉴 관련 코드 이전
  - BoardCommand 클래스 변경
- App 클래스 변경 


## 소스 파일

- Command.java
- UserCommand.java
- ProjectCommand.java
- BoardCommand.java
- App.java