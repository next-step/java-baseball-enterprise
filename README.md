# 숫자 야구 게임

## 진행 방법

* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정

* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/ent-precourse)

## 구현

### 클래스 목록(가제)

- `Main`: 숫자 야구를 처음에 실행하는 메인 클래스(진입점)
- `NumberBaseball`: 숫자 야구 게임 클래스, 게임의 전체적인 흐름을 담당한다.
- `utils.RadomUtils`: 랜덤과 관련된 유틸리티 클래스
- `utils.InteractionUtils`: 사용자와의 상호작용을 위한 유틸리티 클래스

### 구현 기능 목록

- [x] 게임 시작
    - [x] 게임에 사용될 랜덤 정답 생성
        - [x] 정답 중복 숫자 검증
- [x] 사용자 입력
- [x] 입력과 답 계산
- [x] 결과 출력
    - [x] 맞았으면 플레이 종료
    - [x] 틀렸으면 사용자 입력부터 다시
- [x] 플레이 종료 시, 게임 재시작 여부 입력
    - [x] 1일 경우, 종료
    - [x] 2일 경우, 게임 재시작
    - [x] 그 외의 경우, 재입력
- [x] 모든 입력 시 검증 과정

## 요구사항

### 기능

- 기본적으로 1부터 9까지 **서로 다른 수**로 이루어진 3자리의 수를 맞추는 게임이다.
    - 같은 수가 같은 자리에 있으면 **스트라이크**, 다른 자리에 있으면 **볼**, 같은 수가 전혀 없으면 **포볼 또는 낫싱**이란 힌트를 얻고, 그 힌트를 이용해서 먼저 상대방(컴퓨터)의 수를 맞추면
      승리한다.
    ```text
    예)
    상대방(컴퓨터)의 수가 425일 때
  
    123을 제시한 경우 : 1스트라이크
    456을 제시한 경우 : 1스트라이크 1볼
    789를 제시한 경우 : 낫싱
    ```
- 위 숫자 야구게임에서 상대방의 역할을 컴퓨터가 한다. 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택한다. 게임 플레이어는 컴퓨터가 생각하고 있는 3개의 숫자를 입력하고, 컴퓨터는 입력한 숫자에 대한
  결과를 출력한다.
- 이 같은 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료된다.
- 게임을 종료한 후 **게임을 다시 시작하거나 완전히 종료할 수 있다.**

### 단위 테스트

- **로직에 단위 테스트를 구현한다. 단 UI(System,out, System.in, Scanner) 로직은 제외**
    - 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
- [**JUnit5** 와 **AssertJ**
  기반 단위 테스트](https://drive.google.com/file/d/1Gsn5ObkoNPi9i7pmBtEBTAONSImtWF4M/view?usp=sharing)를 구현한다.

### 과제 진행

- 기능을 구현하기 전에 `java-baseball/README.md` 파일에 구현할 기능 목록을 정리해 추가한다.
- git의 commit 단위는 앞 단계에서 `README.md` 파일에 정리한 기능 목록 단위로 추가한다.
- [AngularJS Commit Message Conventions](https://gist.github.com/stephenparish/9941e89d80e2bc58a153) 을 참고해 commit log를
  남긴다.
- 과제 진행 및 제출 방법은 [프리코스 과제 제출 문서](https://github.com/next-step/nextstep-docs/tree/master/ent-precourse) 를 참고한다.

### 코딩 스타일

[자바코드 컨벤션](https://github.com/woowacourse/woowacourse-docs/tree/master/styleguide/java)을 지키면서 프로그래밍한다.

- indent depth를 2가 넘지 않도록 구현한다. 1까지만 허용한다.
    - 예) while문 안에 if문이 있으면 들여쓰기는 2.
    - 힌트: indent depth를 줄이는 좋은 방법은 함수(또는 메소드)를 분리하면 된다.
- 자바 8에 추가된 stream api를 사용하지 않고 구현해야 한다. 단, 람다는 사용 가능하다.
- `else` 예약어를 쓰지 않는다.
    - 힌트: `if` 조건절에서 값을 return 하는 방식으로 구현하면 `else`를 사용하지 않아도 된다.
- `switch/case` 를 허용하지 않는다.
- 함수(또는 메소드)의 길이가 10라인을 넘어가지 않도록 구현한다.
- 함수(또는 메소드)가 한 가지 일만 잘 하도록 구현한다.
