package Service;

import Repository.GameRepository;

import java.util.ArrayList;
import java.util.Scanner;

import static util.Message.*;

public class GameService {

    public GameRepository gameRepository;
    public ErrorService errorService;

    public GameService() {
        this.gameRepository = new GameRepository();
        this.errorService = new ErrorService(this.gameRepository); // DI
    }

    public void playGame(){
        boolean endFlag = false;
        printStartGameMessage();                        // 게임 시작 메시지 출력
        while(!endFlag) {
            getInputNumbers();                          // 유저 입력
            boolean correctFlag = compareWithAnswer();  // 유저 입력 결과 출력
            endFlag = endAndRestartGame(correctFlag);
        }
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
        String userNumbers = "";
        boolean reInput = false;

        while(!reInput){
            printInputMessage();                        // 입력 메시지 출력
            userNumbers = input.nextLine();
            gameRepository.setUserNumber(userNumbers); // 데이터는 Repository 단에서 관리해야 한다.
            reInput = checkUserInputNumbers();
        }
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
        if(ball > 0) System.out.print(ball + "볼 ");
        if(strike > 0) System.out.print(strike + "스트라이크");
        if(nothing == 3) System.out.print("낫싱");

        System.out.println();

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
            ret = (ret * 10) + i;
        }
        return Integer.toString(ret);
    }

    public boolean compareWithAnswer(){
        ArrayList<Integer> numbersArr = gameRepository.getNumbers();
        String numbers = changeArrayToString(numbersArr);
        String userNumber = gameRepository.getUserNumber();

        return compareLogic(numbers, userNumber);
    }

    public boolean isRestart(String restartCount){
        if(restartCount.equals("1")) return false;  // 게임 다시 시작
        System.out.println(END_GAME.getMessage());  // 게임 종료
        return true;
    }
    public boolean inputRestartCount(){ // 게임을 재시작 할지 말지 입력받기
        Scanner input = new Scanner(System.in);

        boolean reInputFlag = false;
        String restartCount = "";

        while(!reInputFlag){
            restartCount = input.nextLine(); // String 으로 받아야 한다. 유저가 어떠한 입력을 줄 지 모르기 때문이다.
            reInputFlag = errorService.checkRestartCount(restartCount);
        }

        return isRestart(restartCount);
    }

    public boolean endAndRestartGame(boolean correctFlag){
        if(!correctFlag) return false;
        // 게임을 다시 할지 끝낼지 선택하기
        System.out.println(CORRECT_ANSWER.getMessage());
        System.out.println(RESTART_GAME.getMessage());

        return inputRestartCount();
    }
}

