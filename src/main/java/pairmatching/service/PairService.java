package pairmatching.service;

import static pairmatching.utils.exception.ErrorMessage.FAILED_MATCHING;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.MatchingResult;
import pairmatching.domain.Mission;
import pairmatching.repository.MatchingRepository;
import pairmatching.utils.CrewParser;
import pairmatching.utils.exception.MatchingException;

public class PairService {

    private final MatchingRepository matchingRepository;

    public PairService() {
        this.matchingRepository = new MatchingRepository(new ArrayList<>());
    }

    public boolean hasSameMatching(Course course, Level level, Mission mission) {
        return matchingRepository.findSameResult(new MatchingResult(course, level, mission, new ArrayList<>()));
    }

    public MatchingResult getMatchingResult(Course course, Level level, Mission mission) {
        List<String> crewNames = CrewParser.getCrews(course);

        List<String> shuffledCrews = Randoms.shuffle(crewNames);
        List<List<String>> tempMatchResult = makeMatch(shuffledCrews);
        int count = 3;
        while (matchingRepository.hasSameMatchingResult(tempMatchResult)) {
            count -= 1;
            if (count == 0) {
                throw new MatchingException(FAILED_MATCHING);
            }
            shuffledCrews = Randoms.shuffle(crewNames);
            tempMatchResult = makeMatch(shuffledCrews);
        }
        MatchingResult matchingResult = new MatchingResult(course, level, mission, tempMatchResult);
        matchingRepository.addResult(matchingResult);
        return matchingResult;
    }

    private List<List<String>> makeMatch(List<String> crews) {
        if (crews.size() % 2 == 0) {
            return getEvenMatching(crews);
        }
        return getOddMatching(crews);
    }

    private List<List<String>> getEvenMatching(List<String> crews) {

        List<String> tempCrews = new ArrayList<>();
        List<List<String>> matchingResult = new ArrayList<>();

        for (String crew : crews) {
            tempCrews.add(crew);
            if (tempCrews.size() == 2) {
                matchingResult.add(new ArrayList<>(tempCrews));
                tempCrews.clear();
            }
        }
        return matchingResult;
    }

    private List<List<String>> getOddMatching(List<String> crews) {
        List<String> tempCrews = new ArrayList<>();
        List<List<String>> matchingResult = new ArrayList<>();
        List<String> last = new ArrayList<>();
        for (String crew : crews) {
            tempCrews.add(crew);
            if (tempCrews.size() == 2) {
                matchingResult.add(tempCrews);
                last = tempCrews;
                tempCrews.clear();
            }
        }
        last.add(crews.get(crews.size() - 1));
        matchingResult.add(last);
        return matchingResult;
    }


}
