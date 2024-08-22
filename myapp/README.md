# 실습 프로젝트

## 01. 자바 프로젝트 준비하기
## 02. 리터럴과 변수를 사용해서 문자열 출력하기
## 03. ANSI 이스케이프 코드를 사용하여 출력 문자열 꾸미기
## 04. 키보드 입력 다루기
## 05. 배열을 활용하여 메뉴 목록 다루기
## 06. 예외 처리하기
## 07. 문자열 비교와 데이터 변환 다루기
## 08. 기능 단위로 명령문 묶기 : 메서드 사용법
## 09. 자바 기본 문법 활용 연습
## 10. CRUD 구현하기
## 11. 데이터 식별 번호 부여하기
## 12. 인스턴스 목록을 다루는 코드를 분리하기 : GRASP의 High Cohesion 설계 패턴
## 13. 스태틱 필드의 한계를 극복하기: 인스턴스 필드 사용
## 14. 공통 코드 분리와 사용하기: 상속의 일반화 기법
## 15. 배열 크기 자동 증가시키기: 배열 복제와 문제점
## 16. LinkedList 자료구조 구현하기: 배열의 단점 극복
## 17. 인터페이스를 이용한 객체 사용 규칙 정의
## 18. 리팩토링: GRASP의 High Cohesion 적용
## 19. 리팩토링: 상속의 Generalization 적용
## 20. 리팩토링: Map 컬렉션과 의존성 주입
## 21. 스택과 큐 다루기
## 22. Iterator 디자인 패턴을 활용하여 목록 조회 기능을 캡슐화하기
## 23. 특정 클래스에서만 사용되는 의존 객체는 중첩 클래스로 정의하기
## 24. 제네릭을 사용하여 타입을 파라미터로 다루기
## 25. 자바 Collection API 사용하기
## 26. 메뉴 UI를 캡슐화하기: GoF의 Composite 패턴 적용
## 27. 각각의 메뉴 처리 기능을 객체화 하기: GoF의 Command 패턴 적용하기
## 28. File I/O API 활용하기 I : 데이터를 바이너리 형식으로 입출력
## 29. File I/O API 활용하기 II : 데코레이터를 이용한 데이터 변환 자동화
## 30. File I/O API 활용하기 III : 객체 직렬화/역직렬화
## 31. File I/O API 활용하기 IV : 데이터를 CSV 형식의 텍스트로 입출력
## 32. File I/O API 활용하기 V : JSON 형식의 텍스트로 입출력
## 33. Apache POI 라이브러리 활용하기 : 데이터를 엑셀 포맷의 파일로 입출력
## 34. DAO 객체 필요성 이해하기 : 데이터 컬렉션을 List에서 Map으로 교체
## 35. 데이터 접근 로직을 캡슐화하기 : DAO 객체 도입
## 36. 애플리케이션 시작/종료 상태일 때 알림 받기 : GoF의 Observer 패턴 적용 
## 37. 애플리케이션 간에 데이터 공유하기 : Client/Server 아키텍처로 전환
## 38. 여러 클라이언트의 요청을 순차적으로 처리하기: Stateful vs Stateless
## 39. 여러 클라이언트의 요청을 동시에 처리하기: Multi-thread 적용
## 40. DBMS 도입하기
## 41. 외부키(Foreign Key) 사용하기
## 42. 로그인/로그아웃 적용하기
## 43. SQL 삽입 공격 차단하기
## 44. JDBC 코드를 캡슐화하기 
## 45. Mybatis 퍼시스턴스 프레임워크 사용하기
## 46. DAO 객체를 자동 생성하기
## 47. Application Server 아키텍처로 전환하기

- 애플리케이션 서버 아키텍처의 특징과 구현
- Executor를 이용하여 스레드를 풀링하기




## 45. 스레드 재사용하기 : 스레드풀(thread pool) 구현

- Pooling 기법을 활용하여 스레드 객체를 관리하는 방법
- 스레드를 재사용 하는 방법
- GoF의 FlyWeight 디자인 패턴(풀링 기법)을 적용하여 스레드풀을 구현하는 방법

