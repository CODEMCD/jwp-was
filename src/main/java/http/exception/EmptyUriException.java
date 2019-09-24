package http.exception;

public class EmptyUriException extends RuntimeException {
    private static final String EMPTY_URI_EXCEPTION_MESSAGE = "Uri 가 비어 있습니다";

    public EmptyUriException() {
        super(EMPTY_URI_EXCEPTION_MESSAGE);
    }
}
