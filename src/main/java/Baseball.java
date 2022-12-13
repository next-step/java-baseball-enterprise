public interface Baseball {
	public void init();
	public void start();
	public void drawStartMessage();
	public int generateNumber();
	public int getPlayerInput();
	public boolean checkValidOfPlayerInput(int[] playerInput);
	public boolean check1to9(int[] playerInput);
	public boolean checkDuplicate(int[] playerInput);

	/**
	 *
	 * @param computerNumber
	 * @param playerNumber
	 * @return int[2] - 0: strike, 1: ball
	 */
	public int[] getMatchResult(int[] computerNumber, int[] playerNumber);
	public String drawMatchResult(int[] matchResult);
	public boolean isGameOver(int[] matchResult);
}
