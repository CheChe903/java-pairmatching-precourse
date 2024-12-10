package pairmatching.utils.exception;

public class MatchingException extends IllegalArgumentException {

    public MatchingException(ErrorMessage message) {
        super(message.toString());
    }
}
