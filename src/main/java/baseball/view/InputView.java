package baseball.view;

import baseball.domain.Balls;
import baseball.domain.ContinueMode;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_BALLS_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String INPUT_CONTINUE_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private final InputMapper inputMapper;

    public InputView(InputMapper inputMapper) {
        this.inputMapper = inputMapper;
    }

    public Balls inputBalls() {
        System.out.print(INPUT_BALLS_MESSAGE);
        return inputMapper.mapToBalls(Console.readLine());
    }

    public ContinueMode inputContinueMode() {
        System.out.println(INPUT_CONTINUE_MESSAGE);
        return inputMapper.mapToContinueMode(Console.readLine());
    }
}
