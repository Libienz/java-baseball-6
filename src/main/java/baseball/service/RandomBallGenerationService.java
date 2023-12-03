package baseball.service;

import baseball.domain.Ball;
import camp.nextstep.edu.missionutils.Randoms;

public class RandomBallGenerationService {
    private static final int MIN = 1;
    private static final int MAX = 9;

    public Ball generateBall() {
        return new Ball(Randoms.pickNumberInRange(MIN, MAX));
    }
}
