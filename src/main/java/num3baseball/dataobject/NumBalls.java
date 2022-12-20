package num3baseball.dataobject;

public interface NumBalls {
    public int getNum(int index);
    public int getSize();

    public TrialResult compare(NumBalls trial);
}
