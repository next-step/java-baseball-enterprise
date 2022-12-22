package game;

public class Game {
    public final int[] actualValues;

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
        return new int[]{
                (int) Math.min((Math.random() * 9. + 1), 9.),
                (int) Math.min((Math.random() * 9. + 1), 9.),
                (int) Math.min((Math.random() * 9. + 1), 9.),
        };
    }
    public static Game randomGame() {
        return new Game(Game.randomPick());
    }

    public static Game expectedGame(int a, int b, int c) {
        return new Game(new int[]{a, b, c});
    }

    // 검사 없는 ball 개수 확인 함수
    private int countBallUnsafe(int[] expectValues) {
        assert expectValues != null;
        assert expectValues.length == 3;
        // 개수 확인 집계용도
        int count = 0;
        // 길이 동일여부 확인은 위에서 확인됨
        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j < 3; j++) {
                if (this.actualValues[i] == expectValues[j]) {
                    count += 1;
                }
            }
        }
        return count;
    }
    
    // 검사 없는 ball 개수 확인 함수
    private int countStrikeUnsafe(int[] expectValues) {
        assert expectValues != null;
        assert expectValues.length == 3;
        // 개수 확인 집계용도
        int count = 0;
        // 길이 동일여부 확인은 위에서 확인됨
        for (int i = 0; i < 3; i++) {
            if (this.actualValues[i] == expectValues[i]) {
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
        return new GameResult(this.countBallUnsafe(expectValues), countStrikeUnsafe(expectValues));
    }
}
