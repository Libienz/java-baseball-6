package baseball.view;

import baseball.domain.Ball;
import baseball.domain.Balls;
import baseball.domain.ContinueMode;

public class InputMapper {
    public Balls mapToBalls(String input) {
        return new Balls(input.chars()
                .mapToObj(c -> new Ball(c - 48))
                .toList());
    }

    public ContinueMode mapToContinueMode(String input) {
        return ContinueMode.from(parseToInt(input));
    }

    public Integer parseToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
