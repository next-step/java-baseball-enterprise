package Game;

import Computer.Computer;
import User.User;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Game {
    Computer computer = new Computer();
    User user = new User();
    /**
     * Checks available Numbers
     * */
    public boolean checkValidity(List<Integer> numbers){
        if(numbers.size() != 3) return false;

        boolean[] used=new boolean[10];
        Arrays.fill(used, false);

        boolean ret=true;
        for(Integer i : numbers){
            ret = ret & !(i.equals(0) | used[i]);
            used[i]=true;
        }

        return ret;
    }
    /**
     * Plays game
     *  */
    public void startGame(){
        boolean keepPlaying = true;
        Scanner scanner = new Scanner(System.in);

        while(keepPlaying){
            play();

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
            keepPlaying = scanner.nextInt()==1 ? true : false;
        }
    }

    private void init(){
        user.getNumbers().clear();
        while(!checkValidity(user.getNumbers())){
            user.setNumbers(user.getInput());
        }
    }
    private void play(){
        boolean end = false;

        computer.setNumber();
        while(!end){
            init();

            end = getGameResult(computer.getBallStrike(user.getNumbers()));
        }
    }
    private boolean getGameResult(int[] result){
        if(result[0]==0 && result[1]==0){
            System.out.println("포볼");
            return false;
        }
        if(result[1]==3) {
            System.out.println("3 스트라이크");
            return true;
        }

        System.out.println(result[1]+" 스트라이크, "+result[0]+" 볼");
        return false;
    }
}
