package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("유저 추측 수 테스트")
class UserBallsTest {

    @DisplayName("중복되는 숫자가 있으면 생성 시 검증에 실패한다")
    @ParameterizedTest
    @MethodSource("nonUniqueUserBall")
    void testValidationFailWithNonUniqueNumbers(List<Integer> numbers) {
        assertThatThrownBy(() -> new UserBalls(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("범위에 벗어나는 숫자가 있으면 생성 시 검증에 실패한다")
    @ParameterizedTest
    @MethodSource("invalidRangeBalls")
    void testValidationFailWithInvalidRangeNumber(List<Integer> numbers) {
        assertThatThrownBy(() -> new UserBalls(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("길이가 맞지 않으면 생성 시 검증에 실패한다")
    @ParameterizedTest
    @MethodSource("invalidLengthBalls")
    void testValidationFailWithInvalidLength(List<Integer> numbers) {
        assertThatThrownBy(() -> new UserBalls(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("올바른 조건의 공들로 생성 시 검증을 통과한다")
    @ParameterizedTest
    @MethodSource("validBalls")
    void testValidationWithValidBalls(List<Integer> numbers) {
        assertThatNoException().isThrownBy(() -> new UserBalls(numbers));
    }


    static Stream<Arguments> nonUniqueUserBall() throws Throwable {
        return Stream.of(
                Arguments.of(List.of(1, 2, 2)),
                Arguments.of(List.of(1, 1, 1)),
                Arguments.of(List.of(3, 3, 3)),
                Arguments.of(List.of(4, 5, 5))
        );
    }

    static Stream<Arguments> invalidRangeBalls() throws Throwable {
        return Stream.of(
                Arguments.of(List.of(-1, 1, 2)),
                Arguments.of(List.of(1, 2, 10)),
                Arguments.of(List.of(0, 1, 11)),
                Arguments.of(List.of(0, 5, 11))
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


}