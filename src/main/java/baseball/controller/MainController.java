package baseball.controller;

import baseball.domain.Balls;
import baseball.domain.ContinueMode;
import baseball.dto.ScoreDto;
import baseball.view.InputView;
import baseball.view.OutputView;

public class MainController {

    private final InputView inputView;
    private final OutputView outputView;
    private final ComputerNumberController computerNumberController;
    private final ScoreCalculationController scoreCalculationController;

    public MainController(InputView inputView, OutputView outputView, ComputerNumberController computerNumberController, ScoreCalculationController scoreCalculationController) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.computerNumberController = computerNumberController;
        this.scoreCalculationController = scoreCalculationController;
    }

    public void run() {
        ContinueMode continueMode = ContinueMode.CONTINUE;
        outputView.printGreetingMessage();

        while (continueMode == ContinueMode.CONTINUE) {
            Balls computerBalls = computerNumberController.generateComputerNumber();
            proceedUntillWin(computerBalls);
            outputView.printWinMessage();
            continueMode = inputView.inputContinueMode();
        }

    }

    private void proceedUntillWin(Balls computerBalls) {
        int strikeCount = 0;
        while (strikeCount != 3) {
            Balls userBalls = inputView.inputBalls();
            ScoreDto scoreDto = scoreCalculationController.calculateScore(userBalls, computerBalls);
            outputView.printResultMessage(scoreDto);
            strikeCount = scoreDto.getStrikeCount();
        }
    }
}
