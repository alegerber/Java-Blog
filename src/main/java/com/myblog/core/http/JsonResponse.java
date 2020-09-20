package com.myblog.core.http;

import org.json.simple.JSONObject;
import com.myblog.core.dto.Dto;

public class JsonResponse implements Response {
    Dto[] dtos;

    public JsonResponse(Dto[] dtos) {
        this.dtos = dtos;
    }

    public String toString() {
        JSONObject jsonObject = new JSONObject();

        for (Dto dto: dtos) {
            dto.addToJsonObject(jsonObject);
        }

        return jsonObject.toJSONString();
    }
}
