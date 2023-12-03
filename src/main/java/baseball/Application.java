package baseball;

import baseball.config.BaseBallGameConfig;

public class Application {
    public static void main(String[] args) {
        BaseBallGameConfig baseBallGameConfig = new BaseBallGameConfig();
        baseBallGameConfig.mainController().run();
    }
}
