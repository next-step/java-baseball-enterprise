import domain.BaseballGame;
import domain.BaseballGameImpl;

public class BaseballAppImpl implements BaseballApp {
    private final BaseballGame baseballGame;

    public BaseballAppImpl(BaseballGame baseballGame){
        this.baseballGame = baseballGame;
    }
    @Override
    public void run() {
        baseballGame.play(1);
    }
}
