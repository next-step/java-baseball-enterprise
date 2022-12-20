# 숫자 야구 게임
### Prior Function

* Main 함수 구현
  * 원하는 결과가 나올 때까지 반복
* 구조 설계 및 각 기능의 클래스 생성

### Function

**Create Computer Number**

* Computer가 생성한 자동으로 생성한 숫자
* 초기에 설정된 길이만큼의 숫자로 생성

**Create User Number**

* 초기에 설정된 길이만큼의 숫자만 입력되어야 함
* 숫자가 아니거나 길이가 일치하지 않는 경우 재입력

**Number Matching**

* Ball / Strike의 갯수를 파악
* Computer Number 기준에서 User Number를 매칭시켜야 함
  * ex) Computer Number가 211인 경우,  User Number가 123으로 입력
    * ball: 2개, Strike: 0개
    * 반대로 대입하면 ball: 3개, Strike: 0개로 계산됨
