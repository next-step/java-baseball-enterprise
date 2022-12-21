package input;

import exception.InputLengthValidationException;
import exception.InputNumberDuplicationException;

import java.util.HashSet;
import java.util.List;

public class InputValidator {

    public void validateInput(List<Integer> input) {
        if (!isValidSize(input)) {
            throw new InputLengthValidationException();
        }
        if (hasDuplicatedNumbers(input)) {
            throw new InputNumberDuplicationException();
        }
    }

    private boolean isValidSize(List<Integer> input) {
        return input.size() == 3;
    }

    private boolean hasDuplicatedNumbers(List<Integer> input) {
        return new HashSet<>(input).size() != input.size();
    }
}
