package com.example.study_springboot.restapis;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.study_springboot.service.CarCompanyService;

@RestController

public class CarCompanyController {
    @Autowired
    CarCompanyService carCompanyService;

    @PostMapping("/insert")
    public ResponseEntity insert(@RequestBody Map paramMap) {
        Object result = carCompanyService.insert(paramMap);
        return ResponseEntity.ok().body(result);
    }
}
