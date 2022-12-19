package numberbaseball;

public interface Enemy {

    void reset(Base base);

    Hint shoot(Ball ball);
}
