package pairmatching.domain;

import static pairmatching.domain.Level.Mission.결제;
import static pairmatching.domain.Level.Mission.로또;
import static pairmatching.domain.Level.Mission.배포;
import static pairmatching.domain.Level.Mission.성능개선;
import static pairmatching.domain.Level.Mission.숫자야구게임;
import static pairmatching.domain.Level.Mission.자동차경주;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Level {
    LEVEL1("레벨1", new ArrayList<>(Arrays.asList(자동차경주, 로또, 숫자야구게임))),
    LEVEL2("레벨2", new ArrayList<>(Arrays.asList(Mission.장바구니, 결제, Mission.지하철노선도))),
    LEVEL3("레벨3", new ArrayList<>()),
    LEVEL4("레벨4", new ArrayList<>(Arrays.asList(성능개선, 배포))),
    LEVEL5("레벨5", new ArrayList<>());

    private String name;
    private List<Mission> missions;

    Level(String name, List<Mission> missions) {
        this.name = name;
        this.missions = missions;
    }

    public String getName() {
        return name;
    }

    public enum Mission {
        자동차경주,
        로또,
        숫자야구게임,
        장바구니,
        결제,
        지하철노선도,
        성능개선,
        배포;

        private String name;

        public String getName() {
            return name;
        }
    }
}
