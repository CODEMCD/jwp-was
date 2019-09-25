package http;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HttpHeader {
    private static final String CONTENT_LENGTH_KEY = "Content-Length";
    private static final String CONTENT_EMPTY = "-1";

    private Map<String, String> headers = new HashMap<>();

    public HttpHeader() { }

    public HttpHeader(List<String> headers) {
        for (String header : headers) {
            int delimiter = header.indexOf(":");
            String key = header.substring(0, delimiter);
            String value = header.substring(delimiter + 1);
            this.headers.put(key.trim(), value.trim());
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

    public Set<Map.Entry<String, String>> getHeaders() {
        return headers.entrySet();
    }
}
