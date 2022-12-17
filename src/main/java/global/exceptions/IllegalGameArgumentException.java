package global.exceptions;

public class IllegalGameArgumentException extends GameException {

    public IllegalGameArgumentException() {
    }

    public IllegalGameArgumentException(String s) {
        super(s);
    }

    public IllegalGameArgumentException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalGameArgumentException(Throwable cause) {
        super(cause);
    }
}
