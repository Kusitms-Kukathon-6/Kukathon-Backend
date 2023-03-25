# Kukathon-Backend-6

- 사용한 Open API
    - 서울 열린데이터 광장 : 서울시 지하철역 정보 검색 (역명) API
    - ODsay : 지하철 경로검색 조회(지하철 노선도) API
    - 서울 열린데이터 광장 : 서울교통공사 교통약자 이용시설(승강기) 가동현황 API

### ✨ Main 1. 출발역과 도착역 입력시 최단 경로 반환
- 파라미터로 출발역과 도착역을 입력받아 지하철역 코드(code)번호로 변환후 경로검색 조건에 따라 값을 반환한다.

```
  //코드 반환 예시
{
    "SearchInfoBySubwayNameService": {
        "list_total_count": 3,
        "RESULT": {
            "CODE": "INFO-000",
            "MESSAGE": "정상 처리되었습니다"
        },
        "row": [
            {
                "STATION_CD": "1264",
                "STATION_NM": "홍대입구",
                "LINE_NUM": "경의선",
                "FR_CODE": "K314"
            },
            {
                "STATION_CD": "0239",
                "STATION_NM": "홍대입구",
                "LINE_NUM": "02호선",
                "FR_CODE": "239"
            },
            {
                "STATION_CD": "4203",
                "STATION_NM": "홍대입구",
                "LINE_NUM": "공항철도",
                "FR_CODE": "A03"
            }
        ]
    }
}

```

```
//최단 경로 반환 예시
{
   "result": {
      "globalStartName": "강변",
      "globalEndName": "잠실나루",
      "globalTravelTime": 2,
      "globalDistance": 1.8,
      "globalStationCount": 1,
      "fare": 1250,
      "cashFare": 1350,
      "driveInfoSet": {
         "driveInfo": [
            {
               "laneID": "2",
               "laneName": "2호선",
               "startName": "강변",
               "stationCount": 1,
               "wayCode": 2,
               "wayName": "내선순환"
            }
         ]
      },
      "stationSet": {
         "stations": [
            {
               "startID": 214,
               "startName": "강변",
               "endSID": 215,
               "endName": "잠실나루",
               "travelTime": 2
            }
         ]
      }
   }
}
```

### ✨ Main 2. 역간의 교통약자 이용시설 가동현황 반환
- 역을 입력하고 역별 승강기 정보 및 정상가동 여부를 반환

```
//가동현황 반환 예시
{
    "stationName": "명동",
    "operationInfoDetailList": [
        {
            "use_YN": "보수중",
            "stup_LCTN": "B4-B1",
            "location": "내부",
            "gubun": "EV",
            "faci_NM": "승강기)엘리베이터 내부#1"
        },
        {
            "use_YN": "사용가능",
            "stup_LCTN": "B1-F1",
            "location": "1번 출구측",
            "gubun": "EV",
            "faci_NM": "승강기)엘리베이터 외부#1"
        },
		"outElv": ["1번 출구측"],
    "inElv":[],
    "outWh": [],
    "inWh": [],
    "availabe": true
]
}

```
### 기술 스택 : Java, Gradle, , Lombok, Springboot, ec2
