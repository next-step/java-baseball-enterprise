package score;

import java.util.List;

@FunctionalInterface
public interface BaseBallCriterion {

    boolean judge(List<Integer> answer, Integer userNumber, Integer pos);
}
