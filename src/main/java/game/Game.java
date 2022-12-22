package game;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collections;

public class Game {
    public final int[] actualValues;
    private static final AbstractMap.SimpleEntry<Integer, Integer>[] BALL_CHECK_TABLE = new AbstractMap.SimpleEntry[]{
            new AbstractMap.SimpleEntry<>(0, 1),
            new AbstractMap.SimpleEntry<>(0, 2),
            new AbstractMap.SimpleEntry<>(1, 0),
            new AbstractMap.SimpleEntry<>(1, 2),
            new AbstractMap.SimpleEntry<>(2, 0),
            new AbstractMap.SimpleEntry<>(2, 1),
    };
    private static final AbstractMap.SimpleEntry<Integer, Integer>[] STRIKE_CHECK_TABLE = new AbstractMap.SimpleEntry[]{
            new AbstractMap.SimpleEntry<>(0, 0),
            new AbstractMap.SimpleEntry<>(1, 1),
            new AbstractMap.SimpleEntry<>(2, 2),
    };

    private Game(int[] actualValues) {
        if (actualValues == null) {
            throw new RuntimeException("actualValues is null");
        }
        if (actualValues.length != 3) {
            throw new RuntimeException(String.format("actualValues length expect 3, but got %d", actualValues.length));
        }
        this.actualValues = actualValues;
    }

    public static int[] randomPick() {
        var arr = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Collections.shuffle(arr);
        return new int[]{arr.get(0), arr.get(1), arr.get(2)};
    }

    public static Game randomGame() {
        return new Game(Game.randomPick());
    }

    public static Game expectedGame(int a, int b, int c) {
        return new Game(new int[]{a, b, c});
    }

    // 검사 없는 ball 개수 확인 함수
    private int countByTableUnsafe(AbstractMap.SimpleEntry<Integer, Integer>[] table, int[] expectValues) {
        assert expectValues != null;
        assert expectValues.length == 3;
        // 개수 확인 집계용도
        int count = 0;
        for (var index:table) {
            if (this.actualValues[index.getKey()] == expectValues[index.getValue()]) {
                count += 1;
            }
        }
        return count;
    }

    public GameResult calculateGameResults(int[] expectValues) {
        if (expectValues == null) {
            throw new RuntimeException("expectValue is null");
        }
        if (expectValues.length != 3) {
            throw new RuntimeException(String.format("expectValue length expect 3, but got %d", expectValues.length));
        }
        return new GameResult(
                this.countByTableUnsafe(Game.BALL_CHECK_TABLE, expectValues),
                this.countByTableUnsafe(Game.STRIKE_CHECK_TABLE, expectValues)
        );
    }
}
