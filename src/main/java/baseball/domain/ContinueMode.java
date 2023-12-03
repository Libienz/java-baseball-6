package baseball.domain;

import java.util.Arrays;

public enum ContinueMode {
    CONTINUE(1),
    STOP(2);

    private int modeNumber;

    ContinueMode(int modeNumber) {
        this.modeNumber = modeNumber;
    }

    public static ContinueMode from(int modeNumber) {
        return Arrays.stream(ContinueMode.values())
                .filter(mode -> modeNumber == mode.modeNumber)
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }
}
