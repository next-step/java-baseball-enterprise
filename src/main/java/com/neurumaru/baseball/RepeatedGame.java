package com.neurumaru.baseball;

public abstract class RepeatedGame {
    public boolean repeat = true;

    public abstract void initGame();
    public abstract void startGame();
    public abstract void endGame();
    public abstract boolean isRepeated();

    public void repeatGame() {
        initGame();
        while(repeat) {
            startGame();
            repeat = isRepeated();
        }
        endGame();
    }
}
