package com.example.kusitsm.subway.Service;

import com.example.kusitsm.subway.Dto.Res.RouteInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.json.simple.parser.ParseException;

public interface SubwayService {
    RouteInfo getSubwayCode(String startStation, String endStation) throws Exception;
    String[] fetch(String url) throws JsonProcessingException, ParseException;
}