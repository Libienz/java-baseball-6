package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

@DisplayName("유저 추측 수 테스트")
class UserBallsTest {

    @DisplayName("중복되는 숫자가 있으면 생성 시 검증에 실패한다")
    @ParameterizedTest
    @MethodSource("nonUniqueUserBall")
    void testValidationFailWithNonUniqueNumbers(List<Integer> numbers) {
        List<Ball> balls = numbers.stream().map(Ball::new).toList();
        assertThatThrownBy(() -> new Balls(balls))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("길이가 맞지 않으면 생성 시 검증에 실패한다")
    @ParameterizedTest
    @MethodSource("invalidLengthBalls")
    void testValidationFailWithInvalidLength(List<Integer> numbers) {
        List<Ball> balls = numbers.stream().map(Ball::new).toList();
        assertThatThrownBy(() -> new Balls(balls))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("올바른 조건의 공들로 생성 시 검증을 통과한다")
    @ParameterizedTest
    @MethodSource("validBalls")
    void testValidationWithValidBalls(List<Integer> numbers) {
        List<Ball> balls = numbers.stream().map(Ball::new).toList();
        assertThatNoException().isThrownBy(() -> new Balls(balls));
    }

    @DisplayName("두 묶음 비교 테스트 - 순서와 값 모두 같은 요소 개수 계산")
    @ParameterizedTest
    @MethodSource("comparisonParameter1")
    void testCountSameBallWithSameOrder(List<Integer> userBallsParam, List<Integer> computerBallsParam, int sameValueWithSameOrderCount) {
        Balls userBalls = new Balls(userBallsParam.stream().map(Ball::new).toList());
        Balls computerBalls = new Balls(computerBallsParam.stream().map(Ball::new).toList());

        assertThat(userBalls.countSameBallWithSameOrder(computerBalls)).isEqualTo(sameValueWithSameOrderCount);
    }

    @DisplayName("두 묶음 비교 테스트 - 값이 같은 요소 개수 계산")
    @ParameterizedTest
    @MethodSource("comparisonParameter2")
    void testCountSameBall(List<Integer> userBallsParam, List<Integer> computerBallsParam, int sameValueCount) {
        Balls userBalls = new Balls(userBallsParam.stream().map(Ball::new).toList());
        Balls computerBalls = new Balls(computerBallsParam.stream().map(Ball::new).toList());

        assertThat(userBalls.countSameBall(computerBalls)).isEqualTo(sameValueCount);
    }

    static Stream<Arguments> nonUniqueUserBall() throws Throwable {

        return Stream.of(
                Arguments.of(List.of(1, 2, 2)),
                Arguments.of(List.of(1, 1, 1)),
                Arguments.of(List.of(3, 3, 3)),
                Arguments.of(List.of(4, 5, 5))
        );
    }

    static Stream<Arguments> invalidLengthBalls() throws Throwable {
        return Stream.of(
                Arguments.of(List.of(1, 2)),
                Arguments.of(List.of(1)),
                Arguments.of(List.of(1, 2, 3, 4)),
                Arguments.of(List.of())
        );
    }

    static Stream<Arguments> validBalls() throws Throwable {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3)),
                Arguments.of(List.of(4, 5, 6)),
                Arguments.of(List.of(7, 8, 9)),
                Arguments.of(List.of(1, 5, 9))
        );
    }

    static Stream<Arguments> comparisonParameter1() throws Throwable {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3), List.of(1, 2, 3), 3),
                Arguments.of(List.of(4, 5, 6), List.of(4, 6, 7), 1),
                Arguments.of(List.of(7, 8, 9), List.of(1, 2, 3), 0),
                Arguments.of(List.of(1, 5, 9), List.of(3, 5, 9), 2)
        );
    }

    static Stream<Arguments> comparisonParameter2() throws Throwable {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3), List.of(1, 2, 3), 3),
                Arguments.of(List.of(4, 5, 6), List.of(4, 6, 7), 2),
                Arguments.of(List.of(7, 8, 9), List.of(1, 2, 3), 0),
                Arguments.of(List.of(1, 5, 2), List.of(3, 5, 9), 1)
        );
    }

}