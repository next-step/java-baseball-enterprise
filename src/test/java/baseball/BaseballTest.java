package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class BaseballTest {

	@Test
	@DisplayName("컴퓨터의 랜덤 숫자 생성 테스트")
	void computerGenerateNumbers() {
		Baseball game = new BaseballImpl();
		int[] numbers = game.generateNumber();
		assertThat(numbers.length).isEqualTo(3);
		assertThat(game.checkValidOfPlayerInput(numbers)).isTrue();
	}
}
