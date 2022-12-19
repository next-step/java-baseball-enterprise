package num3baseball.ui;

import num3baseball.dataobject.TrialResult;
import num3baseball.exception.WrongNumberException;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class GameUserInterfaceKorean implements GameUserInterface{
    private final Scanner sc = new Scanner(System.in);

    private int inputNum(String promptStr){
        try {
            System.out.print(promptStr);
           return Integer.parseInt(sc.next());
        } catch (Exception e) {
            printError(e);
            return -1;
        }
    }
    @Override
    public ArrayList<Integer> inputNumbers() {
        ArrayList<Integer> res = new ArrayList<>();
        int getNum=0;
        do {
            getNum = inputNum("숫자를 입력해주세요 : ");
        }while(getNum>0);
        while(getNum>0){
            res.add(0,getNum%10);
            getNum/=10;
        }
        return res;
    }
    @Override
    public void printResult(TrialResult res) {
        if (res.getStrike() > 0){
            System.out.print(res.getStrike()+" 스트라이크 ");
        }
        if (res.getBall() > 0){
            System.out.print(res.getBall()+" 볼");
        }
        if (res.getStrike() == 0 && res.getBall() == 0){
            System.out.print("낫싱");
        }
        System.out.println();
    }

    @Override
    public void printError(Exception e) {
        if (e instanceof WrongNumberException){
            System.out.println("올바른 숫자를 입력해주시기 바랍니다.");
            return;
        }
        if (e instanceof NumberFormatException){
            System.out.println("숫자를 입력해주시기 바랍니다.");
            return;
        }
        System.out.println("알 수 없는 오류가 발생하였습니다");
    }

    @Override
    public void printGameClear(int size) {
        System.out.println(size+"개의 숫자를 모두 맞히셨습니다. 게임 종료");
    }

    @Override
    public boolean printRetry() {
        int code;
        do{
            code = inputNum("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
        }while(code!=1 && code!=2);
        return code==1;
    }
}
