# 63. WebApplicationInitializer를 통해 Spring WebMVC 설정하기

## 학습목표

- 서블릿 컨테이너의 Service-provider 로딩 정책과 구동 원리를 설명할 수 있다.
- ServletContainerInitializer를 구현하고 적용할 수 있다.
- Spring WebMVC의 WebApplicationInitializer를 구현하고 적용할 수 있다. 

## 요구사항

- WebApplicationInitializer 구현체를 통해 DispatcherServlet과 ContextLoaderListener를 준비하라.

## 실행 결과

- 이전과 같다.

## 작업

- RootConfig 클래스 생성 
  - ContextLoaderListner의 IoC 컨테이너 설정 클래스
  - DB 관련 객체, 서비스 객체 등 공통 객체 준비
- AppConfig 클래스 생성
  - DispatcherServlet의 IoC 컨테이너 설정 클래스
  - 페이지 컨트롤러, 웹 관련 객체 준비
- WebApplicationInitializer 구현체 생성
  - WebApplicationInitializerImpl 클래스 정의

## 소스 파일

