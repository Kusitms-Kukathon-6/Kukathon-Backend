package com.example.kusitsm.subway.Service;


import com.example.kusitsm.subway.Dto.Res.SubwayCodeReturn;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RequiredArgsConstructor
@Service
@Slf4j
public class SubwayServiceImpl implements SubwayService{

    @Value("${code.api.key}")
    private String CODEAPIKEY;
    @Override
    public SubwayCodeReturn getSubwayCode(String startStation, String endStation) throws ParseException, JsonProcessingException {
            //시작 지점
            String startUrl = "http://openAPI.seoul.go.kr:8088/" + CODEAPIKEY + "/json/SearchInfoBySubwayNameService/1/5/"+startStation+"/";
            String[] startCode = fetch(startUrl);
            log.info(startUrl);
            //종료 지점
            String endUrl = "http://openAPI.seoul.go.kr:8088/" + CODEAPIKEY + "/json/SearchInfoBySubwayNameService/1/5/"+endStation+"/";
            String[] endCode = fetch(endUrl);
            log.info(endUrl);

        return null;

    }

    @Override
    public String[] fetch(String url) throws ParseException, JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<?> entity = new HttpEntity<>(new HttpHeaders());
        ResponseEntity<Map> resultMap = restTemplate.exchange(url, HttpMethod.GET, entity, Map.class);
        ObjectMapper mapper = new ObjectMapper();
        String JsonString = mapper.writeValueAsString(resultMap.getBody());
        System.out.println(JsonString);

        JSONObject jsonObject = new JSONObject(JsonString);

        JSONArray jsonArray = jsonObject.getJSONObject("SearchInfoBySubwayNameService").getJSONArray("row");

        String[] stationCdArray = new String[jsonArray.length()];
        for (int i = 0; i < jsonArray.length(); i++) {
            stationCdArray[i] = jsonArray.getJSONObject(i).getString("STATION_CD");
        }
        System.out.println("STATION_CD: " + String.join(", ", stationCdArray));
        return stationCdArray;

    }


}
