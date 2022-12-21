package ui;

import game.GameCommand;
import input.InputParser;
import input.InputValidator;

import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

public class InputManager {

    private final Scanner sc;
    private final InputValidator inputValidator;
    private final InputParser inputParser;

    public InputManager() {
        sc = new Scanner(System.in);
        inputValidator = new InputValidator();
        inputParser = new InputParser();
    }

    public InputManager(InputStream inputStream) {
        sc = new Scanner(inputStream);
        inputValidator = new InputValidator();
        inputParser = new InputParser();
    }

    public List<Integer> getInputNumbers() {
        String inputString = sc.next();
        List<Integer> input = inputParser.toIntegerList(inputString);
        inputValidator.validateInput(input);

        return input;
    }

    public GameCommand getInputGameCommand() {
        int gameCommand = sc.nextInt();
        return GameCommand.getCommand(gameCommand);
    }
}
