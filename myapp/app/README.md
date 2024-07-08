# 18. 리팩토링

## 학습목표

- GRASP 객체 지향 설계 지침 중에서 High Cohesion을 적용할 수 있다.

## 요구사항

- 서브 메뉴 처리를 각 Command 구현체에 이전하기

## 실행 결과

- 이전과 같다.


## 작업

### 목록을 다루는 객체 사용 규칙을 정의

- List 인터페이스 추가 
- ArrayList와 LinkedList 클래스를 List 규칙에 따라 정의한다.
  - ArrayList와 LinkedList 변경
- ArrayList, LinkedList, List 클래스를 별도의 패키지로 분류한다.
  - 관련 클래스 이동
- 리팩토링
  - UserList, ProjectList, BoardList 에서 데이터를 찾는 기능을 equals로 대체 
  - UserList, ProjectList, BoardList 제거
- equals() 재정의
  - Board, Project, User 변경
  - UserCommand, BoardCommand, ProjectCommand 변경

### 메뉴를 처리하는 객체의 사용 규칙을 정의

- Command 인터페이스 추가
- UserCommand, ProjectCommand, BoardCommand 클래스에 인터페이스 적용
- 

## 소스 파일

- List.java
- ArrayList.java
- LinkedList.java
- User.java
- Project.java
- Board.java
- Command.java
- UserCommand.java
- ProjectCommand.java
- BoardCommand.java
- App.java