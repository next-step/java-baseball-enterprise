package input;

import java.util.ArrayList;
import java.util.List;

public class InputParser {

    public List<Integer> toIntegerList(String input) throws NumberFormatException {
        ArrayList<Integer> result = new ArrayList<>();
        for (String element : input.split("")) {
            result.add(Integer.parseInt(element));
        }
        return result;
    }
}
