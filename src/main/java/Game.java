import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Set;

public class Game {
    private final Computer computer;
    private final Human human;
    private int strike;
    private int ball;

    public Game() {
        this.computer = new Computer();
        this.human = new Human();
    }

    public void start() throws IOException {
        HashMap<Character, Integer> answer = computer.getAnswerPosition();
        HashMap<Character, Integer> input = human.input();

        while(!count(answer, input)){
            input = human.input();
        }
    }

    public boolean count(HashMap<Character, Integer> answer, HashMap<Character, Integer> input) {
        strike = 0;
        ball = 0;
        Set<Character> keys = input.keySet();
        for (Character key : keys) {
            countStrikeBall(answer, key, input.get(key));
        }

        return printCount(strike, ball);
    }

    public void countStrikeBall(HashMap<Character, Integer> answer, Character key, int position) {
        if(answer.containsKey(key) && answer.get(key)==position){
            strike++;
        }else if(answer.containsKey(key)){
            ball++;
        }
    }

    public boolean printCount(int strike, int ball) {
        if(strike==3) {
            System.out.println("3 스트라이크");
            return true;
        }else if(strike==0 && ball==0){
            System.out.println("낫싱");
            return false;
        }

        System.out.println(strike + " 스트라이크 " + ball + "볼");
        return false;
    }

    public boolean replay() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("3개의  숫자를  모두  맞히셨습니다!  게임  종료");
        System.out.println("게임을  새로  시작하려면 1, 종료하려면  2를  입력하세요");

        int in = Integer.parseInt(br.readLine());

        return in == 1;
    }
}

