package numberbaseball;

public interface NumberBaseballUI {
    int inputBall();

    void printInputError();

    void printHint(Hint hint);

    int inputContinue();

    void printEnd();
}
