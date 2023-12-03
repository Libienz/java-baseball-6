package baseball.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

@DisplayName("랜덤 수 생성기 테스트")
class RandomBallGenerationServiceTest {
    private RandomBallGenerationService randomBallGenerationService;

    @BeforeEach
    void setUp() {
        randomBallGenerationService = new RandomBallGenerationService();
    }

    @DisplayName("생성된 랜덤 수는 생성 시 범위 검증을 통과한다.")
    @RepeatedTest(50)
    void testRandomBallRange() {
        Assertions.assertThatNoException().isThrownBy(() -> randomBallGenerationService.generateBall());
    }
}