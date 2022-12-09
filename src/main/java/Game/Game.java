package Game;

import Computer.Computer;
import User.User;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Game {
    private Computer computer = new Computer();
    private User user = new User();
    /**
     * Checks available Numbers
     * */
    public boolean checkValidity(List<Integer> numbers){
        boolean[] used=new boolean[10];
        Arrays.fill(used, false);

        boolean ret = numbers.size()==3;
        for(Integer i : numbers){
            ret = ret & !(i.equals(0) | used[i]);
            used[i]=true;
        }

        if(!ret) System.out.println("0을 포함하지 않고, 중복되지 않는 숫자로 입력하세요");
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
    private void play(){
        boolean end = false;

        computer.setNumber();
        while(!end){
            init();

            end = getGameResult(computer.getBallStrike(user.getNumbers()));
        }
    }
    private void init(){
        do{
            user.setNumbers(user.getInput());
        } while(!checkValidity(user.getNumbers()));
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
