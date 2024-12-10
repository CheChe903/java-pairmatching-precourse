package pairmatching.controller;

import static pairmatching.domain.Course.BACKEND;
import static pairmatching.domain.Course.FRONTEND;
import static pairmatching.utils.exception.ErrorMessage.KEY_ERROR;

import java.util.ArrayList;
import java.util.List;
import pairmatching.domain.Crew;
import pairmatching.utils.FileReader;
import pairmatching.utils.exception.MatchingException;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class FairController {

    private final InputView inputView;
    private final OutputView outputView;

    public FairController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {

        try {
            String mainInput = inputView.askMainFunction();

            if (mainInput.equals("1")) {
                MatchingManager matchingManager = new MatchingManager(inputView, outputView);
            }

            if (mainInput.equals("2")) {

            }

            if (mainInput.equals("3")) {

            }

            if (mainInput.equals("Q")) {
                return;
            }

            throw new MatchingException(KEY_ERROR);
        } catch (MatchingException e) {
            System.out.println(e.getMessage());
            run();
        }


    }

    private List<Crew> getBackendCrew() {
        String filePath = "src/main/resources/backend-crew.md";
        List<String> crewNames = FileReader.processFile(filePath);
        List<Crew> crews = new ArrayList<>();
        for (String crewName : crewNames) {
            crews.add(new Crew(BACKEND, crewName));
        }
        return crews;
    }

    private List<Crew> getFrontendCrew() {
        String filePath = "src/main/resources/frontend-crew.md";
        List<String> crewNames = FileReader.processFile(filePath);
        List<Crew> crews = new ArrayList<>();
        for (String crewName : crewNames) {
            crews.add(new Crew(FRONTEND, crewName));
        }
        return crews;
    }
}
