import java.util.Random;

public class AnswerEntity {
    private int[] answer;
    private boolean[] check;
    AnswerEntity(){
        this.answer = init();
    }
    public int[] init(){
        int[] ret = new int[3];
        Random random = new Random();
        check = new boolean[10];

        for(int idx = 0; idx < 3; idx++){
            int num = random.nextInt(9) + 1;
            if(checkDuplicationAndInsert(ret, num, idx)) idx--;
        }

        return ret;
    }
    private boolean checkDuplicationAndInsert(int[] arr, int num, int idx){
        if(!check[num]){
            arr[idx] = num;
            check[num] = true;
            return false;
        }
        return true;
    }

    public int[] getAnswer(){
        return this.answer;
    }

}
