package http;

import http.exception.EmptyUriException;

public class HttpUri {
    private final String uri;

    public HttpUri(String uri) {
        if ("".equals(uri) || uri == null) {
            throw new EmptyUriException();
        }

        this.uri = uri;
    }
}
