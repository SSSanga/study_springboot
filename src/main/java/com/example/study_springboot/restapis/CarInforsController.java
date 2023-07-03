package com.example.study_springboot.restapis;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.study_springboot.service.CarInforsService;

@RestController

public class CarInforsController {
    @Autowired
    CarInforsService carInforsService;
// /selectDetail/CI002

  @GetMapping("/selectAll/{CAR_INFOR_ID}")
    // {}변수는 pathVariable로 capping해서 가져올것.
    public ResponseEntity selectAll(@PathVariable String CAR_INFOR_ID) {
        Object result = carInforsService.selectAll(CAR_INFOR_ID);

        return ResponseEntity.ok().body(result);
    }
    @GetMapping("/selectDetail/{CAR_INFOR_ID}")
    // {}변수는 pathVariable로 capping해서 가져올것.
    public ResponseEntity selectDetail(@PathVariable String CAR_INFOR_ID) {
        Object result = carInforsService.selectDetail(CAR_INFOR_ID);

        return ResponseEntity.ok().body(result);
    }
    
    @PostMapping("/insert")
    // 입력
    public ResponseEntity insert (@RequestBody Map paramMap){
        Object result = carInforsService.insert(paramMap);
        return ResponseEntity.ok().body(result);
    }
    @PutMapping("/update")
    // 업데이트
    public ResponseEntity updatd (@RequestBody Map paramMap){
        Object result = carInforsService.update(paramMap);
        return ResponseEntity.ok().body(result);
    }
    @DeleteMapping("/delete/{CAR_INFOR_ID}")
    // {}변수는 pathVariable로 capping해서 가져올것.
    public ResponseEntity delete(@PathVariable String CAR_INFOR_ID) {
        Object result = carInforsService.delete(CAR_INFOR_ID);

        return ResponseEntity.ok().body(result);
    }
}
