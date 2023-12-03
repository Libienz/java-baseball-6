package baseball.domain;

import java.util.Objects;

public class Ball {
    private static final int MIN_BALL = 1;
    private static final int MAX_BALL = 9;

    private int ball;

    public Ball(int ball) {
        validate(ball);
        this.ball = ball;
    }

    private void validate(int ball) {
        validateRange(ball);
    }

    private void validateRange(int ball) {
        if (ball < MIN_BALL || ball > MAX_BALL) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball1 = (Ball) o;
        return ball == ball1.ball;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ball);
    }
}
