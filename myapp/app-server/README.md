# 62. NCP의 서비스 적용하기

## 학습목표

- NCP의 mysql 서비스를 설정하고 사용할 수 있다.
- NCP의 ObjectStorage 서비스를 설정하고 사용할 수 있다.

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
  - 
    


## 소스 파일

