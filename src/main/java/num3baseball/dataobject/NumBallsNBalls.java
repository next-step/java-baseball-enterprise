package num3baseball.dataobject;

import num3baseball.exception.WrongNumberException;
import num3baseball.exception.WrongTypeException;

import java.util.*;

public class NumBallsNBalls implements NumBalls{

    private final ArrayList<Integer> nums = new ArrayList<>();
    private final int size;

    private int randomlyChoose(Set<Integer> numSet){
        Iterator iter = numSet.iterator();
        int randomChoose = (int)(numSet.size() * Math.random());
        for (int i=1;i<=randomChoose;i++){
            iter.next();
        }
        return (int)iter.next();
    }

    private void isValidNumber(ArrayList<Integer> num) throws WrongNumberException{
        Set<Integer> numSet = new HashSet<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9));
        int initialSize = numSet.size();
        for (int i:num){
            numSet.remove(i);
        }
        int endSize = numSet.size();
        if (initialSize - endSize != num.size()){ // 모든 번호가 한번씩 빠짐 = 중복되지 않고
            throw new WrongNumberException();
        }
    }

    public NumBallsNBalls(int size) throws WrongNumberException{
        this.size=size;
        if (size>9 || size<1){
            throw new WrongNumberException();
        }
        Set<Integer> numSet = new HashSet<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9));
        for (int i=1;i<=this.size;i++){
            nums.add(randomlyChoose(numSet));
            numSet.remove(nums.get(i-1));
        }
        isValidNumber(nums);
    }

    public NumBallsNBalls(ArrayList<Integer> nums) throws WrongNumberException{
        this.size = nums.size();
        isValidNumber(nums);
        this.nums.addAll(nums);
    }
    @Override
    public int getNum(int index) {
        return nums.get(index);
    }

    @Override
    public int getSize() {
        return size;
    }

    private void compareOne(int thisIndex, int trialIndex, TrialResult result){
        if (trialIndex==-1){
            return;
        }
        if (thisIndex == trialIndex){
            result.setStrikeBall(result.getStrike()+1, result.getBall());
        }
        if (thisIndex != trialIndex){
            result.setStrikeBall(result.getStrike(), result.getBall()+1);
        }
    }
    @Override
    public TrialResult compare(NumBalls trial) {
        if (!(trial instanceof NumBallsNBalls) || trial.getSize()!=size){
            throw new WrongTypeException();
        }
        TrialResult result = new TrialResult(size);
        for (int i=0;i<size;i++){
            compareOne(i, nums.indexOf(trial.getNum(i)), result);
        }
        return result;
    }
}
