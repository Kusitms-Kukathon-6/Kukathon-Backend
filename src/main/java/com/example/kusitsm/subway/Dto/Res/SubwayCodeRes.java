package com.example.kusitsm.subway.Dto.Res;

import lombok.Data;

import java.util.List;


public class SubwayCodeRes {
    private SearchInfoBySubwayNameService SearchInfoBySubwayNameService;

    @Data
    public static class SearchInfoBySubwayNameService {
        private int list_total_count;
        private Result RESULT;
        private List<SubwayInfo> row;

        @Data
        public static class Result {
            private String CODE;
            private String MESSAGE;
        }

        @Data
        public static class SubwayInfo {
            private String STATION_CD;
            private String STATION_NM;
            private String LINE_NUM;
            private String FR_CODE;
        }


    }
}
