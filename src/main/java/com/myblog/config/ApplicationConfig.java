package com.myblog.config;

import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class ApplicationConfig {
    public static Path getApplicationPath() {
        return Paths.get("").getParent();
    }

    public static String getConfig(String key) {
        Yaml yaml = new Yaml();
        InputStream inputStream = ApplicationConfig.class
                .getClassLoader()
                .getResourceAsStream(
                        ApplicationConfig
                        .getApplicationPath()
                        .toAbsolutePath()
                        .toString()
                        .concat("resources/config/application_config.yaml")
                );

        Map<String, Object> obj = yaml.load(inputStream);
        System.out.println(obj);
        return (String) obj.get(key);
    }

    public static Path getConfigPath(String key) {
        return ApplicationConfig
                .getApplicationPath()
                .resolve(ApplicationConfig.getConfig(key));
    }
}
