package baseball.view;

import baseball.dto.ScoreDto;

public class MessageResolver {

    public String resolveScoreMessage(ScoreDto scoreDto) {
        StringBuilder stbd = new StringBuilder();
        if (scoreDto.getBallCount() == 0 && scoreDto.getStrikeCount() == 0) {
            return "낫싱";
        }
        if (scoreDto.getBallCount() != 0) {
            stbd.append(String.format("%d볼 ", scoreDto.getBallCount()));
        }
        if (scoreDto.getStrikeCount() != 0) {
            stbd.append(String.format("%d스트라이크", scoreDto.getStrikeCount()));
        }
        return stbd.toString();
    }
}
