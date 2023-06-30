package com.example.study_springboot.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.study_springboot.dao.SharedDao;


@Service
// method만들기
public class HelloWorldService {
   @Autowired  // 자동인스턴스화
    SharedDao sharedDao;
    public int fakeSelect(String companyId){
        HashMap dataMap=new HashMap<>();
        dataMap.put("companyId",companyId);

        sharedDao.getOne("fake.selectByUID", dataMap);
        // SharedDao.getOne 보면 String sqlMapId = xml의 namespace.id 임. = fake.selectByUID
        // SharedDao.getOne 보면 Objec dataMap= HashMap 형태 이므로 hashmap에 넣어서 가져올것. 

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
