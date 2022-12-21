package baseball.domain.user;

import baseball.domain.computer.RandomNumbers;
import baseball.util.validator.UserInputValidator;

import java.util.Iterator;
import java.util.List;

import static baseball.util.util.NumberUtils.getSingleIntegerListFromInt;

public class UserInput implements Iterable<Integer> {
    private final List<Integer> inputList;

    public UserInput(String input) {
        UserInputValidator.validate(input);
        this.inputList = getSingleIntegerListFromInt(Integer.parseInt(input));;
    }

    public int intersect(RandomNumbers numbers) {
        inputList.retainAll(numbers.getNumbers());
        return inputList.size();
    }

    @Override
    public Iterator<Integer> iterator() {
        return inputList.iterator();
    }
}
