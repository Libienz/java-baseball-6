package baseball.domain;

import java.util.HashSet;
import java.util.List;

public class Balls {
    private static final int BALL_LENGTH = 3;
    private static final int MIN_BALL = 1;
    private static final int MAX_BALL = 9;

    private List<Ball> balls;

    public Balls(List<Ball> balls) {
        validate(balls);
        this.balls = balls;
    }

    private void validate(List<Ball> balls) {
        validateLength(balls);
        validateUnique(balls);
    }

    private void validateLength(List<Ball> balls) {
        if (balls.size() != BALL_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private void validateUnique(List<Ball> balls) {
        if (new HashSet<>(balls).size() != BALL_LENGTH) {
            throw new IllegalArgumentException();
        }
    }
}
