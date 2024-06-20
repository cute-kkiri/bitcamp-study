# 12. 인스턴스 목록을 다루는 코드를 분리하기

## 학습목표

- GRASP 방법론의 High Cohesion 설계 패턴을 적용할 수 있다.

## 요구사항

- UserCommand 클래스의 역할을 더 단순하게 분리한다.
  - UserCommand 클래스가 사용자의 상호작업에 더 집중하게 만든다.
  - 즉 UI를 처리하는 역할에 집중한다.(High Cohesion)

## 실행 결과

- 실행 결과 변경 없음


## 작업

- UserCommand에서 인스턴스 목록을 다루는 역할을 다른 클래스로 분리한다.
  - ArrayList 클래스 정의
  - 
- UserCommand에서 인스턴스 목록을 다루는 코드를 ArrayList로 이동
  - UserCommand 변경
  - 
    
## 소스 파일

- App.java
- User.java
- UserCommand.java
- Project.java
- ProjectCommand.java
- Board.java
- BoardCommand.java
  
