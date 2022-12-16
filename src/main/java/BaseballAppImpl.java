import config.BaseballConfig;
import domain.BaseballGame;
import domain.BaseballGameImpl;

public class BaseballAppImpl implements BaseballApp {
    private BaseballConfig baseballConfig;

    public BaseballAppImpl(BaseballConfig baseballConfig) {
        this.baseballConfig = baseballConfig;
    }

    @Override
    public void run() {
        BaseballGame baseballGame = new BaseballGameImpl(baseballConfig);
        baseballGame.play(1);
    }

    public static void main(String[] args) {
        BaseballApp baseballApp = new BaseballAppImpl(new BaseballConfig());
        baseballApp.run();
    }
}
