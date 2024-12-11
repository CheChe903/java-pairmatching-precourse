package pairmatching.utils;

import static pairmatching.utils.exception.ErrorMessage.NOT_EXIST_COURSE;
import static pairmatching.utils.exception.ErrorMessage.NOT_EXIST_LEVEL;

import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;
import pairmatching.utils.exception.MatchingException;

public class Finder {

    public static Course findCourseByName(String name) {
        for (Course course : Course.values()) {
            if (course.getName().equals(name)) {
                return course;
            }
        }
        throw new MatchingException(NOT_EXIST_COURSE);
    }

    public static Level findLevelByName(String name) {
        for (Level level : Level.values()) {
            if (level.getName().equals(name)) {
                return level;
            }
        }
        throw new MatchingException(NOT_EXIST_LEVEL);
    }

    public static Mission findMissionByName(String name) {
        for (Mission mission : Mission.values()) {
            if (mission.getName().equals(name)) {
                return mission;
            }
        }
        throw new MatchingException(NOT_EXIST_COURSE);
    }
}
