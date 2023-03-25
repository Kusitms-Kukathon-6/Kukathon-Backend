package com.example.kusitsm.subway.Dto.Res;

import lombok.*;

import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Setter
public class OperationInfo {

    private String stationName;

    private boolean isAvailabe; //true : 가능 /fasle : 불가능

    private List<OperationInfoDetail> operationInfoDetailList = new ArrayList<>();

    private List<String> outElv = new ArrayList<>();
    private List<String> inElv = new ArrayList<>();
    private List<String> outWh = new ArrayList<>();
    private List<String> inWh = new ArrayList<>();
}
