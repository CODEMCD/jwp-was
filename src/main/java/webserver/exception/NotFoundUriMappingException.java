package webserver.exception;

public class NotFoundUriMappingException extends RuntimeException {
    private static final String NOT_FOUND_URI_MAPPING_EXCEPTION_MESSAGE = "찾을 수 없는 URI 입니다.";

    public NotFoundUriMappingException() {
        super(NOT_FOUND_URI_MAPPING_EXCEPTION_MESSAGE);
    }
}
