# 71. SpringSecurity 적용하기

## 학습목표

- Spring Security를 적용할 수 있다.

## 요구사항

- 애플리케이션에 Spring Security를 적용하라.

## 실행 결과

- 이전과 같다.

## 작업

- 1단계: Spring Security Java Config 정의하기
  - 구동 원리
  - 기본 로그인 화면과 로그인 처리
- 2단계: 커스텀 로그인폼 사용하기
  - 커스텀 로그인폼에 연결
  - 요청 파라미터 이름 변경 및 로그인 URL 설정
- 3단계: DB의 사용자 정보와 연동하기
  - UserDetails와 UserDetailsService 역할 이해
  - 기존 UserService 객체와 연결
- 4단계: 암호 인코더의 역할 이해하기
  - PasswordEncoder 구현과 적용
  - UserDetails의 기본 암호 인코더 제거하기
- 5단계: 커스텀 암호 인코더 사용하기
  - 커스텀 암호 인코더 구현과 적용
- 6단계: 스프링 시큐리티에서 제공하는 암호 인코더 사용하기
  - BCryptPasswordEncoder 적용하기
  - DB 대신 애플리케이션에서 암호 인코딩하기
  - 회원 정보 등록과 변경에 암호 인코더 적용하기
- 7단계: 로그인 정보를 세션에 보관하기
  - 스프링 시큐리티의 로그인 정보를 페이지 컨트롤러가 받아 처리
- 8단계: 커스텀 UserDetails 사용하기 
  - 도메인 객체를 상속 받아 UserDetails 구현하기
  - 도메인 객체를 포함하는 방법으로 UserDetails 구현하기 
  - 페이지 컨트롤러에서 커스텀 UserDetails를 받는 방법

## 소스 파일

