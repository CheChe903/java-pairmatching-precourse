package pairmatching.controller;

import static pairmatching.utils.exception.ErrorMessage.KEY_ERROR;

import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.Level.Mission;
import pairmatching.domain.MatchingResult;
import pairmatching.domain.dto.ResultDTO;
import pairmatching.utils.Finder;
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

        Course course = Finder.findCourseByName(userInput[0]);
        Level level = Finder.findLevelByName(userInput[1]);
        Mission mission = Finder.findMissionByName(userInput[2]);

        if (MatchingResult.hasEqualResult(new ResultDTO(course, level, mission))) {
            String input = inputView.askRematching();

            if (input.equals("아니오")) {
                matching();
            }

            if (!input.equals("네")) {
                throw new MatchingException(KEY_ERROR);
            }

            MatchingResult.deleteResult(new ResultDTO(course, level, mission));
        }


    }
}
