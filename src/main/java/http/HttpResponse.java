package http;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class HttpResponse {
    private static final Logger log = LoggerFactory.getLogger(HttpResponse.class);
    private static final String CRLF = "\r\n";
    private static final String CONTENT_TYPE_KEY = "Content-Type";
    private static final String LOCATION_KEY = "Location";
    private static final int OK_CODE = 200;
    private static final int FOUND_CODE = 302;

    private HttpStatus status;
    private HttpHeader header = new HttpHeader();
    private byte[] body;

    public HttpResponse() {
    }

    public void response2xx(byte[] body, HttpRequest httpRequest) {
        setStatus(OK_CODE);
        addHeader(CONTENT_TYPE_KEY, MimeType.of(httpRequest.getUri()));
        setBody(body);
    }

    public void response3xx(String viewName) {
        setStatus(FOUND_CODE);
        addHeader(LOCATION_KEY, "/" + viewName);
    }

    public void setStatus(int statusCode) {
        status = HttpStatus.of(statusCode);
    }

    public void addHeader(String key, String value) {
        header.addHeader(key, value);
    }

    public void setBody(byte[] body) {
        this.body = body;
        header.addHeader(CONTENT_TYPE_KEY, String.valueOf(body.length));
    }

    public String makeHeaderLines() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> header : header.getHeaders()) {
            sb.append(header.getKey() + ": " + header.getValue() + CRLF);
        }
        sb.append(CRLF);

        return sb.toString();
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
