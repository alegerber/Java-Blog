package com.myblog.core.http;

import com.myblog.config.ApplicationConfig;
import com.myblog.core.dto.Dto;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TemplateResponse implements Response {
    Dto[] dtos;
    String templateName;
    String content;

    public TemplateResponse(String templateName) {
        this.templateName = templateName;
    }

    public TemplateResponse(String templateName, Dto[] dtos) {
        this.templateName = templateName;
        this.dtos         = dtos;
    }

    public String toString() {
        Path filepath = ApplicationConfig.getConfigPath("template").resolve(this.templateName);

        try {
            this.content = Files.readString(filepath);

            for (Dto dto: this.dtos) {
                dto.getReplacements().forEach((key, value) -> {
                    this.content = this.content.replace(key, value);
                });
            }

        } catch (IOException e) {
            e.printStackTrace();
            content = e.getMessage();
        }

        return content;
    }
}