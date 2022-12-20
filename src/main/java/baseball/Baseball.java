package baseball;

public interface Baseball {
	public void init();
	public void start();
	public void drawStartMessage();
	public int[] generateNumber();
	public int[] getPlayerInput();
	public boolean checkValidOfNumber(int[] number);
	public boolean check1to9(int[] number);
	public boolean checkDuplicate(int[] number);

	/**
	 *
	 * @param computerNumber
	 * @param playerNumber
	 * @return int[2] - 0: strike, 1: ball
	 */
	public int[] getMatchResult(int[] computerNumber, int[] playerNumber);
	public void drawMatchResult(int[] matchResult);
	public boolean isGameOver(int[] matchResult);
}
