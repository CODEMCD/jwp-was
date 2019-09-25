package http;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HttpHeaderTest {
    @Test
    void 헤더_정상_생성() {
        List<String> headerLines = Arrays.asList(
                "Host: localhost:8080",
                "Connection: keep-alive",
                "Accept: */*");
        assertDoesNotThrow(() -> new HttpHeader(headerLines));
    }

    @Test
    void Body_있는_헤더() {
        List<String> headerLinesWithBody = Arrays.asList(
                "Host: localhost:8080",
                "Connection: keep-alive",
                "Content-Length: 59",
                "Content-Type: application/x-www-form-urlencoded",
                "Accept: */*");

        HttpHeader httpHeader = new HttpHeader(headerLinesWithBody);
        assertEquals(httpHeader.getContentLength(), 59);
    }

    @Test
    void Body_없는_헤더() {
        List<String> headerLinesWithoutBody = Arrays.asList(
                "Host: localhost:8080",
                "Connection: keep-alive",
                "Accept: */*");

        HttpHeader httpHeader = new HttpHeader(headerLinesWithoutBody);
        assertEquals(httpHeader.getContentLength(), -1);
    }
}
