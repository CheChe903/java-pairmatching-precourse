package pairmatching.utils;

import static pairmatching.utils.exception.ErrorMessage.KEY_ERROR;

import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.Level.Mission;
import pairmatching.utils.exception.MatchingException;

public class Finder {

    public static Course findCourseByName(String name) {

        for (Course course : Course.values()) {
            if (course.getName().equals(name)) {
                return course;
            }
        }
        throw new MatchingException(KEY_ERROR);
    }

    public static Level findLevelByName(String name) {

        for (Level level : Level.values()) {
            if (level.getName().equals(name)) {
                return level;
            }
        }
        throw new MatchingException(KEY_ERROR);
    }

    public static Mission findMissionByName(String name) {

        for (Mission mission : Mission.values()) {
            if (mission.getName().equals(name)) {
                return mission;
            }
        }
        throw new MatchingException(KEY_ERROR);
    }


}
