package domain;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ScoreTest {
    @Test
    void setScore(){
        Score score = new Score();

        String actual = score.getScore();
        assertThat(actual).isEqualTo("낫싱");

        score.setBall(2);
        actual = score.getScore();
        assertThat(actual).isEqualTo("2 볼");

        score.setStrike(1);
        actual = score.getScore();
        assertThat(actual).isEqualTo("1 스트라이크 2 볼");

        score.setBall(0);
        actual = score.getScore();
        assertThat(actual).isEqualTo("1 스트라이크");
    }

}
