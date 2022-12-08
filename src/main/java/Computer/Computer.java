package Computer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Computer {
    private List<Integer> targetNumbers= new ArrayList<Integer>();
    private final int[] nums = new int[]{1,2,3,4,5,6,7,8,9};
    private boolean[] used = new boolean[]{false, false, false, false, false, false, false, false, false};

    /**
     * Sets Computer number
     * @return count of used numbers
     * */
    public int setNumber(){
        Arrays.fill(used, false);

        int n=0;
        targetNumbers.clear();
        while(n<3) {
          targetNumbers.add(getUnusedNumber());
          n++;
        }

        return getCountOfUsedNumbers();
    }
    private int getUnusedNumber(){
      int randomIndex =(int)(Math.random()*8);
      while(used[randomIndex]){
          randomIndex = (int)(Math.random()*8);
      }

      used[randomIndex] = true;

      return nums[randomIndex];
    }

    private int getCountOfUsedNumbers(){
        int ret=0;

        for(boolean usage : used)
            ret += usage ? 1 : 0;

        return ret;
    }

    /**
     * Return Array with [ball, strike]
     * */
    public int[] getResult(List<Integer> numbers){
        int[] result = new int[]{0,0};

        for(int i=0; i<3; i++){
            result[0] += used[numbers.get(i)-1] ? 1 : 0;
            result[1] += numbers.get(i).equals(targetNumbers.get(i)) ? 1 : 0;
        }
        result[0] -= result[1];

        return result;
    }

    /**
     * Return targetNumbers
     * */
    public List<Integer> getTargetNumbers(){
        return targetNumbers;
    }
}
