package com.example.study_springboot.controller;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.study_springboot.service.CarInforsService;

@Controller
@RequestMapping("/carInfor")
public class CarInforsController {
    @Autowired
    CarInforsService carInforsService;

    @GetMapping("/selectInUID")
    // 입력
    public ResponseEntity selectInUID(@RequestBody Map paramMap) {
        Object result = null;
        try {
            result = carInforsService.selectInUID(paramMap);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok().body(result);
    }

    // /selectSearch/YEAR/2020
    // /selectSearch/CAR_NAME/소
    // "/selectSearch/{search}/{words}
    // @PathVariable String search, @PathVariable String words
    // /selectSearch?serch=YEAR&words=2020
    @GetMapping("/selectSearch")
    // {}변수는 pathVariable로 capping해서 가져올것.
    public ModelAndView selectSearch(@RequestParam Map params, ModelAndView modelAndView) {
        Object result = carInforsService.selectSearch(params);
        modelAndView.addObject("params", params);
        modelAndView.addObject("result", result);

        modelAndView.setViewName("/WEB-INF/views/carinfor/list.jsp");
        return modelAndView;
    }

    // /selectAll/CI002
    @GetMapping("/selectAll/{CAR_INFOR_ID}")
    // {}변수는 pathVariable로 capping해서 가져올것.
    public ResponseEntity selectAll(@PathVariable String CAR_INFOR_ID) {
        Object result = carInforsService.selectAll(CAR_INFOR_ID);

        return ResponseEntity.ok().body(result);
    }

    // /selectDetail/CI002
    @GetMapping("/selectDetail/{CAR_INFOR_ID}")
    // {}변수는 pathVariable로 capping해서 가져올것.
    public ResponseEntity selectDetail(@PathVariable String CAR_INFOR_ID) {
        Object result = carInforsService.selectDetail(CAR_INFOR_ID);

        return ResponseEntity.ok().body(result);
    }

    @PostMapping("/insert")
    // 입력
    public ResponseEntity insert(@RequestBody Map paramMap) {
        Object result = carInforsService.insert(paramMap);
        return ResponseEntity.ok().body(result);
    }

    @PutMapping("/update")
    // 업데이트
    public ResponseEntity update(@RequestBody Map paramMap) {
        Object result = carInforsService.update(paramMap);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/delete/{CAR_INFOR_ID}")
    // {}변수는 pathVariable로 capping해서 가져올것.
    public ResponseEntity delete(@PathVariable String CAR_INFOR_ID) {
        Object result = carInforsService.delete(CAR_INFOR_ID);

        return ResponseEntity.ok().body(result);
    }

    // Service에서 일부러 중복 에러 일으킬것임.
    @PostMapping("/insertDouble")

    public ResponseEntity insertDouble(@RequestBody Map paramMap) {
        Object result = null;
        try {
            result = carInforsService.insertDouble(paramMap);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok().body(result);

    }
}
