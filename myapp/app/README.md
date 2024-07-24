# 33. Apache POI 라이브러리 활용하기 : 데이터를 엑셀 포맷의 파일로 입출력

## 학습목표

- Apache POI 라이브러리를 이용하여 엑셀 포맷의 파일을 다룰 수 있다.

## 요구사항

- 데이터를 엑셀 포맷으로 파일에 저장하고 읽기

## 실행 결과

- 이전과 같다.

## 작업

- Google gson 라이브러리 추가
  - build.gradle 변경
- 데이터 로딩 및 저장 코드 변경
  - loadJson(), saveJson() 메서드 추가
  - loadData(), saveData() 메서드 변경
  - loadUsers(), saveUsers() 메서드 삭제
  - loadProjects(), saveProjects() 메서드 삭제
  - loadBoards(), saveBoards() 메서드 삭제
- User, Project, Board 클래스 변경
  - SequenceNo 인터페이스 정의
  - User, Project, Board 클래스 SequenceNo 구현
  - 데이터 로딩 후 일련 식별 번호 초기화: initSeqNo() 메서드 추가
 
## 소스 파일

- App.java
- SequenceNo.java 추가
- Board.java
- Project.java
- User.java