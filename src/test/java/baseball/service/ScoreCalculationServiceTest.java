package baseball.service;

import baseball.domain.Ball;
import baseball.domain.Balls;
import baseball.dto.ScoreDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("점수 계산 서비스 테스트")
class ScoreCalculationServiceTest {
    private ScoreCalculationService scoreCalculationService;

    @BeforeEach
    void setUp() {
        scoreCalculationService = new ScoreCalculationService();
    }

    @DisplayName("점수 계산 기능 테스트")
    @ParameterizedTest
    @MethodSource("input")
    void testScoreCalculation(List<Integer> userNumbers, List<Integer> computerNumbers, int strikeCount, int ballCount) {
        Balls userBalls = new Balls(userNumbers.stream()
                .map(Ball::new)
                .toList());

        Balls computerBalls = new Balls(computerNumbers.stream()
                .map(Ball::new)
                .toList());

        ScoreDto scoreDto = scoreCalculationService.calcScore(userBalls, computerBalls);
        assertThat(scoreDto.getStrikeCount()).isEqualTo(strikeCount);
        assertThat(scoreDto.getBallCount()).isEqualTo(ballCount);

    }

    static Stream<Arguments> input() throws Throwable {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3), List.of(1, 2, 3), 3, 0),
                Arguments.of(List.of(4, 5, 6), List.of(4, 6, 7), 1, 1),
                Arguments.of(List.of(7, 8, 9), List.of(1, 2, 3), 0, 0),
                Arguments.of(List.of(1, 5, 2), List.of(3, 5, 9), 1, 0)
        );
    }
}