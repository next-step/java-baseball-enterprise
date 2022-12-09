package User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User {
    private List<Integer> numbers = new ArrayList<>();
    /**
     * Sets User numbers
     * */
    public void setNumbers(String number){
        numbers.clear();
        char[] numbersChar = number.toCharArray();

        for(char c : numbersChar){
            numbers.add(c-'0');
        }
    }
    /**
     * Get input number from user
     * @Return int user made
     * */
    public String getInput(){
        System.out.print("숫자를 입력하세요: ");
        Scanner scanner = new Scanner(System.in);

        String number = scanner.nextLine();

        return number;
    }
    /**
     * Returns user Numbers
     * */
    public List<Integer> getNumbers(){
        return numbers;
    }
}
