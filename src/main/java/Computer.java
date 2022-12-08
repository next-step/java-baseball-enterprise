import java.util.Random;

public class Computer {
    private int[] numbers = {-1,-1,-1};

    public boolean contains(int newNumber) {
        boolean flag = false;
        for (int number : numbers) {
            flag = (number == newNumber) || flag;
        }
        return flag;
    }

    public int getUniqueNumber() {
        int number = new Random().nextInt(9)+1;
        while (contains(number)) {
            number = new Random().nextInt(9)+1;
        }
        return number;
    }

    public void selectNumbers() {
        for (int i = 0; i<3; i++) {
            numbers[i] = getUniqueNumber();
        }
    }
}
