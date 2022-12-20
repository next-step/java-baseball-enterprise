package org.example;
import java.util.Scanner;

public class IOsys {

    public String userIn(){
        Scanner sc = new Scanner(System.in);

        System.out.print("숫자를 입력해주세요: ");
        String userinput = sc.next();

        return userinput;
    }
}
