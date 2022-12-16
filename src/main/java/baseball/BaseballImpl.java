package baseball;

import java.util.Arrays;
import java.util.Collections;

public class BaseballImpl implements Baseball{

	@Override
	public void init() {

	}

	@Override
	public void start() {
		drawStartMessage();
	}

	@Override
	public void drawStartMessage() {
		System.out.println("=============================");
		System.out.println("|******    숫자야구게임    ******|");
		System.out.println("|============================|");
		System.out.println("|*****    지금 시작합니다    *****|");
		System.out.println("==============================");
	}

	@Override
	public int[] generateNumber() {
		int[] tmp = {1,2,3,4,5,6,7,8,9};
		Collections.shuffle(Arrays.asList(tmp));
		return Arrays.copyOfRange(tmp, 0, 3);
	}

	@Override
	public int[] getPlayerInput() {
		return null;
	}

	@Override
	public boolean checkValidOfPlayerInput(int[] playerInput) {
		return false;
	}

	@Override
	public boolean check1to9(int[] playerInput) {
		return false;
	}

	@Override
	public boolean checkDuplicate(int[] playerInput) {
		return false;
	}

	/**
	 *
	 * @param computerNumber
	 * @param playerNumber
	 * @return matchResult (int[2] - 0: strike, 1: ball)
	 */
	@Override
	public int[] getMatchResult(int[] computerNumber, int[] playerNumber) {
		return new int[2];
	}

	@Override
	public String drawMatchResult(int[] matchResult) {
		return null;
	}

	@Override
	public boolean isGameOver(int[] matchResult) {
		return false;
	}
}
