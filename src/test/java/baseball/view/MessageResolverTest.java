package baseball.view;

import baseball.dto.ScoreDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("메시지 리졸버 테스트")
class MessageResolverTest {
    private MessageResolver messageResolver;

    @BeforeEach
    void setUp() {
        messageResolver = new MessageResolver();
    }

    @DisplayName("낫싱 출력 테스트")
    @Test
    void testNone() {
        String message = messageResolver.resolveScoreMessage(ScoreDto.of(0, 0));
        assertThat(message).isEqualTo("낫싱");
    }

    @DisplayName("1볼 1스트라이크 테스트")
    @Test
    void testOneBallOneStrike() {
        String message = messageResolver.resolveScoreMessage(ScoreDto.of(1, 1));
        assertThat(message).isEqualTo("1볼 1스트라이크");
    }

    @DisplayName("1볼 테스트")
    @Test
    void testOneBall() {
        String message = messageResolver.resolveScoreMessage(ScoreDto.of(0, 1));
        assertThat(message.trim()).isEqualTo("1볼");
    }

    @DisplayName("1스트라이크 테스트")
    @Test
    void testOneStrike() {
        String message = messageResolver.resolveScoreMessage(ScoreDto.of(1, 0));
        assertThat(message.trim()).isEqualTo("1스트라이크");
    }


}