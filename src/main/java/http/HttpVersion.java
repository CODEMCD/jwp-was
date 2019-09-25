package http;

import http.exception.NotFoundVersionException;

import java.util.Arrays;

public enum HttpVersion {
    V_1_1(1.1, "HTTP/1.1");

    private Double versionNumber;
    private String version;

    HttpVersion(Double versionNumber, String version) {
        this.versionNumber = versionNumber;
        this.version = version;
    }

    public static HttpVersion of(String version) {
        String[] versionTokens = version.split("\\/");
        Double versionTokenNumber = Double.parseDouble(versionTokens[1]);
        return Arrays.stream(HttpVersion.values())
                .filter(httpVersion -> httpVersion.versionNumber.equals(versionTokenNumber))
                .findAny()
                .orElseThrow(NotFoundVersionException::new)
                ;
    }

    public String getVersion() {
        return version;
    }
}
