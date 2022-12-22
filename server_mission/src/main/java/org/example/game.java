package org.example;

import com.sun.source.tree.ContinueTree;

public class game {
    private IOsys IO;
    private int Continue_Flag;
    private int strike_num;
    public game(){
        Continue_Flag = 1;
        strike_num = 0;
        IO = new IOsys();
    }
    public void game_start(){
        while(Continue_Flag == 1){
            Opponent OP = new Opponent();
            OP.generate_random_int();

            strike_num = 0;

            play_one_game(OP);

            Continue_Flag = IO.nextgame();
        }
    }
    public void play_one_game(Opponent OP){
        while(strike_num != 3) {
            int userinput = IO.userIn();

            Checker chk = new Checker(OP);
            chk.compare(userinput, OP.getRandom_Int());
            IO.print_result(chk);

            strike_num = chk.getStrike();
        }
    }
}
