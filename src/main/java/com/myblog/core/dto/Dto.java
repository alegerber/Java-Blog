package com.myblog.core.dto;

import org.json.simple.JSONObject;

import java.util.Map;

public interface Dto {

    void addToJsonObject(JSONObject jsonObject);

    Map<String,String> getReplacements();
}
