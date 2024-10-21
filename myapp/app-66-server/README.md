# 66. 페이징 처리 적용하기

## 학습목표

- MySQL에서 목록에 대해 페이징 처리를 적용할 수 있다.

## 요구사항

- 목록에 페이징을 적용하라.

## 실행 결과

- 이전과 같다.

## 작업

- BoardDao 인터페이스 변경
  - list() 메서드 변경 
  - countAll() 메서드 추가
- BoardDao.xml SQL 매퍼 변경
  - list SQL 변경 
  - countAll SQL 추가
- BoardService 및 DefaultBoardService 변경
  - list() 변경
  - countAll() 추가
- BoardController 변경
  - list() 변경
- list.jsp 변경
  - 페이지 링크 추가
  
## 소스 파일

