package com.example.kusitsm.subway.Service;

import com.example.kusitsm.subway.Dto.Res.SubwayCodeReturn;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.json.simple.parser.ParseException;
import org.springframework.http.ResponseEntity;

public interface SubwayService {
    SubwayCodeReturn getSubwayCode(String startStation, String endStation) throws JsonProcessingException, ParseException;

    String[] fetch(String url) throws JsonProcessingException, ParseException;



}