## 46. 스레드 재사용하기 : 자바에서 제공하는 스레드풀(thread pool) 사용

- Excutors/ExcutorService 사용법







## 50. 여러 스레드가 DB 커넥션을 공유할 때의 문제점과 해결책 I

- 여러 스레드에서 DB 커넥션 객체를 공유할 때의 문제점 이해
- SQL 실행할 때 마다 Connection 생성하기
  - 이점: 다른 스레드의 commit/rollback 작업에 영향을 받지 않는다.
  - 단점: 여러 개의 데이터 변경(insert,update,delete) 작업을 하나의 트랜잭션으로 묶을 수 없다.


## 51. 여러 스레드가 DB 커넥션을 공유할 때의 문제점과 해결책 II

- 스레드 당 한 개의 DB 커넥션 사용하기
  - 다른 스레드의 commit/rollback 작업에 영향을 받지 않는다.
  - 트랜잭션을 사용할 수 있다.
- ThreadLocal을 사용하여 스레드 별로 Connection 객체를 유지시킨다.

## 52. 트랜잭션을 제어하는 객체: 비즈니스 로직을 수행하는 객체

- DAO에서 트랜잭션을 제어할 때 문제점
- 비즈니스 로직을 수행하는 객체에서 트랜잭션을 제어
  - 예: XxxHandler 


## 53. DB 커넥션 풀을 이용한 Connection 재사용하기

- 스레드 당 한 개의 DB 커넥션을 유지할 때 문제점
  - DB 커넥션의 낭비가 심하다.
  - DB 커넥션을 효율적으로 사용하지 못한다.
- 풀링 기법을 이용하여 DB 커넥션을 재사용하는 방법

## 54. 트랜잭션 제어 기능을 분리하기

- 트랜잭션 제어 기능을 별도의 클래스로 캡슐화하기
- 컨넥션 객체 사용 후 커넥션풀에 자동 반납하는 방법
  - Proxy 패턴을 이용하여 Connection 객체의 close() 기능 변경



## 56. 로그인/로그아웃 적용하기

- 로그인/로그아웃 구현하는 방법
- HttpSession 객체를 사용하는 방법
- 로그인 정보를 가지고 관련 데이터를 다루는 방법
  - 게시글 입력/변경/삭제할 때 로그인 정보 사용

## 57. 웹 애플리케이션 서버 구조로 전환하기 - 웹 기술 도입

- 임베디드 톰캣 서버를 이용하여 웹 애플리케이션 서버를 구축하는 방법
- 웹브라우저를 이용하여 클라이언트를 구축하는 방법
- 웹 기술을 도입하여 애플리케이션을 만드는 방법
- 세션을 이용해 로그인을 다루는 방법

## 58. 리스너 및 웹 애플리케이션 저장소 활용하기

- ServletContextListener 활용법
  - 웹애플리케이션을 시작하거나 종료할 때 작업을 수행시키는 방법
  - 예) 모든 서블릿이 공유하는 자원을 준비하기에 적절한 위치다.
- ServletContext 활용법
  - 웹애플리케이션당 1개가 생성되는 객체 저장소
  - 웹애플리케이션에서 공유할 객체를 보관하기에 적절하다.
  - 예) DB 커넥션, DAO, 트랜잭션 관리자 등

## 59. GET/POST 요청을 구분하기

- HttpServlet의 doGet(), doPost를 이용하여 GET 요청과 POST 요청을 구분하여 처리하기
- 로그인, 게시글 등록 및 변경, 회원 등록 및 변경, 과제 등록 및 변경에 적용

## 60. refresh/redirect 다루기

- 로그인 후 refresh 하기
- 로그아웃 후 redirect 하기
- 데이터 등록/변경/삭제 후 목록 페이지로 이동할 때 redirect 하기

## 61. forward/include 다루기

- 상단 메뉴 및 하단 정보 출력에 include 사용하기
- 오류 메시지 출력에 forward 사용하기

