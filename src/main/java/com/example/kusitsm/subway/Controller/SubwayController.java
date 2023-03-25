package com.example.kusitsm.subway.Controller;

import com.example.kusitsm.subway.Dto.Res.SubwayCodeRes;
import com.example.kusitsm.subway.Dto.Res.SubwayCodeReturn;
import com.example.kusitsm.subway.Service.SubwayService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.parser.ParseException;
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
    public ResponseEntity<SubwayCodeReturn> getSubwayRoute(@RequestParam String startStation, @RequestParam String endStation) throws JsonProcessingException, ParseException {

        return new ResponseEntity<>(subwayService.getSubwayCode(startStation,endStation), HttpStatus.OK);
    }

}