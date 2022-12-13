package baseball;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Numbers implements Iterable<Number> {

    private final List<Number> value;

    public Numbers(String numbers) {
        value = new ArrayList<>();

        for (int i = 0; i < numbers.length(); i++) {
            value.add(new Number(numbers.charAt(i), i));
        }
    }

    @Override
    public Iterator<Number> iterator() {
        return value.iterator();
    }
}
