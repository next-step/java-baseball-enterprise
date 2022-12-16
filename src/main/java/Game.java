
public class Game {
    private static final int RESULT_STRING_LENGTH = 3;
    private static final int RESULT_THREE_STRIKE = 3;

    public void validateCharacter(char ch) throws Exception {
        if (!Character.isDigit(ch) || ch=='0') {
            throw new Exception("invalid input : invalid character (not '1'-'9')");
        }
    }

    public void validate(String input) throws Exception {
        if (input.length() != RESULT_STRING_LENGTH) {
            throw new Exception("invalid input : not length "+ RESULT_STRING_LENGTH + "");
        }
        for (int i = 0; i<input.length(); i++) {
            validateCharacter(input.charAt(i));
        }
    }

    public int[] inputToNumbers(String input) throws Exception {
        validate(input);

        return new int[] {
            Character.getNumericValue(input.charAt(0)),
            Character.getNumericValue(input.charAt(1)),
            Character.getNumericValue(input.charAt(2))
        };
    }

    public void play(UI ui, Computer computer) throws Exception {
        computer.selectNumbers();

        boolean end = false;
        while (!end) {
            int[] numbers = inputToNumbers(ui.input());
            int[] result = computer.calculate(numbers);
            ui.output(result);
            end = result[0] == RESULT_THREE_STRIKE;
        }
    }

    public void repeatUntilExit(UI ui, Computer computer) throws Exception {
        do {
            play(ui, computer);
        } while (ui.end().equals(UI.RESTART));
    }

    public static void main(String[] args){
        Computer computer = new Computer(); UI ui =  new UI();
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
