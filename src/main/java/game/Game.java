package game;


import console.Console;
import console.Menu;

import java.util.ArrayList;
import java.util.Collections;

public class Game {

    private final Console console;
    private ArrayList<Integer> answer;

    public Game() {
        this.console = new Console();
        answer = new ArrayList<>(3);
    }

    public void start(){
        makeRandomNumber();
        while(true) {
            ArrayList<Integer> playerAnswer = console.getPlayerAnswer();
            Score score = new Score(0, 0);
            setScore(playerAnswer, score);
            console.printScore(score);
            if (score.getStrike() == 3)
                break;
        }
        console.printGameEnd();
    }

    private void setScore(ArrayList<Integer> playerAnswer, Score score) {
        setStrikeCount(playerAnswer, score);
        for (int idx = 0; idx < 3; idx++) {
            setBallCount(playerAnswer, score, idx);
        }
    }

    private void setBallCount(ArrayList<Integer> playerAnswer, Score score, int idx){
        for (int compIdx = 0; compIdx < 3; compIdx++){
            if (compIdx != idx && answer.get(compIdx) == playerAnswer.get(idx))
                score.plusBall();
        }
    }

    private void setStrikeCount(ArrayList<Integer> playerAnswer, Score score){
        for (int idx = 0; idx < 3; idx++){
            if (answer.get(idx) == playerAnswer.get(idx)) {
                score.plusStrike();
            }
        }
    }

    private void makeRandomNumber() {
        answer.clear();
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        for (int idx = 0; idx < 3; idx++) {
            answer.add(numbers.get(idx));
        }
    }

    public boolean checkGameAgain(){
        return Menu.isDoGame(console.getGameMenu());
    }
}
