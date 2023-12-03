package baseball.config;

import baseball.controller.ComputerNumberController;
import baseball.controller.MainController;
import baseball.controller.ScoreCalculationController;
import baseball.service.RandomBallGenerationService;
import baseball.service.RandomBallsGenerationService;
import baseball.service.ScoreCalculationService;
import baseball.view.InputMapper;
import baseball.view.InputView;
import baseball.view.MessageResolver;
import baseball.view.OutputView;

public class BaseBallGameConfig {

    public ComputerNumberController computerNumberController() {
        return new ComputerNumberController(randomBallsGenerationService());
    }

    public MainController mainController() {
        return new MainController(inputView(), outputView(), computerNumberController(), scoreCalculationController());
    }

    public ScoreCalculationController scoreCalculationController() {
        return new ScoreCalculationController(scoreCalculationService());
    }

    public RandomBallsGenerationService randomBallsGenerationService() {
        return new RandomBallsGenerationService(randomBallGenerationService());
    }

    public RandomBallGenerationService randomBallGenerationService() {
        return new RandomBallGenerationService();
    }

    public ScoreCalculationService scoreCalculationService() {
        return new ScoreCalculationService();
    }

    public OutputView outputView() {
        return new OutputView(messageResolver());
    }

    public InputView inputView() {
        return new InputView(inputMapper());
    }

    public InputMapper inputMapper() {
        return new InputMapper();
    }

    public MessageResolver messageResolver() {
        return new MessageResolver();
    }
}
