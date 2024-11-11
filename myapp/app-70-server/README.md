# 70. Jenkins와 Docker를 이용한 배포 자동화하기

## 학습목표

- Jenkins와 Docker를 이용하여 배포를 자동화 할 수 있다.

## 요구사항

- 애플리케이션 배포를 자동화 하라.

## 실행 결과

- 이전과 같다.

## 작업

- 배포 파일 생성 및 실행 확인
  - build.gradle 변경
  - $ java -jar myapp.jar
- 스프링부트 설정 파일을 개발과 운영으로 분리
  - application-dev.properties (개발)
  - application-prod.properties (운영)
  - 실행 옵션
    - JVM 아규먼트: `-Dspring.profiles.active=dev`
      - 예) $ java -Dspring.profiles.active=prod -jar myapp.jar
      - 예) Gradle: 환경변수를 통해 설정
        - $ export SPRING_PROFILES_ACTIVE=dev
        - $ gradle bootRun
      - 예) IntelliJ : 환경변수를 통해 설정한다.
        - bootRun -> 구성 -> 편집: spring.profiles.active=dev
    - 프로그램 아규먼트: `--spring.profiles.active=dev`
      - 예) $ java -jar myapp.jar --spring.profiles.active=prod
      - 예) $ gradle bootRun --args='--spring.profiles.active=dev'
- myapp 프로젝트를 별도의 repository로 분리
  - bitcamp-myapp repository 생성
  - myapp 프로젝트를 bitcamp-myapp으로 이전
  - 빌드 및 실행 확인
- NCP 리눅스 서버 생성
  - student 유저 생성
    - # useradd student
    - # passwd student
    - # visudo (/etc/sudoerc 파일 편집)
      - student ALL=(ALL:ALL) ALL
  - root 사용자 로그인 불가하게 설정
    - # nano /etc/ssh/sshd_config
      - PermitRootLogin no
  - yum update 실행
  - JDK 설치
    - $ sudo yum install -y https://cdn.azul.com/zulu/bin/zulu-repo-1.0.0-1.noarch.rpm
    - $ sudo yum install zulu21-jdk
    - $ nano ~/.bash_profile
      - export JAVA_HOME=/usr/lib/jvm/java-21-zulu-openjdk
- NCP 보안 파일 생성
  - ~$ mkdir config
  - ~$ cd config
  - ~/config$ nano ncp.properties
    - 로컬 파일의 내용 복사
- 애플리케이션 배치 및 실행
  - ~$ mkdir git
  - ~$ cd git
  - ~/git$ git clone https://github.com/username/bitcamp-myapp
  - ~/git$ cd bitcamp-myapp
  - ~/git/bitcamp-myapp$ ./gradlew build
  - ~/git/bitcamp-myapp$ java -Dspring.profiles.active=prod -jar ./app/build/libs/myapp.jar
- MySQL ACL에 접속 서버의 IP 등록
  - NCP 콘솔에서 편집
- Docker 엔진 설치
- Docker Image 만들기
  - Dockerfile 생성
  - Docker 허브 리포지토리 생성
    - 회원 가입
    - "bitcamp" 개인 저장소 생성
  - 이미지 빌드
    - `docker build -t username/bitcamp:myapp .`
  - 도커 허브 로그인
    - `docker login`
  - 도커 허브에 이미지 올리기
    - `docker push eomjinyoung/bitcamp:myapp`
- Docker 컨테이너 생성 및 실행
- Jenkins CI/CD 자동화 빌드 도구 구축
  - 도커 컨테이너를 이용한 Jenkins 설치 및 실행
  - 자동 빌드 설정 및 빌드 테스트
  - 깃허브 저장소와 연동
- 젠킨스와 도커를 이용한 자동 배치
  - 배치용 리눅스 서버 구축
  - 자동 배치 수행

## 소스 파일

