package Repository;

import java.util.ArrayList;
import java.util.Random;

public class GameRepository {
    public ArrayList<Integer> numbers; // 3자리 랜덤 수를 담은 배열
    public Random random;
    public boolean check[];

    public GameRepository() {
        this.numbers = new ArrayList<>();
        this.random = new Random();
        this.check = new boolean[10];
        initCheckArr(); // check 배열 false로 초기화
        random.setSeed(System.currentTimeMillis()); // seed 설정
        makeRandomNumberArray(); // Repository Instance 생성 시 Random Number 만들어서 배열에 저장해놓기
    }

    public void initCheckArr(){
        for(int i=1; i<=9; i++){
            check[i] = false;
        }
    }

    public int makeRandomNumber(){
        return random.nextInt(9) + 1; // 1 ~ 9 랜덤 숫자 생성
    }

    public int makeRandomNumberCheckDuplicate(){
        int num = makeRandomNumber();
        if(check[num]) {
            return -1;
        }

        // 중복제거가 된 정상적인 숫자라면, numbers에 넣기
        numbers.add(num);
        check[num] = true;
        return 0;
    }

    public void makeRandomNumberArray(){
        // 3자리 Random Number를 만들어야한다.
        for(int i=0; i<3; i++){
            i += makeRandomNumberCheckDuplicate(); // 만약 중복으로 숫자가 계산되었다면, 반복문을 다시 실행한다.
        }
    }

    public ArrayList getNumbers(){
        return numbers;
    }
}
