# 22. Iterator 디자인 패턴을 활용하여 목록 조회 기능을 캡슐화하기

## 학습목표

- GoF의 Iterator 설계 패턴을 이해하고 적용할 수 있다.
- 중첩 클래스의 동작 원리를 이해하고 사용할 수 있다.

## 요구사항

- 자료구조에 상관없이 일관된 방법으로 데이터를 조회할 수 있도록 캡슐화 하기

## 실행 결과

- 이전과 같다.

## 작업

### Iterator 인터페이스 정의 및 구현

- Iterator 인터페이스 추가
- List 인터페이스 변경
  - iterator() 메서드 추가
- Iterator 구현체 추가
  - ListIterator 클래스 정의 
- AbstractList 클래스 변경
  - iterator() 추가: ListIterator 객체 리턴

### 큐 구현

- LinkedList를 상속 받아 큐를 구현한다.
  - Queue 클래스 추가
- 사용자가 입력한 내역을 큐를 이용하여 저장한다.
  - Prompt 클래스 변경
    - 사용자가 입력한 내용을 큐에 순서대로 저장
    - 입력한 내역을 출력: printHistory()
- 사용자가 입력한 내역을 출력한다.
  - HistoryCommand 클래스 추가
  - App 클래스 변경 
    - "명령내역" 메뉴 추가


## 소스 파일

- Stack.java
- Queue.java
- AbstractCommand.java
- Prompt.java
- App.java