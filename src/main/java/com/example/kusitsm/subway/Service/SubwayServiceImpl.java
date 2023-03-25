package com.example.kusitsm.subway.Service;

import com.example.kusitsm.subway.Dto.Res.JsonToDtoConverter;
import com.example.kusitsm.subway.Dto.Res.RouteInfo;
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

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.util.Map;
import java.net.URL;

@RequiredArgsConstructor
@Service
@Slf4j
public class SubwayServiceImpl implements SubwayService{
    public String firstStartCode;
    public String firstEndCode;
    @Value("${code.api.key}")
    private String CODEAPIKEY;
    @Override
    public RouteInfo getSubwayCode(String startStation, String endStation) throws Exception {
        //시작 지점
        String startUrl = "http://openAPI.seoul.go.kr:8088/" + CODEAPIKEY + "/json/SearchInfoBySubwayNameService/1/5/"+startStation+"/";
        String[] startCode = fetch(startUrl);
        firstStartCode = startCode[1];
        log.info(startUrl);
        //종료 지점
        String endUrl = "http://openAPI.seoul.go.kr:8088/" + CODEAPIKEY + "/json/SearchInfoBySubwayNameService/1/5/"+endStation+"/";
        String[] endCode = fetch(endUrl);
        firstEndCode = endCode[0];
        log.info(endUrl);
        getRouteCode(firstStartCode, firstEndCode);

        return getRouteCode(firstStartCode, firstEndCode);
    }

    @Value("${code.routeApi.key}")
    private String ROUTEKEY;
    public RouteInfo getRouteCode(String firstStartCode, String firstEndCode) throws Exception {

        String urlInfo = "https://api.odsay.com/v1/api/subwayPath?lang=0&CID=1000&SID="+firstStartCode+"&EID="+firstEndCode+"&Sopt=2&apiKey=" + URLEncoder.encode(ROUTEKEY, "UTF-8");

        URL url = new URL(urlInfo);
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");

        BufferedReader bufferedReader =
                new BufferedReader(new InputStreamReader(conn.getInputStream()));

        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            sb.append(line);
        }
        bufferedReader.close();
        conn.disconnect();

        return  JsonToDtoConverter.convertJsonToDto(sb.toString());
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