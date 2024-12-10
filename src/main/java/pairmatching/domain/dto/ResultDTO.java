package pairmatching.domain.dto;

import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.Level.Mission;

public class ResultDTO {

    private final Course course;
    private final Level level;
    private final Mission mission;

    public ResultDTO(Course course, Level level, Mission mission) {
        this.course = course;
        this.level = level;
        this.mission = mission;
    }

    public Course getCourse() {
        return course;
    }

    public Level getLevel() {
        return level;
    }

    public Mission getMission() {
        return mission;
    }
}
