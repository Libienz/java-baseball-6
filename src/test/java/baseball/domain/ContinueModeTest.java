package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("게임 재시작 모드 넘버 테스트")
class ContinueModeTest {

    @DisplayName("1또는 2의 값이 아니면 오류가 발생한다")
    @ParameterizedTest
    @ValueSource(ints = {0, 3, 4, 5, 6})
    void testInvalidModeNumber(int modeNumber) {
        assertThatThrownBy(() -> ContinueMode.from(modeNumber)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("올바른 모드 값은 오류가 발생하지 않는다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2})
    void testValidModeNumber(int modeNumber) {
        assertThatNoException().isThrownBy(() -> ContinueMode.from(modeNumber));
    }
}