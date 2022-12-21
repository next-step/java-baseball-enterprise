package baseball;

import baseball.model.Game;

public interface GameService {

    void startService();

    void runGame();

    Game generateRandomAnswer();
}
