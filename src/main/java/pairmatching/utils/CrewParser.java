package pairmatching.utils;

import static pairmatching.utils.exception.ErrorMessage.NOT_EXIST_COURSE;

import java.util.ArrayList;
import java.util.List;
import pairmatching.domain.Course;
import pairmatching.utils.exception.MatchingException;

public class CrewParser {

    private static final String BACKENDFILEPATH = "/backend-crew.md";
    private static final String FRONTENDFILEPATH = "/frontend-crew.md";


    public static List<String> getCrews(Course course) {
        if (course == Course.BACKEND) {
            return getBackendCrew();
        }

        if (course == Course.FRONTEND) {
            return getFrontendCrew();
        }
        throw new MatchingException(NOT_EXIST_COURSE);
    }

    private static List<String> getBackendCrew() {
        List<String> names = FileReader.processFile(BACKENDFILEPATH);
        List<String> backendCrews = new ArrayList<>();
        backendCrews.addAll(names);
        return backendCrews;
    }

    private static List<String> getFrontendCrew() {
        List<String> names = FileReader.processFile(FRONTENDFILEPATH);
        List<String> frontendCrews = new ArrayList<>();
        frontendCrews.addAll(names);
        return frontendCrews;
    }
}
