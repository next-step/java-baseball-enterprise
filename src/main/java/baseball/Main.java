package baseball;
import baseball.controller.BaseballController;
import baseball.domain.BaseballNumber;
import baseball.service.BaseballService;
import baseball.view.BaseballView;


public class Main {
    public static void main(String[] args) {
        BaseballNumber baseballNumber = new BaseballNumber();
        BaseballService baseballService = new BaseballService(baseballNumber);
        BaseballController baseballController = new BaseballController(baseballService);
        BaseballView baseballView = new BaseballView(baseballController);
        baseballView.startGame();
    }
}
