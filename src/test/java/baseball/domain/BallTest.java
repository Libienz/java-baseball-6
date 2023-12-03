package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("유저 추측 개별 값 테스트")
class BallTest {

    @DisplayName("범위에 벗어나는 숫자는 생성 시 검증에 실패한다")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 10, 11})
    void testValidationFailWithInvalidRangeNumber(int number) {
        assertThatThrownBy(() -> new Ball(number))
                .isInstanceOf(IllegalArgumentException.class);
    }
}