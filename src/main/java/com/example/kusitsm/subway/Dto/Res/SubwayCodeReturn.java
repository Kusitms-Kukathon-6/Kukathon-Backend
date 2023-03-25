package com.example.kusitsm.subway.Dto.Res;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubwayCodeReturn {
    private int SID;
    private int EID;
}
