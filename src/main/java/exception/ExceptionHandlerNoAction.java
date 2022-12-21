package exception;

public class ExceptionHandlerNoAction implements ExceptionHandler {
    @Override
    public void handleException(Exception e) {
        System.out.println(e.getMessage());
    }
}
