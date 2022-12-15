# 숫자 야구 게임 - 어떻게 구현할 것인가?
## dataobject package
### Num3Balls class
숫자야구에서 숫자 공 3개를 저장할 data object이다.  
숫자 3개가 1-9 사이의 값을 가지며, 중복되지 않음을 보장한다.  
(중복되거나 1-9 사이의 값을 가지지 않는 경우 WrongNumbersException 예외를 발생시킨다)  

### TrialResult class
Trial을 한 결과로 나오는 a스트라이크 b볼에 대한 정보를 저장하는 data object입니다.  
strike, ball 변수와 getter/setter/constructor로 이루어질 예정입니다.

*** 

## manager package
### ProcessManager Class  
게임 하나가 시작될 때 GameManager object를 initialize하며,  
끝날 때 retry 할지에 대해서 사용자에게 묻는 로직이 들어있는 클래스

### GameManager Class
한 게임의 시작(숫자 3개를 랜덤하게 정함)부터 끝(사용자가 3개를 다 맞춤)까지의 한 사이클을 담당하는 클래스  
ProcessManager Class와는 Aggregation 연관을 가진다.  
Num3BallsManager object를 initialize하며, 사용자가 숫자 3개를 다 맞출 때 까지 계속 묻고 결과를 출력해준다.

### Num3BallsManager Class  
Num3Balls object를 하나 가지며(초기 숫자), GameManager 클래스와 Composition 연관을 가진다.
다른 Num3Balls object가 입력으로 주어졌을 때 TrialResult object를 통해 결과를 반환한다.  

***
## exception package
### WrongNumberException class extends RunTimeException
Num3Balls에서 값이 중복되거나, 1~9 사이의 값을 가지지 않는 등 올바르지 않은 값이 입력되는 경우에 대한 예외.

***


## ui package
### GameUserInterface Interface  
사용자와 어떤 입력을 받으며, 어떤 출력을 하는지에 대한 함수가 정의되어 있다.  
* Num3Balls inputNumbers()
* void printResult(TrialResult res)
* void printError(Exception e)
* void printGameClear()
* bool printRetry(int retryCode=1, int exitCode=2)

### GameUserInterfaceKorean Class implements GameUserInterface  
UI를 구현할 클래스. 한국어로 prompt되기 때문에 GameUI**Korean**으로 하였다.  

### GameUserInterfaceTestStub Class implements GameUserInterface
단위 Test시 입출력을 거치지 않고 테스트하기 위한 TestStub
