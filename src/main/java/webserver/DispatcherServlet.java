package webserver;

import controller.Controller;
import http.HttpRequest;
import http.HttpResponse;
import view.View;
import view.ViewResolver;

import java.io.IOException;
import java.net.URISyntaxException;

public class DispatcherServlet {
    public static void doDispatch(HttpRequest httpRequest, HttpResponse httpResponse)
            throws IOException, URISyntaxException {
        if (httpRequest.isStaticRequest()) {
            handleStaticRequest(httpRequest, httpResponse);
            return;
        }

        Controller controller = HandlerMapping.handle(httpRequest);
        View view = controller.service(httpRequest, httpResponse);
        httpResponse.setBody(ViewResolver.resolve(view.getViewName()));
        view.render(httpRequest, httpResponse);
    }

    private static void handleStaticRequest(HttpRequest httpRequest, HttpResponse httpResponse)
            throws IOException, URISyntaxException {
        byte[] body = ViewResolver.resolve(httpRequest.getUri());
        httpResponse.response2xx(body, httpRequest);
    }
}
