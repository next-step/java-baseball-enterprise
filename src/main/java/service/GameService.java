package service;

import domain.Computer;
import domain.Score;
import domain.User;

import java.io.IOException;
import java.util.ArrayList;

public interface GameService {
    void startGame(Computer computer, User user, Score score) throws IOException;

    boolean playGame(Computer computer, User user, Score score) throws IOException;

    void userInput(User user) throws IOException;

    void compareNumbers(Computer computer, User user, Score score);

    void compareNumber(ArrayList<Integer> computerNumbers, Integer userNum, int userIndex, Score score);
}
