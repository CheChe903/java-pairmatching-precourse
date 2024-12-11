package pairmatching.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class MatchingResult {

    private final Course course;
    private final Level level;
    private final Mission mission;
    private final List<List<String>> crews;

    public MatchingResult(Course course, Level level, Mission mission, List<List<String>> crews) {
        this.course = course;
        this.level = level;
        this.mission = mission;
        this.crews = crews;
    }


    public boolean hasSameCrew(List<List<String>> shuffledCrews) {
        if (this.crews.size() != shuffledCrews.size()) {
            return false;
        }
        List<List<String>> remainingCrews = new ArrayList<>(this.crews);

        for (List<String> shuffledGroup : shuffledCrews) {
            boolean groupFound = false;

            for (List<String> currentGroup : remainingCrews) {
                if (currentGroup.size() == shuffledGroup.size() &&
                        new HashSet<>(currentGroup).containsAll(shuffledGroup)) {
                    remainingCrews.remove(currentGroup);
                    groupFound = true;
                    break;
                }
            }

            if (!groupFound) {
                return false;
            }
        }

        return true;
    }

    public List<List<String>> getCrews() {
        return crews;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MatchingResult that = (MatchingResult) o;
        return course == that.course &&
                level == that.level &&
                mission == that.mission;
    }

    @Override
    public int hashCode() {
        return Objects.hash(course, level, mission);
    }
}
