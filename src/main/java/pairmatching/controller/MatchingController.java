package pairmatching.controller;

import static pairmatching.domain.Course.BACKEND;
import static pairmatching.domain.Course.FRONTEND;

import java.util.ArrayList;
import java.util.List;
import pairmatching.domain.Crew;
import pairmatching.utils.FileReader;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class MatchingController {

    private final InputView inputView;
    private final OutputView outputView;

    public MatchingController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {

        List<Crew> backendCrews = getBackendCrew();
        List<Crew> frontendCrews = getFrontendCrew();


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
