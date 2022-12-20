package domain;

import java.util.ArrayList;


public class User {

    private final ArrayList<Integer> numbers;

    public ArrayList<Integer> getNumbers() {
        return numbers;
    }


    public User() {
        this.numbers = new ArrayList<>();
    }

    public void reset(){
        this.numbers.clear();
    }

    public void userNumAdd(int num){
        if(!this.numbers.contains(num))
        {
            this.numbers.add(num);
        }
    }

    public void userNumConvert(String userInput){

        for (int i = 0; i < userInput.length() ; i++) {
            this.userNumAdd(userInput.charAt(i) - '0');
        }

        if (this.getNumbers().size() != 3) {
            this.reset();
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }

    }

    public void setNumbers(String num){

        if (num.length() != 3 || !isNumeric(num)){
            this.reset();
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }

        this.userNumConvert(num);
    }

    public static boolean isNumeric(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        }
        return !s.contains("0");
    }
}
