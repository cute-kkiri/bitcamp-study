# 28. File I/O API 활용하기 I :  데이터를 바이너리 형식으로 입출력

## 학습목표

- File I/O API를 사용하여 데이터를 바이너리 형식으로 출력할 수 있다.

## 요구사항

- 회원, 프로젝트, 게시판 데이터를 앱을 종료할 때 파일로 저장한다.
- 회원, 프로젝트, 게시판 데이터를 앱을 실행할 때 파일에서 읽는다.

## 실행 결과

- 이전과 같다.

## 작업

- 데이터를 저장
  - App 클래스 변경
    - loadData(), saveData() 메서드 추가
    - loadUsers(), saveUsers() 메서드 추가
    - loadProjects(), saveProjects() 메서드 추가
    - loadBoards(), saveBoards() 메서드 추가
  - User, Project, Board 클래스 변경
    - getSeqNo(), initSeqNo() 메서드 추가
    - getBytes(), valueOf() 메서드 추가
## 소스 파일

- App.java
- Board.java
- Project.java
- User.java