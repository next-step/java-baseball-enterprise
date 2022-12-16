package num3baseball.dataobject;

import num3baseball.exception.WrongNumberException;

public class Num3Balls {
    private final int num1;
    private final int num2;
    private final int num3;
    private boolean isValidNumber(int num1, int num2, int num3){
        if (num1<1 || num1>9 || num2<1 || num2>9 || num3<1 || num3>9){
            return false;
        }
        if (num1==num2 || num2==num3 || num3==num1){
            return false;
        }
        return true;
    }
    public Num3Balls(){ // random한 number 주입
        int[] tnum={0,0,0};
        do{
            tnum[0]=(int)(Math.floor(Math.random()*9+1));
            tnum[1]=(int)(Math.floor(Math.random()*9+1));
            tnum[2]=(int)(Math.floor(Math.random()*9+1));
        }while(!isValidNumber(tnum[0], tnum[1], tnum[2]));
        num1=tnum[0];
        num2=tnum[1];
        num3=tnum[2];
    }

    public Num3Balls(int num1, int num2, int num3){
        if (!isValidNumber(num1, num2, num3)){
            throw new WrongNumberException();
        }
        this.num1 = num1;
        this.num2 = num2;
        this.num3 = num3;
    }

    public int getNum1() {
        return num1;
    }

    public int getNum2() {
        return num2;
    }

    public int getNum3() {
        return num3;
    }
}
