package com.example.kusitsm.subway.Dto.Res;

import java.util.List;
import lombok.Data;

@Data
public class RouteInfo {
    private Result result;

    @Data
    public static class Result {
        private String globalStartName;
        private String globalEndName;
        private int globalTravelTime;
        private double globalDistance;
        private int globalStationCount;
        private int fare;
        private int cashFare;
        private DriveInfoSet driveInfoSet;
        private ExChangeInfoSet exChangeInfoSet;
        private StationSet stationSet;

        @Data
        public static class DriveInfoSet {
            private List<DriveInfo> driveInfo;

            @Data
            public static class DriveInfo {
                private String laneID;
                private String laneName;
                private String startName;
                private int stationCount;
                private int wayCode;
                private String wayName;
            }
        }

        @Data
        public static class ExChangeInfoSet {
            private List<ExChangeInfo> exChangeInfo;

            @Data
            public static class ExChangeInfo {
                private String laneName;
                private String startName;
                private String exName;
                private int exSID;
                private int fastTrain;
                private int fastDoor;
                private int exWalkTime;
            }
        }

        @Data
        public static class StationSet {
            private List<Station> stations;

            @Data
            public static class Station {
                private int startID;
                private String startName;
                private int endSID;
                private String endName;
                private int travelTime;
            }
        }
    }
}