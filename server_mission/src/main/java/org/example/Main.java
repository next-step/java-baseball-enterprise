package org.example;

public class Main {
    public static void main(String[] args) {

        while(true){

            Opponent OP = new Opponent();
            OP.generate_random_int();
            System.out.println(OP.getRandom_Int());

            IOsys IO;
            IO = new IOsys();
            int userinput = IO.userIn();

            Checker chk = new Checker(OP);
            chk.compare(userinput, OP.getRandom_Int());
            IO.print_result(chk);

            //int[] info_arr = {0,0,0};// strike, ball,

        }
    }
}