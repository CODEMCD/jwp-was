package view;

import http.HttpRequest;
import http.HttpResponse;
import http.MimeType;

public class ModelAndView implements View {
    private String viewName;

    public ModelAndView(String viewName) {
        this.viewName = viewName;
    }

    @Override
    public void render(HttpRequest httpRequest, HttpResponse httpResponse) {
        httpResponse.response2xx("".getBytes(), MimeType.of(httpRequest.getUri()));
    }

    @Override
    public String getViewName() {
        return viewName;
    }
}
