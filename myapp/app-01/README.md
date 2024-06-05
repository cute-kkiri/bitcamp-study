# 01. 자바 프로젝트 준비하기

## 학습목표

- Gradle 빌드 도구를 사용하여 자바 프로젝트 폴더를 구성할 수 있다.
- Gradle 빌드 스크립트 파일에서 실행할 클래스를 설정할 수 있다.
- Gradle 빌드 도구를 사용하여 애플리케이션을 실행할 수 있다.
- 콘솔로 값을 출력할 수 있다.
- IntelliJ IDE에서 Gradle 프로젝트를 실행할 수 있다.

## 요구사항 

- myapp 폴더를 만들고 자바 프로젝트 폴더로 구성
- IntelliJ IDE로 프로젝트 가져온 후 실행 

## 실행 결과

```
[팀 프로젝트 관리 시스템]
```

## 작업

- 1) myapp 폴더 생성
```
$ mkdir myapp
$ cd myapp
```

- 2) 자바 프로젝트 폴더 구성
```
$ gradle init
Select type of build to generate:
  1: Application
  2: Library
  3: Gradle plugin
  4: Basic (build structure only)
Enter selection (default: Application) [1..4] 1

Select implementation language:
  1: Java
  2: Kotlin
  3: Groovy
  4: Scala
  5: C++
  6: Swift
Enter selection (default: Java) [1..6] 1

Enter target Java version (min: 7, default: 21): 그냥 엔터

Project name (default: myapp): 그냥 엔트

Select application structure:
  1: Single application project
  2: Application and library project
Enter selection (default: Single application project) [1..2] 1

Select build script DSL:
  1: Kotlin
  2: Groovy
Enter selection (default: Kotlin) [1..2] 2

Select test framework:
  1: JUnit 4
  2: TestNG
  3: Spock
  4: JUnit Jupiter
Enter selection (default: JUnit Jupiter) [1..4] 그냥 엔터

Generate build using new APIs and behavior (some features may change in the next minor release)? (default: no) [yes, no]  그냥 엔터

```

- 3) 애플리케이션 실행
```
$ gradle run

> Task :app:run
Hello World!

BUILD SUCCESSFUL in 2s
2 actionable tasks: 2 executed

```

- 4) IntelliJ IDE 로 프로젝트 가져오기
    - 프로젝트 열기: myapp/settings.gradle 선택 > 프로젝트 열기
- 5) 애플리케이션 제목을 출력: App.main()
- 6) 애플리케이션 실행
    - Gradle 도구: myapp/Tasks/application/run 실행 


## 변경한 파일

- build.gradle
```
application {
    mainClass = 'bitcamp.myapp.App'
}
```
- App.java

