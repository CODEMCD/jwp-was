package view;

import http.HttpRequest;
import http.HttpResponse;
import http.MimeType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import webserver.RequestHandler;

import java.io.IOException;
import java.net.URISyntaxException;

public class ModelAndView implements View {
    private static final Logger logger = LoggerFactory.getLogger(RequestHandler.class);

    private String viewName;

    public ModelAndView(String viewName) {
        this.viewName = viewName;
    }

    @Override
    public void render(HttpRequest httpRequest, HttpResponse httpResponse) {
        try {
            httpResponse.response2xx(ViewResolver.resolve(viewName),
                    MimeType.of(viewName));
        } catch (IOException | URISyntaxException e) {
            logger.error(e.getMessage());
        }
    }

    @Override
    public String getViewName() {
        return viewName;
    }
}
