import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

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
		return null;
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
