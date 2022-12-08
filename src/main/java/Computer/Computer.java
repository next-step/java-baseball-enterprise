package Computer;

public class Computer {
    private int[] targetNumbers = new int[]{-1,-1,-1};
    private final int[] nums = new int[]{1,2,3,4,5,6,7,8,9};
    private boolean[] used = new boolean[]{false, false, false, false, false, false, false, false, false};

    /**
     * Sets Computer number
     * @return count of used numbers
     * */
    public int setNumber(){
        for(int i=0; i<9; i++)
            used[i]=false;

        int n=0;

        while(n<3) {
          targetNumbers[n] = getUnusedNumber();
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
}
