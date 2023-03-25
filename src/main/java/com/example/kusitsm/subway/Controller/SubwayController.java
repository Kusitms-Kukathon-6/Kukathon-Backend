package com.example.kusitsm.subway.Controller;

import com.example.kusitsm.subway.Dto.Res.RouteInfo;
import com.example.kusitsm.subway.Service.SubwayService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("subway")
@Slf4j
public class SubwayController {
    private final SubwayService subwayService;

    //스트링으로 역 -> 코드로 가져와서(API) -> API 요청(API) -> 반환
    @GetMapping("/route")
    public ResponseEntity<RouteInfo> getSubwayRoute(@RequestParam String startStation, @RequestParam String endStation) throws Exception {

        return new ResponseEntity<>(subwayService.getSubwayCode(startStation,endStation), HttpStatus.OK);
    }

}