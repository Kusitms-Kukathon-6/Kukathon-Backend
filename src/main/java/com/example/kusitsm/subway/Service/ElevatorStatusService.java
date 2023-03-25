package com.example.kusitsm.subway.Service;

import com.example.kusitsm.subway.Dto.Res.OperationInfo;
import com.example.kusitsm.subway.Dto.Res.OperationInfoDetail;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class ElevatorStatusService {
    private static final String API_KEY = "797742746773687038324558424b4b";
    private static final String API_URL = "http://openapi.seoul.go.kr:8088/" + API_KEY + "/json/SeoulMetroFaciInfo/1/1000";

    public OperationInfo getElevatorStatus(String stationName) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(API_URL, String.class);
        String responseBody = response.getBody();
        JSONObject json = new JSONObject(responseBody);
        JSONObject faciInfo = json.getJSONObject("SeoulMetroFaciInfo");
        JSONArray rowArray = faciInfo.getJSONArray("row");

        OperationInfo operationInfo = new OperationInfo();
        operationInfo.setStationName(stationName);

        // 역 이름에 해당하는 엘리베이터 운행 상태 정보만 추출하여 반환
        for (int i = 0; i < rowArray.length(); i++) {
            JSONObject row = rowArray.getJSONObject(i);
            if ((row.getString("GUBUN").equals("EV")||row.getString("GUBUN").equals("WL"))&&row.getString("STATION_NM").contains(stationName)) {
                OperationInfoDetail operationInfoDetail = new OperationInfoDetail(row.getString("FACI_NM"),row.getString("STUP_LCTN"),row.getString("LOCATION"),row.getString("USE_YN"),row.getString("GUBUN"));
                operationInfo.getOperationInfoDetailList().add(operationInfoDetail);
            }
        }

        int check = 0;
        for(int i=0; i<operationInfo.getOperationInfoDetailList().size();i++){
            if(operationInfo.getOperationInfoDetailList().get(i).getUSE_YN().equals("사용가능")){
                check ++;
            }
        }

        if(check==0) operationInfo.setAvailabe(false);
        else operationInfo.setAvailabe(true);

        return operationInfo;
        // 역 이름에 해당하는 엘리베이터 운행 상태 정보가 없을 경우 null 반환
    }
}