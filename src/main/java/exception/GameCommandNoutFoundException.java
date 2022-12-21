package exception;

public class GameCommandNoutFoundException extends RuntimeException {

    public static final String GAME_COMMAND_NOT_FOUND_EXCEPTION = "잘못된 커멘드 입력입니다.";

    public GameCommandNoutFoundException() {
        super(GAME_COMMAND_NOT_FOUND_EXCEPTION);
    }
}
