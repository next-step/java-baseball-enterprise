import java.util.Set;

public class CountBallStrike {
    public static int countBall(Set<Integer> numbers, Set<Integer> numbers2) {
        int ball = 0;

        for (Integer number : numbers) {
            if (numbers2.contains(number)) ball++;
        }
        return ball;
    }

    public static int countStrike(Integer[] nums, Integer[] nums2) {
        int strike = 0;

        for (int i = 0; i < 3; i++) {
            if (nums[i] == nums2[i]) {
                strike++;
            }
        }
        return strike;
    }
}
