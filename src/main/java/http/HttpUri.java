package http;

import http.exception.EmptyUriException;

import static http.QueryString.QUERY_STRING_DELIMITER;

public class HttpUri {
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
