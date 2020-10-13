package com.myblog.config;

import com.myblog.app.exception.ConfigTypeNotFoundException;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class ApplicationConfig {

    public static final String HTML_TEMPLATE = "html_template";

    public static Path getApplicationPath() {
        return Paths.get("");
    }

    public static Path getMainPath() {
        return ApplicationConfig.getApplicationPath().resolve("src/main/");
    }

    public static String getConfig(String key) {
        Map<String, String> obj = new HashMap<String,String>();

        obj.put("template", "resources/template");
        obj.put("home", "home");

        return obj.get(key);
    }

    public static Path getConfigPath(String key, String type) {
        String value = ApplicationConfig.getConfig(key);
        String path;

        switch(type) {
            case HTML_TEMPLATE:
                path = ApplicationConfig.getConfig("template") + "/" + value + ".html";
                break;
            default:
                throw new ConfigTypeNotFoundException(type);
        }

        return ApplicationConfig
                .getMainPath()
                .resolve(path);
    }
}
