package baseball.service;

import baseball.domain.Balls;

import java.util.stream.Stream;

public class RandomBallsGenerationService {
    private static final int LENGTH = 3;

    private final RandomBallGenerationService randomBallGenerationService;

    public RandomBallsGenerationService(RandomBallGenerationService randomBallGenerationService) {
        this.randomBallGenerationService = randomBallGenerationService;
    }

    public Balls generateBalls() {

        return new Balls(Stream.generate(randomBallGenerationService::generateBall)
                .distinct()
                .limit(LENGTH)
                .toList());
    }

}
