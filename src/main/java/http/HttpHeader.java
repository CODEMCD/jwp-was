package http;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HttpHeader {
    private static final String CONTENT_LENGTH_KEY = "Content-Length";
    private static final String CONTENT_EMPTY = "-1";
    private static final String CRLF = "\r\n";

    private Map<String, String> headers = new HashMap<>();

    public HttpHeader() {
    }

    public HttpHeader(List<String> headers) {
        for (String header : headers) {
            int delimiter = header.indexOf(":");
            String key = header.substring(0, delimiter);
            String value = header.substring(delimiter + 1);
            this.headers.put(key.trim(), value.trim());
        }

        if (this.headers.get("Cookie") != null) {

        }
    }

    public String getValue(String key) {
        return headers.get(key);
    }

    public int getContentLength() {
        return Integer.parseInt(headers.getOrDefault(CONTENT_LENGTH_KEY, CONTENT_EMPTY));
    }

    public void addHeader(String key, String value) {
        headers.put(key, value);
    }

    public Map<String, String> getHeaders() {
        return Collections.unmodifiableMap(headers);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> header : headers.entrySet()) {
            sb.append(header.getKey() + ": " + header.getValue() + CRLF);
        }
        sb.append(CRLF);

        return sb.toString();
    }
}
