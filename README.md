# bitcamp-study

네이버클라우드캠프 데브옵스 14기 실습 자료 저장소

## 웨일온 접속 정보

- 회의실 번호 / 암호: 210 866 3081 / 111222
- 회의링크: https://whaleon.us/o/CSrtk1/84888a51da9d4f939e63eee37248fb28

## 강의자료

- 실습(https://github.com/eomjinyoung/bitcamp-study)
- 강의자료
  - 수업 문서(https://github.com/eomcs/eomcs-docs)
  - 프로그래밍 자료(https://github.com/eomcs/eomcs-java)

## 1일차(2024-05-24,금)

- 소프트웨어 개요
  - 시스템 소프트웨어와 애플리케이션 소프트웨어
  - Standalone과 Client/Server
  - 설치형과 비설치형
  - 애플리케이션의 기본 구조
- GIT 설치
  - 실습 저장소 준비 및 복제

## 2일차(2024-05-27,월)

- GIT 소개
  - 기본 명령 사용법(clone, add, commit, push, pull)
  - 개인 저장소 준비 및 가져오기
    - `$ git clone https://github.com/사용자이름/bitcamp-mystudy`
  - 실습 저장소 가져오기
    - `$ git clone https://github.com/eomjinyoung/bitcamp-study`
  - 수업문서 가져오기
    - `$ git clone https://github.com/eomcs/eomcs-docs`
  - 프로그래밍 자료 가져오기
    - `$ git clone https://github.com/eomcs/eomcs-java`
- 개발 도구 준비
  - 기본 편집기: VSCode
  - Windows gcc 컴파일러 설치
  - VirtualBox 설치
  - Vagrant 설치
- 웹 애플리케이션 구동 원리 소개
  - 웹 애플리케이션의 구성 요소: HTML, CSS, JavaScript, Images, Application
  - 웹 애플리케이션 구현 기술: Java, SQL, HTML, CSS, JavaScript 등
- 애플리케이션 개발 및 실행 과정 실습
  - hello.c 작성 및 컴파일, 실행
- CPU, 기계어, OS의 관계 이해
- 수업 진행 방식 소개

## 3일차(2024-05-28,화)

- 컴파일 방식과 인터프리터 방식, 하이브리드 방식
  - Nodejs 설치 및 실행
    - hello.js
  - JDK 설치 및 실행
    - Hello.java
- Java 컴파일 및 실행 원리
  - 자바컴파일러와 바이트코드
  - JVM
- 자바 제품 소개
  - Java SE(JRE, Server JRE, JDK)
  - Java EE(Servlet/JSP/EL/JSTL, EJB/WebService/REST API 등)
  - Java ME

## 4일차(2024-05-29,수)

- 개발 도구 설정
  - 폰트 설치
    - D2Coding 폰트
  - VSCode 설정
    - Font Size: 18
    - Font Family: D2Coding
    - Java Formatting: GoogleStyle
    - Format On Save: 활성화
    - Code Lens: 비활성화
    - Inlay Hints: 비활성화
- Java 컴파일과 실행
  - 컴파일 옵션 사용법
  - JVM 옵션 사용법
- 자바 프로젝트 디렉토리 구조
  - Maven 표준 자바 프로젝트 디렉토리 구성하기
  - java-lang 프로젝트 구성
  - myapp 프로젝트 구성
- 빌드 도구
  - 빌드의 개념
  - 빌드 도구 소개: Ant, Maven, Gradle
  - Gradle 빌드 도구 설치 및 사용법
    - 자바 프로젝트 디렉토리를 구성하기
    - 자동 생성된 디렉토리 및 파일의 역할 이해
    
## 5일차(2024-05-30,목)
  
- 직접 Bytecode 로 프로그래밍 하기
  - HelloWorld.class 파일 제작 및 실행
- 자바 기초 프로그래밍
  - 소스 파일(.java)과 클래스 블록, 클래스 파일(.class)
  - public 클래스와 소스 파일명
  - 애플리케이션 entry point: main() 메서드
  - 애플리케이션 아규먼트 다루는 방법: main(String[] args)

## 6일차(2024-05-31,금)
  
- 자바 기초 프로그래밍
  - 패키지 
  - 데이터 타입과 리터럴
  - 문자와 문자집합

## 7일차(2024-06-03,월)
  
- 자바 기초 프로그래밍
  - 문자와 문자집합(계속)
  - 문자를 저장하는 원리
  - 정수를 메모리에 저장하는 원리
  - 부동소수점을 메모리에 저장하는 원리

## 8일차(2024-06-04,화)

- 자바 기초 프로그래밍
  - 변수 선언 의미와 방법
  - 데이터 타입에 따라서 변수에 저장할 수 있는 값의 유효 범위
- 개발 도구
  - Eclipse IDE 설치 및 설정
  - Gradle 빌드 도구로 만든 프로젝트를 Eclipse IDE로 임포트 하는 방법

## 9일차(2024-06-05,수)

- 실습 프로젝트
  - myapp 프로젝트 생성 및 빌드, 실행
  - 01. 자바 프로젝트 준비하기
  - 02. 리터럴과 변수를 사용해서 문자열 출력하기
  - 03. ANSI 이스케이프 코드를 사용하여 출력 문자열 꾸미기
  - 04. 키보드 입력 다루기
- 개발 도구
  - IntelliJ IDE 설치 및 설정

## 10일차(2024-06-07,금)

- 자바 기초 프로그래밍
  - 연산자

## 11일차(2024-06-10,월)

- 자바 기초 프로그래밍
  - 조건문, 반복문, 배열
  - 레퍼런스와 인스턴스
  - 가비지와 가비지 컬렉터
- 실습 프로젝트
  - 05. 배열을 활용하여 메뉴 목록 다루기
  - 06. 예외 처리하기

## 12일차(2024-06-11,화)

- 자바 기초 프로그래밍
  - print(), println(), printf() 사용법
  - Scanner 클래스 사용법
- 실습 프로젝트
  - 07. 문자열 비교와 데이터 변환 다루기
  - 08. 기능 단위로 명령문 묶기 : 메서드 사용법

## 13일차(2024-06-12,수)

- 자바 기초 프로그래밍
  - 메서드 사용법
    - 메서드 정의와 호출
    - 스레드 개념과 'main' 스레드
    - single thread와 multiple thread
    - 파라미터와 아규먼트
    - 메서드 로컬 변수와 JVM Stack, Frame 메모리
    - 재귀호출
    - call by value 와 call by reference
- 실습 프로젝트
  - 07 버전을 08 버전으로 바꾸는 것 연습

## 14일차(2024-06-13,목)

- 자바 기초 프로그래밍
  - 메서드 사용법
- 실습 프로젝트
 - 09. 자바 기본 문법 활용 연습

## 15일차(2024-06-14,금)

- 자바 기초 프로그래밍
  - 클래스 사용법
    - 사용자 데이터 타입 정의
    - 메서드 분류
- 실습 프로젝트
 - 10. CRUD 구현하기
  - 회원 CRUD 구현

## 16일차(2024-06-17,월)

- 자바 기초 프로그래밍
  - 클래스 사용법(계속)
    - 사용자 데이터 타입 정의
    - 메서드 분류
    - static 필드와 non-static 필드
    - static 메서드와 non-static 메서드
    - 인스턴스와 레퍼런스
    - private, public modifier
    - getter/setter 메서드
    - 생성자
- 실습 프로젝트

## 17일차(2024-06-18,화)

- 자바 기초 프로그래밍
  - 클래스 사용법(계속)
    - 복습
- 실습 프로젝트
  - 10. CRUD 구현하기(계속)
    - 프로젝트 CRUD 구현

## 18일차(2024-06-19,수)

- 자바 기초 프로그래밍
  - 클래스 사용법(계속)
- 실습 프로젝트
  - 10. CRUD 구현하기(계속)
    - 게시글 CRUD 구현

## 19일차(2024-06-20,목)

- 자바 기초 프로그래밍
  - 상속
    - 상속 관계와 레퍼런스
- 실습 프로젝트
  - 11. 데이터 식별 번호 부여하기
  - 12. 인스턴스 목록을 다루는 코드를 분리하기 : GRASP의 High Cohesion 설계 패턴
  
## 20일차(2024-06-21,금)

- 자바 기초 프로그래밍
  - 상속(계속)
- 실습 프로젝트
  - 13. 스태틱 필드의 한계를 극복하기: 인스턴스 필드 사용
  - 14. 공통 코드 분리와 사용하기: 상속의 일반화 기법

## 21일차(2024-06-24,월)

- 자바 기초 프로그래밍
  - 기본 클래스 사용법: Object 클래스
- 실습 프로젝트
  - 

## 22일차(2024-06-25,화)

- 자바 기초 프로그래밍
  - 기본 클래스 사용법: String, Wrapper 클래스
- 실습 프로젝트
 - 15. 배열 크기 자동 증가시키기: 배열 복제와 문제점