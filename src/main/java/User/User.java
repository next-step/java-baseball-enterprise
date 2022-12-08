package User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class User {
    private List<Integer> numbers = new ArrayList<>();
    /**
     * Sets User numbers
     * */
    public void setNumbers(int number){
        fillNumber(number);
    }
    /**
     * Get input number from user
     * @Return int user made
     * */
    public int getInput(){
        System.out.print("숫자를 입력하세요: ");
        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt();

        return number;
    }
    private void fillNumber(int number){
        numbers.clear();

        while(number!=0){
            numbers.add(number%10);
            number/=10;
        }
        while(numbers.size()<3){
            numbers.add(0);
        }
        Collections.reverse(numbers);
    }
    /**
     * Returns user Numbers
     * */
    public List<Integer> getNumbers(){
        return numbers;
    }
}
