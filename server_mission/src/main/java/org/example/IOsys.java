package org.example;
import java.util.Scanner;

public class IOsys {

    public int userIn(){
        Scanner sc = new Scanner(System.in);

        System.out.print("숫자를 입력해주세요: ");
        int userinput = sc.nextInt();

        return userinput;
    }
    public void print_result(Checker C){
        if(C.getStrike()!= 0) System.out.printf("%d스트라이크 ", C.getStrike());
        if(C.getBall() != 0) System.out.printf("%d볼 ", C.getBall());
        if(C.getBall() + C.getStrike() == 0) System.out.printf("낫싱");
    }
}
