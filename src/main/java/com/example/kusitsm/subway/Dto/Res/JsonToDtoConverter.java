package com.example.kusitsm.subway.Dto.Res;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonToDtoConverter {
    public static RouteInfo convertJsonToDto(String jsonString) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(jsonString, RouteInfo.class);
    }
}
