package baseball.view;

import baseball.domain.StrikeBallCount;

public class OutputView {
    private final String STRIKE_KOR = "스트라이크 ";
    private final String BALL_KOR = "볼";
    private final String NOTHING_KOR = "낫싱";
    private StringBuilder sb;

    public void printResult(StrikeBallCount strikeBallCount) {
        sb = new StringBuilder();
        addString(strikeBallCount.getStrikeCount(), STRIKE_KOR);
        addString(strikeBallCount.getBallCount(), BALL_KOR);
        if (sb.length() == 0) {
            sb.append(NOTHING_KOR);
        }
        System.out.println(sb.toString().trim());
    }

    public void addString(int num, String kor_string) {
        if (num > 0) {
            sb.append(num);
            sb.append(kor_string);
        }
    }
}
