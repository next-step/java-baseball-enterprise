# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/ent-precourse)


## 메소드 구현 설명
### 1. void setAnswer()
- 컴퓨터가 정한 임의의 정답인 answer 배열을 초기화하는 메소드
### 2. void setGuess(int inputNumber)
- 플레이어가 맞추어야 할 정답인 guess 배열을 초기화하는 메소드
- inputNumber를 슬라이싱하여 세 자리수를 만들어 guess를 초기화한다.
### 3. int checkNumber(int idx)
- guess 의 idx 번째 숫자를 확인하여 볼, 스트라이크 여부를 확인하는 메소드
- 스트라이크라면 10를 리턴한다.
- 볼이라면 1을 리턴한다.
- 둘 다 아니라면 0을 리턴한다.
### 4. boolean checkGuess()
- 0, 1, 2를 각각 checkNumber() 메소드의 arg 로 넣어 리턴값을 모두 result 변수에 넣는다.
- result 의 10의 자리는 스트라이크의 수를, 1의 자리는 볼의 수를 의미한다.
- result 값에 따라 알맞은 결과 메시지를 출력한다.
- 정답을 맞춘 경우 isRestart() 메소드를 호출하여 게임의 지속 여부를 결정한다. 
### 5. isRestart()
- 사용자의 입력값에 따라 게임의 지속 여부를 결정하는 메소드
- 사용자의 입력이 1이라면 setAnswer() 메소드를 호출하여 answer를 변경한 뒤 true를 리턴한다.
- 사용자의 입력이 2라면 false를 리턴한다.