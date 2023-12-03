package baseball.controller;

import baseball.domain.Balls;
import baseball.dto.ScoreDto;
import baseball.service.ScoreCalculationService;

public class ScoreCalculationController {
    private final ScoreCalculationService scoreCalculationService;

    public ScoreCalculationController(ScoreCalculationService scoreCalculationService) {
        this.scoreCalculationService = scoreCalculationService;
    }

    public ScoreDto calculateScore(Balls userBalls, Balls computerBalls) {
        return scoreCalculationService.calcScore(userBalls, computerBalls);
    }
}
