package Service;

import Repository.GameRepository;

import java.util.ArrayList;
import java.util.Scanner;

import static util.Message.START_GAME;
import static util.Message.USER_INPUT;

public class GameService {

    public GameRepository gameRepository;
    public ErrorService errorService;

    public GameService() {
        this.gameRepository = new GameRepository();
        this.errorService = new ErrorService(this.gameRepository); // DI
    }

    public void playGame(){
        printStartGameMessage();    // 게임 시작 메시지 출력
        printInputMessage();        // 입력 메시지 출력
        getInputNumbers();          // 유저 입력
        checkUserInputNumbers();    // 유저 입력 검증
    }

    public void printStartGameMessage(){
        System.out.println(START_GAME.getMessage());
    }

    public ArrayList<Integer> getNumbers(){
        return gameRepository.getNumbers();
    }

    public void printInputMessage(){
        System.out.print(USER_INPUT.getMessage());
    }

    public void getInputNumbers(){
        Scanner input = new Scanner(System.in);
        String userNumbers = input.nextLine();
        gameRepository.setUserNumber(userNumbers); // 데이터는 Repository 단에서 관리해야 한다.
    }

    public boolean checkUserInputNumbers(){
        return errorService.checkUserInputNumber();
    }

    public int isStrike(char num, char cmp){
        return num == cmp ? 1 : 0;
    }

    public int isBall(String num, char cmp){
        return num.contains(Character.toString(cmp)) == true ? 1 : 0;
    }

    public boolean printResult(int strike, int ball, int nothing){
        if(ball > 0) System.out.println(ball + "볼 ");
        if(strike > 0) System.out.println(strike + "스트라이크");
        if(nothing == 3) System.out.println("낫싱");

        return strike == 3 ? true : false; // 게임이 끝났으면 true, 아니면 false
    }

    public boolean compareLogic(String numbers, String userNumber){
        int ballCnt = 0, strikeCnt = 0, nothingCnt = 0;
        for(int i=0; i<3; i++) {
            char num = numbers.charAt(i);
            char cmp = userNumber.charAt(i);
            strikeCnt += isStrike(num, cmp);
            ballCnt += isBall(numbers, cmp);
        }
        ballCnt -= strikeCnt; // ball에는 Strike도 측정되기 때문에
        nothingCnt = 3 - (ballCnt + strikeCnt);
        return printResult(strikeCnt, ballCnt, nothingCnt);
    }

    public String changeArrayToString(ArrayList<Integer> arr){
        int ret = 0;
        for(int i : arr) {
            ret += (ret * 10) + i;
        }
        return Integer.toString(ret);
    }

    public void compareWithAnswer(){
        ArrayList<Integer> numbersArr = gameRepository.getNumbers();
        String numbers = changeArrayToString(numbersArr);
        String userNumber = gameRepository.getUserNumber();

        boolean endFlag = compareLogic(numbers, userNumber);
    }
}

