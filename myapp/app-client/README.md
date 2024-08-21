# 45. Mybatis 퍼시스턴스 프레임워크 사용하기

## 학습목표

- Mybatis를 사용하여 DBMS와 연동할 수 있다.

## 요구사항

- DAO에 Mybatis를 적용하라.

## 실행 결과

- 이전과 같다.

## 작업

- Mybatis 라이브러리를 프로젝트에 추가
  - build.gradle(Gradle 빌드 스크립트 파일) 변경
- Mybatis 설정 파일 준비
  - mybatis-config.xml 파일 생성
  - jdbc.properties 파일 생성
- SQL Mapper 파일 준비
  - UserDaoMapper.xml
  - BoardDaoMapper.xml
  - ProjectDaoMapper.xml
- DAO에 Mybatis 적용
  - UserDaoImpl 클래스 변경 
  - BoardDaoImpl 클래스 변경
  - ProjectDaoImpl 클래스 변경
- InitApplicationListener 변경
  - Mybatis 객체 준비


## 소스 파일

