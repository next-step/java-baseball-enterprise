package exception;

public class InputNumberDuplicationException extends RuntimeException {

    public static final String INPUT_NUMBER_DUPLICATION_EXCEPTION_MESSAGE = "입력에는 중복된 숫자가 존재할 수 없습니다.";

    public InputNumberDuplicationException() {
        super(INPUT_NUMBER_DUPLICATION_EXCEPTION_MESSAGE);
    }
}
