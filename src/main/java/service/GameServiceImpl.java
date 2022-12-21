package service;

import domain.Computer;
import domain.Score;
import domain.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class GameServiceImpl implements GameService {


    @Override
    public void startGame(Computer computer, User user, Score score) throws IOException {
        computer.reset();
        user.reset();
        score.reset();
        System.out.println(computer.getNumbers());
        while (playGame(computer, user, score)) {
            user.reset();
            score.reset();
        }
    }

    @Override
    public boolean playGame(Computer computer, User user, Score score) throws IOException {
        while (user.getNumbers().isEmpty()) {
            userInput(user);
        }
        compareNumbers(computer, user, score);
        System.out.println(score.getScore());

        if (score.isFinish()){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return false;
        }
        return true;
    }

    @Override
    public void userInput(User user) throws IOException {
        try {
            System.out.print("숫자를 입력해주세요 : ");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String num = reader.readLine();
            user.setNumbers(num);
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void compareNumbers(Computer computer, User user, Score score){
        for (int i = 0 ; i < 3 ; i++ ){
            compareNumber(computer.getNumbers(), user.getNumbers().get(i), i, score);
        }

    }

    @Override
    public void compareNumber(ArrayList<Integer> computerNumbers, Integer userNum, int userIndex, Score score) {
        if (computerNumbers.contains(userNum)) {
            score.setBall(score.getBall() + 1);
        }
        if (Objects.equals(computerNumbers.get(userIndex), userNum)) {
            score.setBall(score.getBall() - 1);
            score.setStrike(score.getStrike() + 1);
        }
   }

}
