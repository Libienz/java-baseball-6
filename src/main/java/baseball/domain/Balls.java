package baseball.domain;

import java.util.HashSet;
import java.util.List;
import java.util.stream.IntStream;

public class Balls {
    private static final int BALL_LENGTH = 3;

    private List<Ball> balls;

    public Balls(List<Ball> balls) {
        validate(balls);
        this.balls = balls;
    }

    public int countSameBallWithSameOrder(Balls target) {
        return (int) IntStream.range(0, BALL_LENGTH)
                .filter(i -> this.balls.get(i).equals(target.balls.get(i)))
                .count();
    }

    public int countSameBall(Balls target) {
        return (int) balls.stream()
                .filter(ball -> target.balls.contains(ball))
                .count();
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
