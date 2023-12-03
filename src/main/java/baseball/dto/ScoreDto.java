package baseball.dto;

public class ScoreDto {
    private final int strikeCount;
    private final int ballCount;

    private ScoreDto(int strikeCount, int ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public static ScoreDto of(int strikeCount, int ballCount) {
        return new ScoreDto(strikeCount, ballCount);
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }
}
