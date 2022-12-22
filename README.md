# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/ent-precourse)


## 기능 목록


### 1. GameRule : 숫자야구 게임 규칙상의 조건과 절차

 - numbers 조건
    - length 3
    - letter range 1 ~ 9
    - letter 중복 없음

 - 2 numbers A, B 대조
    - a in A is in B => ball += 1
    - ai = bi => strike += 1
    - ball -= strike

 - 게임 결과 생성
    - 스트라이크와 볼의 갯수
    - 3스트라이크시 게임 종료 명시


### 2. UI : 입출력을 담당하는 인터페이스

 - numbers 입력
    - string 입력 받기
    - GameRule을 참조하여 올바른 입력인지 검증하기
    - 올바른 입력일 시 string을 array로 변환하여 리턴

 - 인게임 결과 출력
    - 인자로 받은 스트라이크 볼 갯수를 자연어로 번역
        - 0인 경우 생략
        - 둘 모두 0일 경우 낫싱
    - 인게임 반복 여부 리턴
        - 3 스트라이크일 경우 False
        - 그 외 True

 - 게임 종료 여부 입력
    - 인게임 종료 알림 출력
    - string 입력 루프
        - 잘못된 입력인 경우 리로드
    - 게임 종료 여부 리턴
        - 1일 경우 False
        - 2일 경우 True


### 3. Computer : 인게임 상대 역할
 - 자신의 numbers 생성
    - 새 게임 시작을 전달받았을 때 실행
    - GameRule을 참조하여 numbers 필드 갱신
 - 인게임 결과 전달
    - numbers를 전달받았을 때 실행
    - GameRule의 게임 결과 생성 메소드를 이용하여 인게임 결과 받기
    - 인게임 결과 리턴


### 4. Control : 게임 흐름 제어

 - 객체 생성, 게임 루프 시작
 - 게임 루프
    - Computer에게 새 게임 시작 알리기
    - 인게임 루프 시작
    - 인게임 루프
        - UI 메소드 호출하여 numbers 받기
        - numbers를 Computer에게 전달하여 인게임 결과 받기
        - 인게임 결과를 인자로 UI 메소드 호출하여 인게임 반복 여부 받기
        - 인게임 반복 여부에 따라 루프 반복 혹은 탈출
    - 인게임 루프 탈출 = 게임 종료
    - UI 메소드 호출하여 게임 재시작 여부 받기
    - 게임 재시작 여부에 따라 루프 반복 혹은 탈출
 - 게임 루프 탈출 = 프로세스 종료
