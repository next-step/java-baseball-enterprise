package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class BaseballTest {
	Baseball game = new BaseballImpl();

	@Test
	@DisplayName("컴퓨터의 랜덤 숫자 생성 테스트")
	void computerGenerateNumbers() {
		int[] number = game.generateNumber();
		assertThat(number.length).isEqualTo(3);
		assertThat(game.checkValidOfNumber(number)).isTrue();
	}

	@Test
	@DisplayName("유저 입력 테스트")
	void playerInputValidTest() {
		int[] validNumber = {1,2,3};
		assertThat(game.checkValidOfNumber(validNumber)).isTrue();

		int[] outOfBound1 = {0,1,2};
		assertThat(game.checkValidOfNumber(outOfBound1)).isFalse();
		int[] outOfBound2 = {1,2,10};
		assertThat(game.checkValidOfNumber(outOfBound2)).isFalse();

		int[] invalidLength1 = {1,2};
		assertThat(game.checkValidOfNumber(invalidLength1)).isFalse();
		int[] invalidLength2 = {1,2,3,4};
		assertThat(game.checkValidOfNumber(invalidLength2)).isFalse();
	}

	@Test
	@DisplayName("숫자 매칭 테스트")
	void matchResultTest() {
		int[] computerNumber = {1,2,3};
		int[] correctNumber = {1,2,3};
		assertThat(game.getMatchResult(computerNumber, correctNumber)).containsExactly(3, 0);

		int[] threeBall = {2,3,1};
		assertThat(game.getMatchResult(computerNumber, threeBall)).containsExactly(0, 3);

		int[] oneStrikeOneBall = {1, 3, 4};
		assertThat(game.getMatchResult(computerNumber, oneStrikeOneBall)).containsExactly(1, 1);

		int[] nothing = {4,5,6};
		assertThat(game.getMatchResult(computerNumber, nothing)).containsExactly(0, 0);
	}
}
