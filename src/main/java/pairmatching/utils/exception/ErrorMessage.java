package pairmatching.utils.exception;

public enum ErrorMessage {

    FILE_ERROR("파일이 올바르지 않습니다."),
    KEY_ERROR("잘못된 입력입니다."),
    NOT_HAVE_RESULT("매칭 정보가 없습니다."),
    FAILED_MATCHING("매칭이 불가능합니다."),
    NOT_EXIST_COURSE("과정 정보가 없습니다."),
    NOT_EXIST_LEVEL("레벨 정보가 없습니다."),
    NOT_EXIST_MISSION("미션 정보가 없습니다."),
    HOW("Asd");

    private static final String PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return PREFIX + message;
    }
}
