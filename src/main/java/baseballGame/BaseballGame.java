package baseballGame;
import java.util.Scanner;
public class BaseballGame {
    protected int[] answer; //컴퓨터가 정한 답
    protected int[] userAnswer; //유저가 입력한 답
    protected int strike;
    protected int ball;
    protected boolean finish;
    BaseballGame() {
        answer = new int[3];
        userAnswer = new int[3];
    }
    void startGame() {
        runGame();
        Scanner sc = new Scanner(System.in);
        int response = sc.nextInt();
        if (response == 2) return;
        startGame();
    }
    protected void runGame() {
        finish = false;
        setGame();
        while (!finish) {
            setUserAnswer();
            evaluate();
            printOutputMessage();
        }
        printFinishMessage();
    }
    protected int[] setGame() { //정답 세팅
        answer[0] = (int)(Math.random() * 9) + 1;
        answer[1] = (int)(Math.random() * 9) + 1;
        answer[2] = (int)(Math.random() * 9) + 1;

        while(answer[1] == answer[0]) {
            answer[1] = (int)(Math.random() * 9) + 1;
        }
        while(answer[2] == answer[0] || answer[2] == answer[1]) {
            answer[2] = (int)(Math.random() * 9) + 1;
        }
        return answer;
    }
    protected String receiveUserInput() {
        String buffer;
        Scanner sc = new Scanner(System.in);
        buffer = sc.nextLine();
        return buffer;
    }
    protected void setUserAnswer() { //유저의 입력을 받음
        System.out.print("숫자를 입력해주세요 : ");
        String buffer = receiveUserInput();
        for (int i = 0; i < 3; i++) {
            userAnswer[i] = buffer.charAt(i) - '0';
        }
    }
    protected int isStrike(int idx) { // idx번째가 스트라이크인지 판단한다
        if(answer[idx] == userAnswer[idx]) return 1;
        return 0;
    }
    protected int isBall(int idx) { //idx번째가 볼인지 판단한다
        if(answer[idx] == userAnswer[idx]) return 0;
        if(answer[0] == userAnswer[idx] || answer[1] == userAnswer[idx] || answer[2] == userAnswer[idx]) return 1;
        return 0;
    }
    protected void evaluate() { //유저 입력 결과 계산
        strike = 0;
        ball = 0;
        for(int i = 0; i < 3; i++) {
            strike += isStrike(i);
            ball += isBall(i);
        }
        if(strike == 3) finish = true;
    }
    protected void printOutputMessage() { //결과 출력
        if(strike == 0 && ball == 0) {
            System.out.print("낫싱");
        }
        if(strike > 0) {
            System.out.print(strike + " 스트라이크 ");
        }
        if(ball > 0) {
            System.out.print(ball + "볼");
        }
        System.out.println();
    }
    protected void printFinishMessage() { //종료메시지 출력
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}