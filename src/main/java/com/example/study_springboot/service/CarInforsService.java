package com.example.study_springboot.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.study_springboot.dao.SharedDao;

@Service
public class CarInforsService {
    @Autowired
    SharedDao sharedDao;

    public Object selectDetail(String CAR_INFOR_ID) {
        // SharedDao에서 호출한다. _GetOne 하나만 호출
        // public Object getOne(String sqlMapId, Object dataMap)
        String sqlMapId = "CarInfors.selectByUID";
        // sqlMapId= xml의 namespace
        // Object dataMap = xml의 연결하고자 하는 tage의 id

        HashMap dataMap = new HashMap<>();
        dataMap.put("CAR_INFOR_ID", CAR_INFOR_ID);

        Object result = sharedDao.getOne(sqlMapId, dataMap);
        return result;

    }

}
