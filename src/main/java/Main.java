import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        NumberGenerator numberGenerator = new NumberGenerator(3);
        System.out.println(Arrays.toString(numberGenerator.getRandomNumbers()));

    }

}
