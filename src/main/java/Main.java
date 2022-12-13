
public class Main {

    public static void main(String[] args) {

        NumberGenerator numberGenerator = new NumberGenerator(3);
        Judge judge = new Judge(numberGenerator.getRandomNumbers());

    }

}
