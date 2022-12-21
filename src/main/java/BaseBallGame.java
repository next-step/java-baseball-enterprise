import java.util.*;

public class BaseBallGame {
    static final int RANGE_LOW = 1;
    static final int RANGE_HIGH = 9;
    static final int DIGIT_SIZE = 3;
    static Random random = new Random();

    ArrayList<Integer> numbers;
    ArrayList<Integer> chosen;
    boolean restart;

    // 초기화 및 게임 시작
    void initGame(){
        this.restart = false;
        numbers = new ArrayList<>();
        chosen = new ArrayList<>();
        for (int i = RANGE_LOW; i <= RANGE_HIGH; i++) {
            numbers.add(i);
        }
    }

    // 임의의 수 3개 선택
    void setNumbers(){
    }


    // 임의의 수 하나 선택. 단, 이전에 선택한 숫자 제외
    int getRandomNumber(){
        int range = numbers.size();
        int index = random.nextInt(range);
        return numbers.remove(index);
    }

    // 사용자로부터 숫자 입력받기
    int[] getInputs(){
        return null;
    }

    // 입력받은 숫자와 임의의 수 비교
    boolean compareNumbers(int[] inputs){
        return false;
    }

    // 각 자리수별로 스트라이크, 볼 확인
    String compareDigit(int index, int number) {
        return null;
    }

    // 숫자가 맞았을 경우 게임 종료 혹은 새로 시작
    void endgame() {

    }

    // 메인 게임 시퀀스
    public void mainGame(){
        do {
            initGame();
            endgame();
        }
        while(this.restart);
    }

    public static void main(String[] args) {
        BaseBallGame baseBallGame = new BaseBallGame();

    }

}
