import domain.BaseballGame;

public class BaseballAppImpl implements BaseballApp {

    private static final BaseballGame baseballGame = new BaseballGameImpl();
    @Override
    public void run() {
        baseballGame.play(1);
    }
}
