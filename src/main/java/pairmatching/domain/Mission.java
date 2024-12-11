package pairmatching.domain;

public enum Mission {
    자동차경주("자동차경주"),
    로또("로또"),
    숫자야구게임("숫자야구게임"),
    장바구니("장바구니"),
    결제("결제"),
    지하철노선도("지하철노선도"),
    성능개선("성능개선"),
    배포("배포");

    private final String name;

    Mission(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
