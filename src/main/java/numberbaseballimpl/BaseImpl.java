package numberbaseballimpl;

import numberbaseball.Base;

public class BaseImpl implements Base {

    private BaseImpl() {
    }

    public static Base createRandomBase() {
        return null;
    }

    @Override
    public int[] getNumbers() {
        return null;
    }

    @Override
    public boolean isStrike(int index, int number) {
        return false;
    }

    @Override
    public boolean isBall(int index, int number) {
        return false;
    }
}
