package domain;

import java.util.ArrayList;


public class User {

    private final ArrayList<Integer> number;

    public ArrayList<Integer> getNumber() {
        return number;
    }


    public User() {
        this.number = new ArrayList<>();
    }

    public void reset(){
        this.number.clear();
    }

    public void userNumAdd(int num){
        if(!this.number.contains(num))
        {
            this.number.add(num);
        }
    }

    public void userNumConvert(String userInput){

        for (int i = 0; i < userInput.length() ; i++) {
            this.userNumAdd(userInput.charAt(i) - '0');
        }

        if (this.getNumber().size() != 3) {
            this.reset();
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }

    }

    public void setNumber(String num){

        if (num.length() != 3 || !isNumeric(num)){
            this.reset();
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }

        this.userNumConvert(num);
    }

    public static boolean isNumeric(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
