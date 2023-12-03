package baseball.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class UserBalls {
    private static final int BALL_LENGTH = 3;
    private static final int MIN_BALL = 1;
    private static final int MAX_BALL = 9;

    private List<Integer> userBalls = new ArrayList<>();

    public UserBalls(List<Integer> userBalls) {
        validate(userBalls);
        this.userBalls = userBalls;
    }

    private void validate(List<Integer> userBalls) {
        validateLength(userBalls);
        validateRange(userBalls);
        validateUnique(userBalls);
    }

    private void validateLength(List<Integer> userBalls) {
        if (userBalls.size() != BALL_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private void validateRange(List<Integer> userBalls) {
        if (containsInvalidBall(userBalls)) {
            throw new IllegalArgumentException();
        }

    }

    private void validateUnique(List<Integer> userBalls) {
        if (new HashSet<>(userBalls).size() != BALL_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private boolean containsInvalidBall(List<Integer> userBalls) {
        return userBalls.stream().anyMatch(ball -> ball < MIN_BALL || ball > MAX_BALL);
    }

}
