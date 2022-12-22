import java.util.Random;

public class Opponent {
    private int Random_Int;
    private boolean int_dict[];// if 1 exists, int_dict[1] = true

    public Opponent(){
        Random_Int = 0;
        int_dict = new boolean[]{false,false,false,false,false,false,false,false,false,false};
    }
    public void generate_random_int(){
        Random random = new Random();

        int cur = random.nextInt(10);

        while(cur == 0) cur = random.nextInt(10);
        Random_Int += cur*100;
        cur = check_pre(0, cur, random);
        Random_Int += cur*10;
        Random_Int += check_pre(Random_Int/100, cur, random);
        init_int_dict();
    }
    public void init_int_dict(){
        int_dict[Random_Int/100] = true;
        int_dict[Random_Int%100/10] = true;
        int_dict[Random_Int%10] = true;
    }
    public int getRandom_Int() {return this.Random_Int;}
    public void setRandom_Int(int a) {this.Random_Int = a;}
    public int check_pre(int pprevious, int previous, Random r){
        int temp = previous;
        while(temp == previous || temp == pprevious) temp = r.nextInt(10);
        return temp;
    }
    public boolean[] getintdict(){return this.int_dict;}
}