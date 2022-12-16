package baseball.view;

import baseball.model.Judgements;

public class JudgementsToTextConverter {

    public String convert(Judgements judgements) {
        if (judgements.isNothing()) {
            return nothingText();
        }

        if (judgements.isThreeStrike()) {
            return "3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임종료";
        }

        return strikeText(judgements) + ballText(judgements);
    }

    private String nothingText() {
        return "낫싱";
    }

    private String strikeText(Judgements judgements) {
        if (judgements.getStrike() == 0) {
            return "";
        }
        return judgements.getStrike() + "스트라이크";
    }

    private String ballText(Judgements judgements) {
        if (judgements.getBall() == 0) {
            return "";
        }
        if (judgements.getStrike() != 0) {
            return " " + judgements.getBall() + "볼";
        }
        return judgements.getBall() + "볼";
    }
}
