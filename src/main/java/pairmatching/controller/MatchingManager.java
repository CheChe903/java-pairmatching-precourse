package pairmatching.controller;

import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class MatchingManager {

    private final InputView inputView;
    private final OutputView outputView;

    public MatchingManager(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }


    public void matching() {
        outputView.printCourseAndLevelAndMission();
    }
}
