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
        for (int i = 0; i < DIGIT_SIZE; i++) {
            chosen.add(getRandomNumber());
        }
    }

    // 임의의 수 하나 선택. 단, 이전에 선택한 숫자 제외
    int getRandomNumber(){
        int range = numbers.size();
        int index = random.nextInt(range);
        return numbers.remove(index);
    }

    void mainSequence(){
        boolean onSeq = true;
        while(onSeq){
            int[] inputs = getInputs();
            onSeq = !compareNumbers(inputs);
        }
    }

    // 사용자로부터 숫자 입력받기
    int[] getInputs(){
        int[] inputs = new int[DIGIT_SIZE];
        System.out.print("숫자를 입력해주세요 : ");
        String line = new Scanner(System.in).nextLine();
        for (int i = 0; i < DIGIT_SIZE; i++) {
            inputs[i] = line.charAt(i)-'0';
        }
        return inputs;
    }

    // 입력받은 숫자와 임의의 수 비교
    boolean compareNumbers(int[] inputs){
        int[] results = {0, 0};
        for (int i = 0; i < DIGIT_SIZE; i++) {
            int[] compareResult = compareDigit(i, inputs[i]);
            results[0] += compareResult[0];
            results[1] += compareResult[1];
        }
        printResults(results);
        if (results[0] == DIGIT_SIZE)
            return true;
        return false;
    }

    // 각 자리수별로 스트라이크, 볼 확인
    int[] compareDigit(int index, int number) {
        if (chosen.get(index) == number)
            return new int[]{1, 0};
        if (chosen.contains(number))
            return new int[]{0, 1};
        return new int[]{0, 0};
    }

    void printResults(int[] results){
        String output = "";
        if (results[0]>0)
            output += (results[0] + "스트라이크 ");
        if (results[1]>0)
            output += (results[1] + "볼 ");
        if (output.length() == 0)
            output += "낫싱";
        System.out.println(output);
    }

    // 숫자가 맞았을 경우 게임 종료 혹은 새로 시작
    void endgame() {
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = new Scanner(System.in).nextLine();
        int inputNum = Integer.parseInt(input);
        if(inputNum == 1){
            restart = true;
        }
    }

    // 메인 게임 시퀀스
    public void mainGame(){
        do {
            initGame();
            setNumbers();
            mainSequence();
            endgame();
        }
        while(this.restart);
        System.out.println("게임을 종료합니다.");
    }

    public static void main(String[] args) {
        BaseBallGame baseBallGame = new BaseBallGame();
        baseBallGame.mainGame();
    }

}
