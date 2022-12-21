package domain.ballnumber.generator;

import domain.ballnumber.BallNumber;

public interface BallNumberGenerator {

    BallNumber generate(int length);
}
