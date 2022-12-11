## 숫자 야구 게임 기능 목록

#### 게임 컨트롤러 `GameController`
- [ ] 최초에 게임 생성
- [ ] 사용자의 정답 입력에 대해 결과 판정 후 출력
- [ ] 3 스트라이크인 경우 해당 게임 종료
- [ ] 게임이 끝난 후 추가 진행 여부 입력이 1인 경우 새 게임 생성
- [ ] 게임이 끝난 후 추가 진행 여부 입력이 2인 경우 전체 게임 종료

#### 숫자 야구 게임 `BaseballGame`
- [ ] 최초 생성시 `NumberGenerator`를 통해 정답 생성

#### 컴퓨터 숫자 생성 `BaseballNumbersGenerator`
- [ ] `BaseballNumbers`(1부터 9까지 서로 다른 수로 이루어진 3자리의 수) 생성

#### 사용자의 입력 받음 `InputView`
- [ ] 사용자의 정답을 입력 받음
- [ ] 사용자의 새 게임 진행 여부를 입력 받음

#### 메시지 출력 `OutputView`
- [ ] `StrikeBallCount`에 대한 결과 출력

#### 사용자의 정답 입력 검증 `InputUserAnswerValidator`
- [ ] 사용자의 정답 입력을 검증
- [ ] 사용자의 정답 입력을 `BaseballNumbers`로 변환

#### 사용자의 새 게임 진행 여부 입력 검증 `InputRestartValidator`
- [ ] 사용자의 새 게임 진행 여부 입력을 검증

#### 결과 판정 `Judge`
- [ ] 게임의 정답과 사용자가 입력한 답을 비교하여 `StrikeBallCount` 생성
- [ ] 각각의 숫자에 대해 포함된 여부, index가 같은 지 확인
