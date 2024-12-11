package pairmatching.controller;

import static pairmatching.utils.exception.ErrorMessage.KEY_ERROR;

import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.MatchingResult;
import pairmatching.domain.Mission;
import pairmatching.service.PairService;
import pairmatching.utils.Finder;
import pairmatching.utils.Splitter;
import pairmatching.utils.exception.MatchingException;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairController {

    private final InputView inputView;
    private final OutputView outputView;
    private final PairService pairService;

    public PairController(InputView inputView, OutputView outputView, PairService pairService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.pairService = pairService;
    }

    public void run() {
        while (true) {
            try {
                String input = inputView.askMainFunction();
                if (selectMainFunction(input)) {
                    break; // "Q" 입력 시 종료
                }
            } catch (MatchingException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private boolean selectMainFunction(String input) {
        if (input.equals("1")) {
            startMatching();
            return false;
        }

        if (input.equals("2")) {
            return false;
        }

        if (input.equals("3")) {
            return false;
        }

        if (input.equals("Q")) {
            return true;
        }

        throw new MatchingException(KEY_ERROR);
    }

    private void startMatching() {
        outputView.printCourseAndLevelAndMission();
        String matchingInput = inputView.askCourseAndLevelAndMission();
        String[] matchingValue = Splitter.splitBy(matchingInput, ",");

        if (matchingValue.length != 3) {
            throw new MatchingException(KEY_ERROR);
        }
        Course course = Finder.findCourseByName(matchingValue[0].trim());
        Level level = Finder.findLevelByName(matchingValue[1].trim());
        Mission mission = Finder.findMissionByName(matchingValue[2].trim());

        if (pairService.hasSameMatching(course, level, mission)) {
            if (!checkRematching(inputView.askRematching())) {
                startMatching();
            }
        }
        MatchingResult matchingResult = pairService.getMatchingResult(course, level, mission);

        outputView.printMatchingResult(matchingResult);
    }

    private boolean checkRematching(String input) {
        if (input.equals("네")) {
            return true;
        }

        if (input.equals("아니오")) {
            return false;
        }

        throw new MatchingException(KEY_ERROR);
    }
}
