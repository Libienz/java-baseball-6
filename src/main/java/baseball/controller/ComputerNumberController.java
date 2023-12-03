package baseball.controller;

import baseball.domain.Balls;
import baseball.service.RandomBallsGenerationService;

public class ComputerNumberController {
    private final RandomBallsGenerationService randomBallsGenerationService;

    public ComputerNumberController(RandomBallsGenerationService randomBallsGenerationService) {
        this.randomBallsGenerationService = randomBallsGenerationService;
    }

    public Balls generateComputerNumber() {
        return randomBallsGenerationService.generateBalls();
    }
}
