package pairmatching.repository;

import java.util.Collections;
import java.util.List;
import pairmatching.domain.MatchingResult;

public class MatchingRepository {

    private final List<MatchingResult> matchingResults;

    public MatchingRepository(List<MatchingResult> matchingResults) {
        this.matchingResults = matchingResults;
    }

    public List<MatchingResult> getMatchingResults() {
        return Collections.unmodifiableList(matchingResults);
    }

    public void addResult(MatchingResult matchingResult) {
        matchingResults.add(matchingResult);
    }

    public boolean findSameResult(MatchingResult currentMatchingResult) {
        for (MatchingResult matchingResult : matchingResults) {
            if (matchingResult.equals(currentMatchingResult)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasSameMatchingResult(List<List<String>> shuffledCrews) {
        for (MatchingResult matchingResult : matchingResults) {
            if (matchingResult.hasSameCrew(shuffledCrews)) {
                return true;
            }
        }

        return false;
    }
}
