package Game;

import java.util.Arrays;
import java.util.List;

public class Game {
    private boolean end;
    /**
     * Checks available Numbers
     * */
    public boolean checkValidity(List<Integer> numbers){
        if(numbers.size() != 3) return false;

        boolean[] used=new boolean[10];
        Arrays.fill(used, false);

        boolean ret=true;
        for(Integer i : numbers){
            ret = ret & !(i.equals(0) | used[i]);
            used[i]=true;
        }

        return ret;
    }
}
