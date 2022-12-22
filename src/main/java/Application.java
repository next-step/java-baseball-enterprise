import domain.number_baseball.controller.NumberBaseballGameController;
import domain.number_baseball.view.NumberBaseballView;
import global.controller.GameController;
import global.controller.GameRunner;

public class Application {
    public static void main(String[] args) {
        final NumberBaseballView view = new NumberBaseballView();
        final GameController controller = new NumberBaseballGameController(view);
        final GameRunner runner = new GameRunner(controller);

        runner.run();
    }
}
