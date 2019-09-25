package view;

import utils.FileIoUtils;

import java.io.IOException;
import java.net.URISyntaxException;

public class ViewResolver {
    private static final String TEMPLATES_PATH = "./templates/";
    private static final String STATIC_PATH = "./static/";

    public static byte[] resolve(String viewName) throws IOException, URISyntaxException {
        String path = TEMPLATES_PATH + viewName;
        if (FileIoUtils.isExistFile(path)) {
            return FileIoUtils.loadFileFromClasspath(path);
        }

        return FileIoUtils.loadFileFromClasspath(STATIC_PATH + viewName);
    }
}