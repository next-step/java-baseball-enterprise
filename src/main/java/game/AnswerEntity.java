package game;

import java.util.Random;

public class AnswerEntity {
    private int[] answer;
    private boolean[] check;
    AnswerEntity(){
        this.answer = new int[3];
    }
    public void init(){
        Random random = new Random();
        check = new boolean[10];

        for(int idx = 0; idx < 3; idx++){
            int num = random.nextInt(9) + 1;
            if(checkDuplicationAndInsert(num, idx)) idx--;
        }
    }
    private boolean checkDuplicationAndInsert(int num, int idx){
        if(!check[num]){
            answer[idx] = num;
            check[num] = true;
            return false;
        }
        return true;
    }

    public int[] getAnswer(){
        return this.answer;
    }

    public void setAnswer(int n1, int n2, int n3){
        this.answer[0] = n1;
        this.answer[1] = n2;
        this.answer[2] = n3;
    }

}
