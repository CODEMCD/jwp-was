package http;

import http.exception.EmptyStatusException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.DataOutputStream;
import java.io.IOException;

public class HttpResponseSender {
    private static final Logger log = LoggerFactory.getLogger(HttpResponseSender.class);

    public static void send(HttpResponse httpResponse, DataOutputStream dos) {
        if (httpResponse.getStatus() == null) {
            throw new EmptyStatusException();
        }

        try {
            dos.writeBytes(httpResponse.getStatusLine());
            dos.writeBytes(httpResponse.makeHeaderLines());

            byte[] body = httpResponse.getBody();
            if (body != null) {
                dos.write(body, 0, body.length);
            }
            dos.flush();
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }
}
