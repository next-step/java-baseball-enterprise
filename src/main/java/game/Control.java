package game;

public class Control {
    private GameRule gameRule;
    private UI ui;
    private Computer computer;

    public Control() {
        this.gameRule = new GameRule();
        this.ui = new UI(gameRule);
        this.computer = new Computer(gameRule);
    }

    private boolean inGameLoop() {
        int[] numbers = ui.getUserNumbers();
        GameRule.Result result = computer.getResult(numbers);
        ui.printResult(result);
        if (result.isEnd)
            return true;
        return false;
    }

    private boolean gameLoop() {
        boolean isEnd = false;
        computer.updateNumbers();
        while (!isEnd) {
            isEnd = this.inGameLoop();
        }
        if (ui.getEndingStatus())
            return true;
        return false;
    }

    public void start() {
        boolean isEnd = false;
        while (!isEnd) {
            isEnd = this.gameLoop();
        }
    }
}