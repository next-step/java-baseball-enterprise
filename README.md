# 숫자 야구 게임 :baseball:

## 구현
| Branch :deciduous_tree:                                                    | Feature :feather: |
|----------------------------------------------------------------------------|-------------------|
| [feature-000](https://github.com/qsc7342/java-baseball-enterprise/pull/1)  | README 작성         |
| [feature-001](https://github.com/qsc7342/java-baseball-enterprise/pull/2)  | JUnit 학습 테스트 진행   |
| [feature-002](https://github.com/qsc7342/java-baseball-enterprise/pull/3)  | 컴퓨터 객체 생성         |
| [feature-003](https://github.com/qsc7342/java-baseball-enterprise/pull/4)  | 숫자 검증 로직 구현       |
| [feature-004](https://github.com/qsc7342/java-baseball-enterprise/pull/5)  | 테스트 코드 작성         |
| [feature-005](https://github.com/qsc7342/java-baseball-enterprise/pull/6)  | 게임 콘솔 구현          |
| [feature-006](https://github.com/qsc7342/java-baseball-enterprise/pull/7)  | 랜덤 넘버 오류 수정       |
| [feature-007](https://github.com/qsc7342/java-baseball-enterprise/pull/8)  | 유저 인풋 테스트 코드 구현   |
| [feature-008](https://github.com/qsc7342/java-baseball-enterprise/pull/9)  | 리팩토링              |
| [feature-009](https://github.com/qsc7342/java-baseball-enterprise/pull/10) | 성능 개선             |
| [feature-010](https://github.com/qsc7342/java-baseball-enterprise/pull/11) | README 수정         |
***

## 구현 기능 목록
#### Computer :computer:
* 1~9 사이의 랜덤 넘버 3개 선정
* 유저의 입력값에 대해 스트라이크와 볼 계산 ([스트라이크와 볼을 계산한 과정](https://ginger-deer-ecb.notion.site/56e1d14d4a174cb09346a2d68e9b8252))

#### Result :clipboard:
* 스트라이크와 볼 개수를 통해 결과 텍스트 생성 및 반환

#### Game :video_game:
* 터미널을 통한 안내 문구 및 반환값 등의 출력
* 게임의 전반적인 진행 (유저 인풋 등)

#### Validator :white_check_mark:
* 유저의 입력값에 대한 검증 
* 상황에 따른 적절한 예외 반환

***

## ETC

* 테스트 코드 작성
* stream 사용 금지
* else 사용 금지
* 메소드의 길이 제한 : 10라인
* [커밋 컨벤션](https://gist.github.com/stephenparish/9941e89d80e2bc58a153) 준수
* [객체지향 생활체조 원칙](https://catsbi.oopy.io/bf003ff6-2912-4714-8ac2-44eeb7becc93) 기반의 리팩토링

***