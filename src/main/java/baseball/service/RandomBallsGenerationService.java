package baseball.service;

import baseball.domain.Ball;
import baseball.domain.Balls;

import java.util.List;
import java.util.stream.IntStream;

public class RandomBallsGenerationService {
    private static final int LENGTH = 3;

    private final RandomBallGenerationService randomBallGenerationService;

    public RandomBallsGenerationService(RandomBallGenerationService randomBallGenerationService) {
        this.randomBallGenerationService = randomBallGenerationService;
    }

    public Balls generateBalls() {
        List<Ball> balls = IntStream.range(0, 3)
                .mapToObj(i -> randomBallGenerationService.generateBall())
                .toList();
        return new Balls(balls);
    }
}
