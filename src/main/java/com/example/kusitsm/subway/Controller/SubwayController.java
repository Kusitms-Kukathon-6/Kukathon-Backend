package com.example.kusitsm.subway.Controller;

import com.example.kusitsm.subway.Dto.Res.SubwayCodeRes;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("subway")
@Slf4j
public class SubwayController {

//    //스트링으로 역 -> 코드로 가져와서(API) -> API 요청(API) -> 반환
//    @GetMapping("/route")
//    public ResponseEntity<SubwayCodeRes> getSubwayRoute(@ModelAttribute String SID,@ModelAttribute String EID){
//
//    }

}
