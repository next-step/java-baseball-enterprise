import domain.ballnumber.BallNumber;
import view.InputView;

public class InputManager {

    private InputView inputView;

    public InputManager() {
        this.inputView = new InputView();
    }

    public BallNumber inputGuessedBallNumber() {
        BallNumber guessedBallNumber = null;
        while((guessedBallNumber=tryInputGuessedBallNumber())==null){}
        return guessedBallNumber;
    }

    public BallNumber tryInputGuessedBallNumber() {
        BallNumber guessedBallNumber = null;
        try {
            guessedBallNumber = inputView.inputGuessedBallNumber();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            return guessedBallNumber;
        }
    }

}
