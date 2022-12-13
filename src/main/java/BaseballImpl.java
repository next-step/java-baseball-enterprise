public class BaseballImpl implements Baseball{

	@Override
	public void init() {

	}

	@Override
	public void start() {

	}

	@Override
	public void drawStartMessage() {

	}

	@Override
	public int generateNumber() {
		return 0;
	}

	@Override
	public int getPlayerInput() {
		return 0;
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
