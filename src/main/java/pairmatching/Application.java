package pairmatching;

import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        FairController fairController = new FairController(inputView, outputView);

        fairController.run();
    }
}
