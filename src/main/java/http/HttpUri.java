package http;

import http.exception.EmptyUriException;

public class HttpUri {
    private static final String QUERY_STRING_DELIMITER = "?";

    private final String uri;

    public HttpUri(String uri) {
        if ("".equals(uri) || uri == null) {
            throw new EmptyUriException();
        }

        this.uri = uri;
    }

    public boolean addQueryString(QueryString queryString) {
        if (!uri.contains(QUERY_STRING_DELIMITER)) {
            return false;
        }

        String[] uriTokens = uri.split("\\" + QUERY_STRING_DELIMITER);
        queryString.add(uriTokens[1]);
        return true;
    }
}
