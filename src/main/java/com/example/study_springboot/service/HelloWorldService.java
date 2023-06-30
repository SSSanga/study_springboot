package com.example.study_springboot.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
// method만들기
public class HelloWorldService {
    public int fakeSelect(String companyId){
        return 0;
        // mybatis에서 xml을 받고 xml에서 DB를 호출해야함(이건 정해져있음. ). 
    }
    public ArrayList fakeSelect(@PathVariable String currentPage, @PathVariable String perPage) {
        ArrayList arrayList = new ArrayList<>();
        HashMap resultMap = new HashMap<>();
        resultMap.put("spm_row", 471);
        resultMap.put("SN", 1);
        resultMap.put("CMPNM", "로이유통");
        resultMap.put("RDNMADR", null);
        arrayList.add(resultMap);

        resultMap = new HashMap<>();
        resultMap.put("spm_row", 571);
        resultMap.put("SN", 2);
        resultMap.put("CMPNM", "의료유통");
        resultMap.put("RDNMADR", 3);
        arrayList.add(resultMap);

        return arrayList;
    }
}
