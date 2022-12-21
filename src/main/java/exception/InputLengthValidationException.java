package exception;

public class InputLengthValidationException extends RuntimeException {

    public static final String INPUT_LENGTH_VALIDATION_EXCEPTION_MESSAGE = "잘못된 길이의 입력입니다.";

    public InputLengthValidationException() {
        super(INPUT_LENGTH_VALIDATION_EXCEPTION_MESSAGE);
    }
}
