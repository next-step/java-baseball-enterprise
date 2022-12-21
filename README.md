# 숫자 야구 게임 - 어떻게 구현할 것인가?
## dataobject package
### NumBalls interface
숫자야구에서 숫자를 담을 객체들을 위한 인터페이스이다.   
문제의 조건에서는 1~9만을 허용하나, 확장에 자유롭기 위하여(0 허용, 중복 허용 등의 가능성) 인터페이스를 구현하였다.

#### 메서드
* public int getNum(int index) - index번째에 해당하는 공 출력(0~size-1)
* public int getSize(); - 공이 몇 개 있는지 알 수 있는 메서드(이번 요구사항에서는 3)
* public TrialResult compare(NumBalls trial) - trial(예상 시도)를 했을 때 몇 스트라이크 몇 볼인지 출력


### NumBallsNBalls class implements NumBalls
숫자야구에서 숫자 공 n개를 저장할 data object이다.  
숫자 n개가 1-9 사이의 값을 가지며, 중복되지 않음을 보장한다.  
(중복되거나 1-9 사이의 값을 가지지 않는 경우 WrongNumbersException 예외를 발생시킨다)

#### 인스턴스 변수
* private final ArrayList<Integer> nums - 숫자야구에서 사용할 공 n개(1~9 사이의 숫자)를 나타낸다.
* private final int size;

#### 메서드
* private int randomlyChoose(Set<Integer> numSet) - numSet에 들어있는 값 중 랜덤한 값을 return한다.
* private void isValidNumber(ArrayList<Integer> nums) - nums가 숫자야구 조건에 맞는지 확인한다(1~9 사이의 값, 중복되지 않음), 조건에 맞지 않으면 WrongNumberException 발생.
* public NumBalls(int size) - 숫자야구 조건에 맞는 랜덤한 숫자 n개를 nums에 저장한다.
* public NumBalls(ArrayList<Integer> nums) - 지정한 nums대로 저장한다. size는 nums의 크기로 저장된다. 조건에 맞지 않으면 WrongNumberException을 발생시킨다.
* public int getNum(int index) - index번째에 해당하는 숫자 출력
* public int getSize() - size를 return
* private void compareOne(int thisIndex, int trialIndex, TrialResult result) - trial의 trialIndex번째 수가 thisIndex(없으면 -1)에 있을 때 스트라이크/볼/낫싱을 result에 갱신
* public TrialResult compare(NumBalls trial) - trial이 NumBallsNBalls의 객체인지 확인 후(같지 않으면 예외 발생), 결과를 반환

### TrialResult class
Trial을 한 결과로 나오는 a스트라이크 b볼에 대한 정보를 저장하는 data object이다.

#### 인스턴스 변수
* private int strike = 0 - 스트라이크 개수를 저장
* private int ball = 0 - 볼 개수를 저장
* private final int size - 총 공의 개수를 저장

#### 메서드
* public TrialResult(int size) - size 초기화 후, (strike,ball) = (0,0)으로 초기화하는 생성자
* public TrialResult(int strike, int ball, int size) - 매개변수대로 strike, ball, size을 초기화하는 생성자
* private chkValidNumber(int strike, int ball) - strike, ball이 가능한 경우인지(각각 0 이상의 값, 0<=strike+ball<=size, (size-1) strike 1 ball 불가능)
* getter - strike, ball, size 변수에 대해서.
* public setStrikeBall(int strike, int ball) - strike, ball을 따로 결정하는 경우 예외발생을 적절히 확인하지 못함.
*** 

## manager package
### ProcessManager Class
게임 전체의 lifecycle을 담당하는 클래스  
ProcessManager Class와는 Aggregation 연관을 가진다.

#### 인스턴스 객체
* private GameUserInterface gameUserInterface - 입출력을 담당하는 ui객체
* private GameManager gameManager - 한 게임이 시작될 때 그 게임의 설정을 가지는 객체

#### 인스턴스 메소드
* setter - (gameManager, gameUserInterface에 대해)
* public ProcessManager(GameUserInterface gameUserInterface) - gameUserInterface를 주입
* public void execute() - 프로그램을 실행

### GameManager Class
한 게임의 시작(숫자 size개를 랜덤하게 정함)부터 끝(사용자가 size개를 다 맞춤)까지의 한 사이클을 담당하는 클래스  
gameUserInterface, numBalls를 initialize하며 다 맞출 때 까지 계속 묻고 결과를 출력해준다.

#### 인스턴스 객체
* private GameUserInterface gameUserInterface - 입출력을 담당하는 ui객체
* private final NumBalls answer; - 정답을 담을 객체
* private final int size - 숫자야구 공의 개수

#### 인스턴스 메소드
* public GameManager(GameUserInterface gameUserInterface, NumBalls numBalls, int size) - 각각의 객체를 주입 및 size, answer 초기화
* public void execute() - 게임 실행 전반을 책임질 메소드
* private boolean executeOneCycle() - 게임 중 한 사이클(숫자 입력 후 출력까지)를 담당. 게임이 끝나는 경우 true 반환

***
## exception package
### WrongNumberException class extends RunTimeException
* NumBalls, TrialResult 등에서 조건에 맞지 않는 값이 입력되는 경우에 대한 예외.
### WrongTypeException class extends RunTimeException
* NumBallsNBalls.compare(NumBalls trial)에서 trial이 원래 비교대상과 형식이 같지 않는 경우 발생시킴.

***


## ui package
### GameUserInterface Interface
사용자와 어떤 입력을 받으며, 어떤 출력을 하는지에 대한 함수가 정의되어 있다.
* ArrayList<Integer> inputNumbers() - 입력을 받아 ArrayList<Integer>형태로 저장하여 return
* void printResult(TrialResult res) - TrialResult 객체를 받아 strike, ball을 출력
* void printError(Exception e) - Exception e에 따라 여러 가지의 에러 문구 표시
* void printGameClear() - 게임을 통과하였을 시에 출력
* boolean printRetry() - 다시 하시겠습니까? 출력

### GameUserInterfaceKorean Class implements GameUserInterface
UI를 구현할 클래스. 한국어로 prompt되기 때문에 GameUserInterface**Korean**으로 하였다.

### GameUserInterfaceTestStub Class implements GameUserInterface
단위 Test시 입출력을 거치지 않고 테스트하기 위한 TestStub

