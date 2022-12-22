package baseball;

public class Ballcount {

    int strikes;
    int balls;

    private Ballcount(int strikes, int balls) {
        this.strikes = strikes;
        this.balls = balls;
    }
    public static Ballcount of(int strikes, int balls) {
        return new Ballcount(strikes, balls);
    }

    public int getStrikes() {
        return strikes;
    }

    public int getBalls() {
        return balls;
    }
}
