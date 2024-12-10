package pairmatching.domain;

import static pairmatching.utils.exception.ErrorMessage.NOT_HAVE_RESULT;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import pairmatching.domain.dto.ResultDTO;
import pairmatching.utils.exception.MatchingException;

public class MatchingResult {

    private static final List<Result> results = new ArrayList<>();

    public static List<Result> results() {
        return Collections.unmodifiableList(results);
    }

    public static boolean hasEqualResult(ResultDTO resultDTO) {
        for (Result result : results) {
            if (result.hasEqualResult(resultDTO)) {
                return true;
            }
        }
        return false;
    }

    public static void addResult(Result result) {
        results.add(result);
    }

    public static void deleteResult(ResultDTO resultDTO) {
        for (Result result : results) {
            if (result.hasEqualResult(resultDTO)) {
                results.remove(result);
            }
        }
        throw new MatchingException(NOT_HAVE_RESULT);
    }
}
