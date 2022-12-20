package NumberBaseball.Functions;

import java.util.Scanner;

public class Create_User_Number {
    public String Create_User_Number() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("숫자를 입력해주세요");
        String user_number = scanner.nextLine();
        while (!user_number.matches("^[1-9]{3}")){
            System.out.println("입력값을 1에서 9 사이의 숫자 3자리로 입력해주세요");
            user_number = scanner.nextLine();
        }
        return user_number;
    }
}