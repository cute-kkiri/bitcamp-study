# 64. Spring WebMVC 활용하기

## 학습목표

- @Controller와 @RequestMapping 애노테이션을 사용할 수 있다.
- @PathVariable 애노테이션을 사용할 수 있다. 
- @ResponseBody 애노테이션을 사용할 수 있다.
- @ControllerAdvice 애노테이션을 사용할 수 있다.
- @InitBinder, @ExceptionHandler 애노테이션을 사용할 수 있다.
- 인터셉터를 사용할 수 있다.

## 요구사항

- Spring WebMVC의 다양한 기법을 활용하라.

## 실행 결과

- 이전과 같다.

## 작업

- @Controller와 @RequestMapping
  - 모든 페이지 컨트롤러에 적용
- @PathVariable
  - UserController에 적용
- @ControllerAdvice
  - GlobalControllerAdvice 클래스 생성
- @InitBinder, @ExceptionHandler
  - GlobalControllerAdvice에 적용
- 인터셉터 적용
  - AdminInterceptor 생성
  - AppConfig 클래스 변경 

## 소스 파일

