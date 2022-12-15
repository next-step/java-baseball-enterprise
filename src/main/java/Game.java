import java.io.IOException;

public class Game {

    public boolean isDigit(String string, int index) {
        return Character.isDigit(string.charAt(index));
    }

    public int[] stringToIntArray(String input) throws Exception {
        if (!isDigit(input, 0) || !isDigit(input, 1) || !isDigit(input, 2)) {
            throw new Exception("String include character that is not digit.");
        }
        return new int[] {
            Character.getNumericValue(input.charAt(0)),
            Character.getNumericValue(input.charAt(1)),
            Character.getNumericValue(input.charAt(2))
        };
    }

    public void play(UI ui, Computer computer) throws Exception {
        computer.selectNumbers();

        boolean correct = false;
        while (!correct) {
            int[] numbers = stringToIntArray(ui.input());

            int[] result = computer.calculate(numbers);
            ui.output(result);
            correct = result[0] == 3;
        }
    }

    public void repeatUntilExit(UI ui, Computer computer) throws Exception {
        do {
            play(ui, computer);
        } while (!ui.exit().equals("2"));
    }

    public static void main(String[] args){
        Computer computer = new Computer();
        UI ui =  new UI();
        Game game = new Game();
        try {
            game.repeatUntilExit(ui, computer);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            ui.close();
        }
    }
}
