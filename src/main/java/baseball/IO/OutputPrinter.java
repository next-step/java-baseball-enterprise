package baseball.IO;

import baseball.dto.GuessResult;

public interface OutputPrinter {

    void printInputGuideMessage();

    void printResult(GuessResult result);

    void printClearMessage();

}
