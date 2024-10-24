# 69. HandlerMethodArgumentResolver 사용하기

## 학습목표

- HandlerMethodArgumentResolver를 사용할 수 있다. 

## 요구사항

- request handler에서 로그인 정보를 파라미터로 받아라.

## 실행 결과

- 이전과 같다.

## 작업

- 파라미터에 붙일 애노테이션 정의
  - @LoginUser 정의 
- LoginUser 애노테이션 파라미터 값을 리턴할 해결사 정의 
  - LoginUserArgumentResolver 정의 
- WebMvcConfigurer 구현체 변경
  - addArgumentResolvers() 구현
- 로그인 정보를 요구하는 페이지 컨트롤러에 적용
  - BoardController 변경
  
## 소스 파일

