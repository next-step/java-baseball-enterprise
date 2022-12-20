package baseball;

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
		int[] answer = generateNumber();
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
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자를 입력하세요 : ");
		int input = sc.nextInt();
		int[] processed = {input/100, input/10%10, input%10};
		return processed;
	}

	@Override
	public boolean checkValidOfNumber(int[] number) {
		if(number.length != 3)
			return false;
		if(!check1to9(number))
			return false;
		if(checkDuplicate(number))
			return false;
		return true;
	}

	@Override
	public boolean check1to9(int[] number) {
		if(number[0] < 1 || number[0] > 9)
			return false;
		if(number[1] < 1 || number[1] > 9)
			return false;
		if(number[2] < 1 || number[2] > 9)
			return false;
		return true;
	}

	@Override
	public boolean checkDuplicate(int[] number) {
		if(number[0] == number[1])
			return true;
		if(number[1] == number[2])
			return true;
		if(number[0] == number[2])
			return true;
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
