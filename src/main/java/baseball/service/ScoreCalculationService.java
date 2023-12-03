package baseball.service;

import baseball.domain.Balls;
import baseball.dto.ScoreDto;

public class ScoreCalculationService {

    public ScoreDto calcScore(Balls userBalls, Balls computerBalls) {
        int sameBallCount = userBalls.countSameBall(computerBalls);
        int strikeCount = userBalls.countSameBallWithSameOrder(computerBalls);
        int ballCount = sameBallCount - strikeCount;

        return ScoreDto.of(strikeCount, ballCount);
    }
}
