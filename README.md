# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 기능설계, 구현순서
### 1차 기능 : Game, GameResult 기능
Game클래스는 찾아야 할 목표값을 저장하며 계산을 통해 GameResult 객체를 만들 수 있다.

GameResult 클래스는 게임 결과를 저장한다. 이는 strike 개수와 ball 개수를 저장하는 것을 의미한다.
여기서 이를 이용해 게임 결과를 확인하기 위한 몇몇 편의성 함수를 포함해야 한다.

#### Game 기능분석
1. Game 은 3개의 1~9 사이의 값을 저장해야 한다.
2. Game 은 3개의 1~9 사이의 값을 받아 게임 결과를 집계해 GameResult 형태로 반환 가능해야 한다.
   1. 각 값이 위치와 값이 같다면 strike 이다. 
   2. 숫자 자체는 존재하지만 위치가 다르면 ball 이다.

### 2차 기능 : GameInterface, main 함수 구현

게임 결과를 사용자 상호작용을 통해 찾아낼 수 있게 하는 GameInterface 객체와 main 함수를 구현해 사용자 상호작용을 가능하게 한다.


## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/ent-precourse)
