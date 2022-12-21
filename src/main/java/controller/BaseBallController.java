package controller;

import domain.Computer;
import domain.Score;
import domain.User;
import service.GameServiceImpl;
import service.GameService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class BaseBallController {

    private static Computer computer;
    private static User user;
    private static Score score;

    private static GameService gameService;

    public void BaseBallGame() throws IOException {
        computer = new Computer();
        user = new User();
        score = new Score();
        gameService = new GameServiceImpl();
        String newGame = "1";
        while (Objects.equals(newGame, "1")) {
            newGame = BaseBallGameStart();
        }

    }

    public static String BaseBallGameStart() throws IOException {
        String nextGame = "0";
        gameService.startGame(computer, user, score);
        while (!Objects.equals(nextGame, "1") && !Objects.equals(nextGame, "2")){
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하시오.");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            nextGame = (reader.readLine());

        }
        return nextGame;
    }

}
