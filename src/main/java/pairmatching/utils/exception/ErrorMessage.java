package pairmatching.utils.exception;

public enum ErrorMessage {

    FILE_ERROR("파일이 올바르지 않습니다.");

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
