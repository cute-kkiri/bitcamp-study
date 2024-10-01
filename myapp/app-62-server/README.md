# 62. NCP의 서비스 적용하기

## 학습목표

- NCP의 mysql 서비스를 설정하고 사용할 수 있다.
- NCP의 ObjectStorage 서비스를 설정하고 사용할 수 있다.
- NCP의 ImageOptimizer 서비스를 설정하고 사용할 수 있다.
- Transaction의 propagation 유형을 이해하고 다룰 수 있다.

## 요구사항

- DBMS를 NCP의 mysql로 변경하라.
- 첨부파일을 NCP의 ObjectStorage 서비스를 사용하여 관리하라.

## 실행 결과

- 이전과 같다.

## 작업

- NCP mysql 서비스 도입
  - VPC 생성: 사설 네트워크를 구축
  - Network ACL 생성: 네트워크 접근 제어
  - Subnet 생성: 네트워크를 관리할 수 있는 단위로 영역을 쪼개기
  - 클라우드 mysql 서비스 생성
  - mysql ACL inbound/outbound 설정: mysql 방화벽 설정
  - study 원격 접속 사용자 추가
  - myapp 테이블 생성 및 예제 데이터 입력: ddl.sql, data.sql 실행 
  - myapp 실행 테스트
- NCP ObjectStorage 서비스 도입
  - ObjectStorage의 bucket 생성: bitcamp-bucketxxx
  - 'aws-java-sdk-s3' 라이브러리를 프로젝트에 적용
  - StorageService 인터페이스 정의
  - NcpObjectStorageService 구현체 생성
  - BoardController, DownloadController 변경
- NCP ImageOptimizer 서비스 도입
  - 회원의 사진 등록 추가
    - DDL 변경
    - User 클래스 변경
    - /user/form.jsp 변경
    - UserController의 add() 변경
    - UserDaoMapper 파일 변경: insert SQL 변경
    - NCP StorageService의 버킷에 user 폴더 생성
  - 회원의 사진 보기
    - /user/view.jsp 변경
    - UserDaoMapper 파일 변경: select SQL 변경
    - NCP ImageOptimizer 서비스에 회원 사진을 crop 하는 서비스 추가(100 x 100)
  - 회원 사진 변경
    - /user/view.jsp 변경
    - UserController의 update() 변경
    - UserDaoMapper 파일 변경: update SQL 변경
  - 회원 삭제
    - UserController의 delete() 변경
      - @Transactional 적용
  - 회원 목록에서 사진 보기
    - /user/list.jsp 변경
    - NCP ImageOptimizer 서비스에 회원 사진을 crop 하는 서비스 추가 (20 x 20)
    - UserDaoMapper 파일 변경: 목록을 가져오는 select SQL 변경
    - 
## 소스 파일

