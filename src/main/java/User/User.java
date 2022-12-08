package User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User {
    private List<Integer> numbers = new ArrayList<>();
    /**
     * Sets User numbers
     * */
    public void setNumbers(){
        System.out.print("숫자를 입력하세요: ");
        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt();
        fillNumber(number);
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
    }
    /**
     * Returns user Numbers
     * */
    public List<Integer> getNumbers(){
        return numbers;
    }
}
