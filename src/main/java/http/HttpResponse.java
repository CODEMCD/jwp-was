package http;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpResponse {
    private static final Logger log = LoggerFactory.getLogger(HttpResponse.class);
    private static final String CRLF = "\r\n";
    private static final String CONTENT_TYPE_KEY = "Content-Type";
    private static final String CONTENT_LENGTH_KEY = "Content-Length";
    private static final String LOCATION_KEY = "Location";
    private static final int OK_CODE = 200;
    private static final int FOUND_CODE = 302;

    private HttpStatus status;
    private HttpHeader header = new HttpHeader();
    private byte[] body;

    public HttpResponse() {
    }

    public void response2xx(byte[] body, String mimeType) {
        setStatus(OK_CODE);
        addHeader(CONTENT_TYPE_KEY, mimeType);
        setBody(body);
    }

    public void response3xx(String viewName) {
        setStatus(FOUND_CODE);
        addHeader(LOCATION_KEY, "/" + viewName);
    }

    private void setStatus(int statusCode) {
        status = HttpStatus.of(statusCode);
    }

    private void addHeader(String key, String value) {
        header.addHeader(key, value);
    }

    private void setBody(byte[] body) {
        this.body = body;
        header.addHeader(CONTENT_LENGTH_KEY, String.valueOf(body.length));
    }

    public String makeHeaderLines() {
        return header.toString();
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getStatusLine() {
        return HttpVersion.V_1_1.getVersion() + " " +
                status.getStatusCode() + " " +
                status.getStatus() +
                CRLF;
    }

    public byte[] getBody() {
        return body;
    }
}
