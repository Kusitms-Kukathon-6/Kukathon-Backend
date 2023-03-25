package com.example.kusitsm.subway.Dto.Res;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class OperationInfoDetail {

    private String FACI_NM;
    private String STUP_LCTN;
    private String LOCATION;
    private String USE_YN;
    private String GUBUN;
}
