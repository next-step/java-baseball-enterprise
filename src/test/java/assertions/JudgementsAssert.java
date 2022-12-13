package assertions;

import baseball.Judgements;
import org.assertj.core.api.AbstractAssert;

public class JudgementsAssert extends AbstractAssert<JudgementsAssert, Judgements> {

    private JudgementsAssert(Judgements actual) {
        super(actual, JudgementsAssert.class);
    }

    public static JudgementsAssert assertThat(Judgements actual) {
        return new JudgementsAssert(actual);
    }

    public JudgementsAssert hasStrike(int expected) {
        if (actual.getStrike() != expected) {
            failWithMessage("Expected strike to be <%d> but was <%d>", expected, actual.getStrike());
        }
        return this;
    }

    public JudgementsAssert hasBall(int expected) {
        if (actual.getBall() != expected) {
            failWithMessage("Expected ball to be <%d> but was <%d>", expected, actual.getBall());
        }
        return this;
    }
}