## 62. 파일 업로드 다루기 - multipart/form-data POST 요청 파라미터 인코딩

- Servlet API를 이용하여 multipart/form-data 파라미터를 다루는 방법
- 회원 사진 추가
  - DDL 변경

## 63. 쿠키 활용하기

- 쿠키를 이용하여 로그인 할 때 입력한 이메일을 보관하기

## 64. 필터 활용하기

- 필터를 활용하는 방법

## 65. JSP를 이용하여 MVC 모델2 구조로 변경하기

- MVC 모델1/모델2 특징 이해
- JSP 구동 원리 이해 및 사용법
- 서블릿과 JSP의 역할 및 구동 원리

## 66. EL 및 JSTL 활용하기

- EL 사용법
- JSTL 사용법

## 67. Front Controller 디자인 패턴 도입하기

- Front Controller 디자인 패턴의 효과 및 적용 방법
- 프론트 컨트롤러와 페이지 컨트롤러의 역할 이해

## 68. 페이지 컨트롤러를 POJO로 전환하기

- 페이지 컨트롤러를 POJO 클래스로 변경
  POJO? Plain Old Java Object (그냥 일반 자바 문법으로 만든 클래스)
- 의존 객체 주입하기

## 69. 애노테이션으로 요청 핸들러 지정하기

- 인터페이스 대신 애노테이션을 사용하여 요청 핸들러를 지정하는 방법
- 특정 애노테이션이 붙은 메서드를 찾아 호출하는 방법

## 70. CRUD 페이지 컨트롤러를 한 개의 페이지 컨트롤러로 합치기

- 한 개의 페이지 컨트롤러에 CRUD 요청 핸들러를 합치는 방법
- 애노테이션을 이용하여 요청 URL에 따라 핸들러를 구분하는 방법

## 71. 요청 핸들러의 파라미터를 자동으로 인식하기

- 요청 핸들러에 선언된 파라미터에 따라 값을 전달하는 방법

## 72. 페이지 컨트롤러를 자동 생성하기

- 애노테이션과 리플렉션 API를 사용하여 페이지 컨트롤러를 자동 생성하는 방법

## 73. IoC 컨테이너 만들기

- IoC 컨테이너의 구동 원리 이해와 구현하기
- 페이지 컨트롤러 및 의존 객체를 IoC 컨테이너로 관리하기

## 74. Spring IoC 컨테이너 도입하기

- Spring IoC 컨테이너를 이용하여 객체를 자동 생성하는 방법
- 의존 객체를 자동으로 주입하는 방법
- Spring IoC 컨테이너에 들어 있는 객체를 꺼내 사용하는 방법

## 75. Spring WebMVC 프레임워크 도입하기

- Spring WebMVC 프레임워크 사용법
  - CharacterEncodingFilter 사용법
  - ContextLoaderListener 사용법
  - DispatcherServlet 사용법

## 76. Spring WebMVC를 Java Config로 설정하기

- Java Config를 이용하여 Spring WebMVC를 설정하는 방법
- Log4j2 적용하는 방법
- @GetMapping, @PostMapping, Model, MultipartFile 적용하는 방법
- @ControllerAdvice, @InitBinder 사용하여 파라미터의 PropertyEditor를 등록하는 방법
- 예외가 발생했을 때 출력될 오류 페이지를 설정하는 방법 : @ExceptionHandler

## 77. Spring WebMVC의 기본 ViewResolver를 InternalResourceViewResolver로 교체하기

- InternalResourceViewResolver를 설정하고 다루는 방법




## 79. Mybatis 설정을 XML에서 Java Config로 바꾸기

- Java Config로 Mybatis를 설정하는 방법
  - 'mybatis-spring' 라이브러리 추가
  - 'spring-jdbc' 라이브러리 추가

## 80. @Transactional을 사용하여 트랜잭션 다루기

- @Transactional 사용법
  - @EnableTransactionManagement 용도 이해 
