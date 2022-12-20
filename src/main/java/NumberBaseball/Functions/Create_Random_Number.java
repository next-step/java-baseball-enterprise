package NumberBaseball.Functions;

import java.util.Random;

public class Create_Random_Number {
    Integer letter;
    public Create_Random_Number(int letter) {
        this.letter = letter;
    }

    public String set_random_number() {
        Random random = new Random();
        String res = "";
        for (int i=0; i< this.letter; i++) res += random.nextInt(9)+1;
        return res;
    }
}