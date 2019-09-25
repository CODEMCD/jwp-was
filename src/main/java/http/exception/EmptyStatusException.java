package http.exception;

public class EmptyStatusException extends RuntimeException {
    private static final String EMPTY_STATUS_EXCEPTION_MESSAGE = "Status Code 가 비어있습니다.";

    public EmptyStatusException() {
        super(EMPTY_STATUS_EXCEPTION_MESSAGE);
    }
}