- @Transactional이 붙은 메서드의 구동 원리 이해
  - - 프록시 패턴 기술을 사용하여 트랜잭션 코드를 삽입

## 81. DAO 구현체 자동 생성하기

- Mybatis의 Spring 연동 플러그인을 사용하여 DAO를 자동 생성하는 방법

## 82. Controller에서 비즈니스 로직 분리하기: 서비스 컴포넌트 도입

- Controller에서 비즈니스 로직을 분리하는 이유
- 서비스 컴포넌트의 역할 이해

## 83. Lombok 적용하기

- Lombok 사용법

## 84. 뷰 템플릿 기술을 Thymeleaf 로 교체하기

- Thymeleaf 사용법

## 85. 첨부파일을 네이버 클라우드의 스토리지 서비스에 저장하기

- 네이버 스토리지 서비스 사용법
- 첨부파일을 스토리지 서비스에 업로드하는 방법

## 86. 네이버 클라우드의 Image Optimizer를 이용하여 썸네일 이미지 다루기

- 네이버 클라우드의 Image Optimizer 사용법

## 87. SpringBoot(2.7.x) 적용하기

- SpringBoot 사용법

## 88. 페이징 처리 적용하기

- 목록에 페이징 적용하기

## 89. WYSIWYG 자바스클립트 편집기 사용하기 - summernote 활용

- summernote 활용법
- 게시판에 적용하기

## 90. summernote 응용 - 콘텐트에 포함된 이미지 파일 별도 저장

- 콘텐트에 포함된 이미지 파일을 object storage에 별도 저장하기
- application.properties 파일을 운영모드와 개발모드로 분리하기
  - application-prod.properties(운영모드)
  - application-dev.properties(개발모드)
  - 실행 옵션
    - JVM 아규먼트: `-Dspring.profiles.active=dev`
    - 프로그램 아규먼트: `--spring.profiles.active=dev`
- 보안 정보를 담은 .properties 파일을 프로젝트에서 분리하기
  - @PropertySource 설정
    - "${user.home}/config/ncp-secret.properties"
    - "file:${user.home}/config/ncp.properties"
    - "file:${user.home}/config/ncp-secret.properties"
 
## 91. SpringSecurity 적용하기

- SpringSecurity 사용법
  - login, logout 처리하는 방법
- HandlerMethodArgumentResolver 사용법

## 92. AJAX 기술을 이용하여 Backend와 Frontend 분리하기 - XMLHttpRequest 활용

- XMLHttpRequest를 이용한 AJAX 활용법
- REST API를 구현하는 방법


## 86. Backend와 Frontend를 서로 다른 서버로 분리하기

- Node.js 와 express를 이용하여 프론트엔드 서버 구축하는 방법
- CORS를 다루는 방법
- CSRF를 다루는 방법

## 87. AJAX 기술 다루기 - fetch() 활용

- fetch() 를 사용하여 AJAX 요청을 처리하는 방법
- Promise 문법을 활용하는 방법

## 88. AJAX 기술 다루기 - jQuery 활용

- jQuery 를 사용하여 AJAX 요청을 처리하는 방법
- jQuery 를 이용하여 DOM 트리를 다루는 방법
- npm을 이용하여 외부 자바스크립트 라이브러리를 사용하는 방법

## 89. AJAX 기술 다루기 - axios 활용

- axios 를 사용하여 AJAX 요청을 처리하는 방법

## 90. JavaScript 템플릿 라이브러리 적용하기 - Handlebars 활용

- Handlerbars 를 사용하여 HTML 템플릿에 데이터를 삽입하여 HTML 코드를 생성하는 방법

## 91. JWT 사용자 인증 적용하기

- JWT 를 활용하여 사용자를 인증하는 방법


## 93. SNS 로그인 적용하기 - Facebook 로그인

- 페이스북 Login API 사용법
- 소셜 로그인 구동원리 이해

## 94. OpenFeign REST Client 사용하기 - RestTemplate 대체

- Spring Cloud OpenFeign 설정과 사용법