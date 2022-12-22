package game;

import java.util.Random;
import java.util.HashSet;

public class Computer {
    private GameRule gameRule;
    private Random random;
    private int[] numbers;

    public Computer(GameRule gameRule) {
        this.gameRule = gameRule;
        this.random = new Random();
        this.numbers = new int[gameRule.numbersLengh];
    }

    private int getNewNum(HashSet<Integer> appearedSet) {
        Integer randomNum = gameRule.numbersRange[random.nextInt(gameRule.numbersRange.length)];
        boolean isNew = appearedSet.add(randomNum);
        while (!isNew) {
            randomNum = gameRule.numbersRange[random.nextInt(gameRule.numbersRange.length)];
            isNew = appearedSet.add(randomNum);
        }
        return randomNum;
    }

    public void updateNumbers() {
        HashSet<Integer> appearedSet = new HashSet<Integer>();
        for (int i = 0; i < gameRule.numbersLengh; i++) {
            numbers[i] = this.getNewNum(appearedSet);
        }
    }

    public GameRule.Result getResult(int[] inputNumbers) {
        return gameRule.judgeResult(inputNumbers, numbers);
    }
}
