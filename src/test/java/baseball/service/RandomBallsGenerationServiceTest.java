package baseball.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.Assertions.assertThatNoException;

@DisplayName("랜덤 수 묶음 생성 서비스 테스트")
class RandomBallsGenerationServiceTest {
    private RandomBallsGenerationService randomBallsGenerationService;

    @BeforeEach
    void setUp() {
        randomBallsGenerationService = new RandomBallsGenerationService(new RandomBallGenerationService());
    }

    @DisplayName("랜덤 생성된 랜덤 수 묶음은 검증을 통과한다")
    @RepeatedTest(50)
    void testRandomBallsValid() {
        assertThatNoException().isThrownBy(randomBallsGenerationService::generateBalls);
    }
}