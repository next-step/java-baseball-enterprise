import java.io.IOException;

public class Game {

    public int[] stringToIntArray(String input) {
        return new int[] {
                Character.getNumericValue(input.charAt(0)),
                Character.getNumericValue(input.charAt(1)),
                Character.getNumericValue(input.charAt(2))
        };
    }

    public void play(UI ui, Computer computer) throws IOException {
        computer.selectNumbers();

        boolean correct = false;
        while (!correct) {
            int[] numbers = stringToIntArray(ui.input());

            int[] result = computer.calculate(numbers);
            ui.output(result);
            correct = result[0] == 3;
        }
    }

    public static void main(String[] args) throws IOException {
        Computer computer = new Computer();
        UI ui = new UI();
        Game game = new Game();
        game.play(ui, computer);
    }
}
