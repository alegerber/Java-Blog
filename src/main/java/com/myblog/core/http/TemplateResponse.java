package com.myblog.core.http;

import com.myblog.config.ApplicationConfig;
import com.myblog.core.dto.Dto;
//import org.apache.commons.text.StringEscapeUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class TemplateResponse implements Response {
    Map<String, Dto> dtos = new HashMap<>();
    String templateName;
    String content;

    public TemplateResponse(String templateName) {
        this.templateName = templateName;
    }

    public TemplateResponse(String templateName, Map<String, Dto> dtos) {
        this.templateName = templateName;
        this.dtos         = dtos;
    }

    public String toString() {
        Path filepath = ApplicationConfig.getConfigPath(templateName, ApplicationConfig.HTML_TEMPLATE);

        try {
            this.content = Files.readString(filepath);

            this.dtos.forEach((index, dto) -> {
                dto.getReplacements().forEach((key, value) -> {
                    this.content = this.content.replace(key, value);
                });
            });

            //this.content = StringEscapeUtils.escapeHtml4(this.content);
        } catch (IOException e) {
            e.printStackTrace();
            this.content = e.getMessage();
        }

        return this.content;
    }
}
