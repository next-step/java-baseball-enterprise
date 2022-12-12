# 숫자 야구 게임

## 요구사항

### 기능 요구사항
* 기본적으로 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다.
* 같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 포볼 또는 낫싱이라는 힌트를 얻고, 그 힌트를 이용해서 먼저 상배당(컴퓨터)의 수를 맞추면 승리한다.
  * [예] 상대방(컴퓨터)의 수가 425일 때, 123을 제시한 경우 : 1 스트라이크, 456을 제시한 경우 : 1 스트라이크 1 볼, 789를 제시한 경우 : 낫싱
* 위 숫자 야구 게임에서 상대방의 역할을 컴퓨터가 한다. 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택한다. 게임 플레이어는 컴퓨터가 생각하고 있는 3개의 숫자를 입력하고, 컴퓨터는 입력한 숫자에
  대한 결과를 출력한다
* 이 같은 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임은 종료된다.
* 게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다.

### 프로그래밍 요구사항
#### 메소드 분리
* 자바 코드 컨벤션을 지키면서 프로그래밍
* 들여쓰기 깊이를 2가 넘지 않도록 구현. 1까지만 허용
  * while문 안에 if문이 있으면 들여쓰기 2
* 자바 8에 추가된 stream api를 사용하지 않고 구현
* else 예약어 사용하지 않음. switch/case 사용 불가
* 함수 길이 10라인 이하

#### 단위 테스트
* 로직에 단위 테스트를 구현. UI 로직은 제외

### 과제 진행 요구사항
* README.md파일에 구현할 기능 목록 정리
* commit 단위는 README.md파일에 정리한 기능 목록 단위로 추가
  * AngularJS Commit Message Conventions 참고해 commit log
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/ent-precourse)을 참고해 제출

## 프로그램 실행 결과
```cmd
숫자를 입력해주세요 : 123
1 스트라이크 1볼
숫자를 입력해주세요 : 145
1볼
숫자를 입력해주세요 : 671
2볼
숫자를 입력해주세요 : 216
1 스트라이크
숫자를 입력해주세요 : 713
3 스트라이크
3개의 숫자를 모두 맞히셨습니다! 게임 종료
게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.
1
숫자를 입력해주세요 : 123
1 스트라이크 1볼 
```

## 기능 목록
### 게임 클래스 (RepeatedGame)
* 반복 시작 (repeatGame)
* 게임 시작 (startGame)
* 반복 확인 (isRepeated)
### 게임 클래스 (BaseballGame)
* 생성자 (BaseballGame)
* 반복 함수 (startGame)
  * 초기화 (initGame)
    * 숫자 초기화 - 랜덤 (initNumber)
    * 숫자 초기화 - 지정 (initNumber)
  * 스테이지 시작 (startStage)
  * 스테이지 종료 출력 (printStageEnd)
* 반복 확인 (isRepeated)
### 게임 스테이지 클래스 (BaseballStage)
* 생성자 (BaseballStage)
* 반복 함수 (startGame)
  * 초기화 (initStage)
    * 숫자 초기화 - 입력 (initNumber)
    * 숫자 초기화 - 지정 (initNumber)
  * 점수 가져오기 (getScore)
  * 점수 출력하기 (printScore)
* 반복 확인 (isRepeated)
### 게임 숫자 클래스 (BaseballNumber)
* 생성자 - 지정 (BaseballNumber)
  * 정수 검증 (valid)
    * 정수 범위 검증 (validNumberRange)
    * 서로 다른 정수 검증 (validDifferentNumber)
* 생성자 - 랜덤 (BaseballNumber)
* 정수 일치 확인 (isEqual)
* 정수 존재 확인 (isInList)
### 게임 점수 클래스 (BaseballScore)
* 생성자 (BaseballScore)
  * 스트라이크 가져오기 (getStrikeScore)
  * 볼 가져오기 (getBallScore)
### 게임 UI 클래스 (GameUI)
* 생성자 (GameUI)
* 문장 출력 (print)
  * 문장 가져오기 (getString)
  * 문장 맵핑 (mapString)
* 문장 받기 (input)
### XML 파서 (XmlParser)
* HashMap 가져오기 (getHashMap)
  * Document 가져오기 (getDocument)
  * 노드 이동 (moveToTag)
  * HashMap으로 변환 (transToHashMap)