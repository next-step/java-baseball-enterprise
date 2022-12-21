# 숫자 야구 게임
* 1~9 까지 서로 다른 수로 이루어진 3자리 수를 맞춰야함
* 같은 자리에 같은 숫자면 스트라이크 자리가 같지 않다면 볼 없다면 노 카운트

## 기능 목록
* Application
* Game
    * start
        * 게임 시작.
    * count
        * 생성된 난수와 입력값 비교.
        * countStrikeBall
            * 각 숫자별 스트라이크, 볼 판별.
    * replay
        * 게임 재시작.
* Computer
    * makeNumber
        * 중복된 숫자가 없는 세자리수 생성.
* Human
    * input
        * 플레이어가 입력한 값, 포지션 저장.
* Common
    * 공통적으로 쓰이는 함수 모음
    * validation
        * 생성된 난수, 플레이어 입력값 검증.
    * setPositionNumber
        * 생성된 난수, 플레이어 입력값 map 저장.
