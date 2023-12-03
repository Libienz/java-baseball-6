package baseball.view;

import baseball.domain.Ball;
import baseball.domain.Balls;
import baseball.domain.ContinueMode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("입력 변환기 테스트")
class InputMapperTest {
    private InputMapper inputMapper;

    @BeforeEach
    void setUp() {
        inputMapper = new InputMapper();
    }

    @DisplayName("숫자가 아닌 값을 숫자로 변환 시도시 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"a", "b", "1c"})
    void testParseToInt(String input) {
        assertThatThrownBy(() -> inputMapper.parseToInt(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("추측값 문자열을 Balls로 매핑할 수 있다")
    @Test
    void testMapToBalls() {
        String input = "123";
        Balls balls = inputMapper.mapToBalls(input);
        Balls target = new Balls(List.of(new Ball(1), new Ball(2), new Ball(3)));
        assertThat(balls.countSameBallWithSameOrder(target)).isEqualTo(3);
    }

    @DisplayName("게임 재시작 모드 넘버로 매핑할 수 있다")
    @Test
    void testMapToContinueMode() {
        String input = "1";
        ContinueMode continueMode = inputMapper.mapToContinueMode(input);
        assertThat(continueMode).isEqualTo(ContinueMode.from(1));
    }
}