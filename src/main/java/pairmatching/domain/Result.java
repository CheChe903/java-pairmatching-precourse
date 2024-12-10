package pairmatching.domain;

import java.util.List;
import pairmatching.domain.Level.Mission;
import pairmatching.domain.dto.ResultDTO;

public class Result {

    private final Course course;
    private final Level level;
    private final Mission mission;
    private final List<Fair> fairs;

    public Result(Course course, Level level, Mission mission, List<Fair> fairs) {
        this.course = course;
        this.level = level;
        this.mission = mission;
        this.fairs = fairs;
    }

    public boolean hasEqualResult(ResultDTO resultDTO) {
        return resultDTO.getCourse().equals(course) && resultDTO.getLevel().equals(level) && resultDTO.getMission()
                .equals(mission);
    }

}
