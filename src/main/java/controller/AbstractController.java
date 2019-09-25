package controller;

import http.HttpMethod;
import http.HttpRequest;
import http.HttpResponse;
import view.View;

public abstract class AbstractController implements Controller {

    @Override
    public View service(HttpRequest httpRequest, HttpResponse httpResponse) {
        if (httpRequest.getMethod().equals(HttpMethod.GET)) {
            return doGet(httpRequest, httpResponse);
        }

        return doPost(httpRequest, httpResponse);
    }

    public abstract View doGet(HttpRequest httpRequest, HttpResponse httpResponse);

    public abstract View doPost(HttpRequest httpRequest, HttpResponse httpResponse);
}
