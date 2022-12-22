package global.model;

public final class InputVerifier {
    private InputVerifier(){}

    public static InputVerifier getInstance() {
        return LazyHolder.INSTANCE;
    }

    private static class LazyHolder {
        private static final InputVerifier INSTANCE = new InputVerifier();
    }

    public boolean isIntegerWithLength(String input, int length) {
        if (isIllegalInputStringWithLength(input, length) || input.charAt(0) < '0' || input.charAt(0) > '9') {
            return false;
        }

        if (length == 1) {
            return true;
        }

        return isIntegerWithLength(input.substring(1), length - 1);
    }

    private boolean isIllegalInputStringWithLength(String input, int length) {
        return input == null || length <= 0 || input.length() != length;
    }

    public boolean hasZero(String input) {
        return input.contains("0");
    }
}
