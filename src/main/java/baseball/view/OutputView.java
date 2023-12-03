package baseball.view;

import baseball.dto.ScoreDto;

public class OutputView {
    private static final String GREETING_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String WIN_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    private final MessageResolver messageResolver;

    public OutputView(MessageResolver messageResolver) {
        this.messageResolver = messageResolver;
    }

    public void printGreetingMessage() {
        System.out.println(GREETING_MESSAGE);
    }

    public void printResultMessage(ScoreDto scoreDto) {
        System.out.println(messageResolver.resolveScoreMessage(scoreDto));
    }

    public void printWinMessage() {
        System.out.println(WIN_MESSAGE);
    }
}
