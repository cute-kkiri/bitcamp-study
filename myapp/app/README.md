# 22. Iterator 디자인 패턴을 활용하여 목록 조회 기능을 캡슐화하기

## 학습목표

- GoF의 Iterator 설계 패턴을 이해하고 적용할 수 있다.

## 요구사항

- 자료구조에 상관없이 일관된 방법으로 데이터를 조회할 수 있도록 캡슐화 하기

## 실행 결과

- 이전과 같다.

## 작업

### Iterator 인터페이스 정의 및 구현, 적용

- Iterator 인터페이스 추가
- List 인터페이스 변경
  - iterator() 메서드 추가
- Iterator 구현체 추가
  - ListIterator 클래스 정의
- AbstractList 클래스 변경
  - iterator() 추가: ListIterator 객체 리턴
- Command 구현체에 적용
  - BoardCommand, ProjectCommand, UserCommand 클래스 변경
  

## 소스 파일

- Iterator.java
- List.java
- ListIterator.java
- AbstractList.java
- BoardCommand.java
- ProjectCommand.java
- UserCommand.java
- Project.java
  - 필드의 타입을 List로 변경
