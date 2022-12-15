package numberbaseball;

public interface Base {

    int[] getNumbers();

    boolean isStrike(int index, int number);

    boolean isBall(int index, int number);
}
