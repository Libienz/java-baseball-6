package baseball.dto;

public class ScoreDto {
    private final int strikeCount;
    private final int ballCount;

    public ScoreDto(int strikeCount, int ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }
}
