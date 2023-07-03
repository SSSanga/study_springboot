package com.example.study_springboot.restapis;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.study_springboot.service.CarInforsService;

@RestController

public class CarInforsController {
    @Autowired
    CarInforsService carInforsService;
// /selectDetail/CI002
    @GetMapping("/selectDetail/{CAR_INFOR_ID}")
    // {}변수는 pathVariable로 capping해서 가져올것.
    public ResponseEntity selectDetail(@PathVariable String CAR_INFOR_ID) {
        Object result = carInforsService.selectDetail(CAR_INFOR_ID);

        return ResponseEntity.ok().body(result);
    }
}
