package org.example;
import java.util.Random;

public class Opponent {
    private int Random_Int;

    public Opponent(){
        Random random = new Random();

        int cur = random.nextInt(10);

        while(cur == 0) cur = random.nextInt(10);
        Random_Int += cur*100;
        cur = check_pre(cur, random);
        Random_Int += cur*10;
        Random_Int += check_pre(cur, random);
    }
    public int getRandom_Int() {return this.Random_Int;}
    public void setRandom_Int(int a) {this.Random_Int = a;}
    public int check_pre(int previous, Random r){
        int temp = previous;
        while(temp == previous) temp = r.nextInt(10);
        return temp;
    }
}