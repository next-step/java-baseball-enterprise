package NumberBaseball.Functions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Number_Matching {
    private Integer letter;
    private Integer strike_cnt;
    private Integer all_cnt;
    private Integer ball_cnt;
    private String user_number;
    private String computer_number;

    public void matching_init(){
        this.strike_cnt = 0;
        this.ball_cnt = 0;
        this.all_cnt = 0;
    }

    public Number_Matching(Integer letter){
        this.letter = letter;
        matching_init();
    }

    public int IsInclude(int idx){
        if (this.computer_number.indexOf(this.user_number.charAt(idx)) != -1) return 1;
        return 0;
    }

    public int IsStrike(int idx){
        if (this.computer_number.charAt(idx) == this.user_number.charAt(idx)) return 1;
        return 0;
    }

    public List<Integer> matching_two_numbers(String computer_nubmer, String user_number){
        this.computer_number = computer_nubmer;
        this.user_number = user_number;

        for (int i=0; i < this.letter; i++) this.all_cnt += IsInclude(i);
        for (int i=0; i< this.letter; i++) this.strike_cnt += IsStrike(i);

        this.ball_cnt = this.all_cnt - this.strike_cnt;
        System.out.println("Strike: " + this.strike_cnt + ", Ball: " + ball_cnt);

        return new ArrayList<>(Arrays.asList(this.ball_cnt, this.strike_cnt));
    }

    public boolean chk_strike(String computer_number, String user_number) {
        matching_init();
        matching_two_numbers(computer_number, user_number);
        return this.strike_cnt.equals(this.letter);
    }
}