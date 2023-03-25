package com.example.kusitsm.subway.Dto.Res;


import lombok.*;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OperationInfoRes {
    private List<OperationInfo> operationInfoList ;
}
