package com.myblog.core.http;

import org.json.simple.JSONObject;
import com.myblog.core.dto.Dto;
import java.util.Map;

public class JsonResponse implements Response {
    Map<String, Dto> dtos;

    public JsonResponse(Map<String, Dto> dtos ) {
        this.dtos = dtos;
    }

    public String toString() {
        JSONObject jsonObject = new JSONObject();

        this.dtos.forEach((index, dto) -> {
            dto.addToJsonObject(jsonObject);
        });


        return jsonObject.toJSONString();
    }
}
