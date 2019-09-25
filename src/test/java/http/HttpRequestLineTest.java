package http;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class HttpRequestLineTest {

    @Test
    void 시작줄_정상_생성() {
        assertDoesNotThrow(() ->
                new HttpRequestLine(HttpMethod.GET, new HttpUri("/index.html"), HttpVersion.V_1_1));
    }
}
