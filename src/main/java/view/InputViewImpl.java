package view;

import exception.ExceptionHandlerNoAction;
import exception.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import static exception.ExceptionMessage.*;

public class InputViewImpl implements InputView {

    private final Scanner scanner;
    private final Pattern pattern;
    private final ExceptionHandler exceptionHandler;

    public InputViewImpl() {
        this.scanner = new Scanner(System.in);
        this.pattern = Pattern.compile("^[0-9]*$");
        this.exceptionHandler = new ExceptionHandlerNoAction();
    }

    @Override
    public List<Integer> getThreeNumbers() {
        String line;
        do {
            line = scanner.nextLine();
        } while (validateThreeNumbers(line));
        return parsingLine(line);
    }

    private boolean validateThreeNumbers(String line) {
        if (!lengthIsThree(line)) {
            return false;
        }
        if (!isNumber(line))
            return false;
        return !isDuplicate(line);
    }

    private boolean lengthIsThree(String line) {
        if (line.length() != 3) {
            exceptionHandler.handleException(new IllegalArgumentException(INPUT_THREE_NUMBER_LENGTH_EXCEPTION));
            return false;
        }
        return true;

    }

    private boolean isNumber(String line) {
        if (!this.pattern.matcher(line).matches()) {
            exceptionHandler.handleException(new IllegalArgumentException(INPUT_THREE_NUMBER_TYPE_EXCEPTION));
            return false;
        }
        return true;
    }

    private boolean isDuplicate(String line) {
        if (line.charAt(0) == line.charAt(1) || line.charAt(0) == line.charAt(2) || line.charAt(1) == line.charAt(2)) {
            exceptionHandler.handleException(new IllegalArgumentException(INPUT_THREE_NUMBER_DUPLICATE_EXCEPTION));
            return true;
        }
        return false;
    }


    private List<Integer> parsingLine(String line) {
        ArrayList<Integer> threeNumbers = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            threeNumbers.add(line.charAt(i) - '0');
        }
        return threeNumbers;
    }


}
