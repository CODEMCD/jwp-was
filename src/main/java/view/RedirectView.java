package view;

import http.HttpRequest;
import http.HttpResponse;

public class RedirectView implements View {
    private String viewName;

    public RedirectView(String viewName) {
        this.viewName = viewName;
    }

    @Override
    public void render(HttpRequest httpRequest, HttpResponse httpResponse) {
        httpResponse.response3xx(viewName);
    }

    @Override
    public String getViewName() {
        return viewName;
    }
}
