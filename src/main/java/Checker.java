public class Checker {
    private int strike_arr[];
    private int strike;
    private boolean isex[];
    private int ball;
    private Opponent OP;

    public Checker(Opponent OP_in){
        strike_arr = new int[]{0,0,0};
        isex = new boolean[]{false,false,false,false,false,false,false,false,false,false};
        strike = 0;
        ball = 0;
        OP = OP_in;
    }
    public void compare(int user_input, int opp_number){
        check_strike(user_input, opp_number);
        check_ball(user_input);
    }
    public void check_strike(int user_input, int opp_number){
        if(get100number(user_input) == get100number(opp_number)) strike_arr[0] = 1;
        if(get10number(user_input) == get10number(opp_number)) strike_arr[1] = 1;
        if(get1number(user_input) == get1number(opp_number)) strike_arr[2] = 1;
        strike = strike_arr[0] + strike_arr[1] + strike_arr[2];
    }
    public void check_ball(int user_input){
        if(strike_arr[0]==0 && OP.getintdict()[get100number(user_input)]) ball++;
        if(strike_arr[1]==0 && OP.getintdict()[get10number(user_input)]) ball++;
        if(strike_arr[2]==0 && OP.getintdict()[get1number(user_input)]) ball++;
    }
    public int get100number(int a){
        return a / 100;
    }
    public int get10number(int a){
        return a % 100 / 10;
    }
    public int get1number(int a){
        return a % 10;
    }
    public int getStrike(){return strike;}
    public int getBall(){return ball;}
}
