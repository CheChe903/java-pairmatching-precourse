package pairmatching.controller;

import static pairmatching.utils.exception.ErrorMessage.KEY_ERROR;

import pairmatching.utils.Splitter;
import pairmatching.utils.exception.MatchingException;
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
        String[] userInput = Splitter.splitBy(inputView.askCourseAndLevelAndMission(), ",");

        if (userInput.length != 3) {
            throw new MatchingException(KEY_ERROR);
        }

    }
}
