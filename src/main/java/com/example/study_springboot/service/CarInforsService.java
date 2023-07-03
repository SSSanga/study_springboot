package com.example.study_springboot.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.study_springboot.dao.SharedDao;

@Service
public class CarInforsService {
    @Autowired
    SharedDao sharedDao;
    public Object selectAll(String CAR_INFOR_ID) {
        String sqlMapId = "CarInfors.selectAll";

        HashMap dataMap = new HashMap<>();
        dataMap.put("CAR_INFOR_ID", CAR_INFOR_ID);

        Object result = sharedDao.getList(sqlMapId, dataMap);
        return result;

    }

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

    public Object insert(Map dataMap) {
        // 입력 or 삽입 in sharedDao
        // Object result = sqlSessionTemplate.insert(sqlMapId, dataMap);
        String sqlMapId = "CarInfors.insert";
        Object result = sharedDao.insert(sqlMapId, dataMap);
        return result;
    }

    public Object update(Map dataMap) {
        // 업데이트 in sharedDao
        // Object result = sqlSessionTemplate.update(sqlMapId, dataMap);
        String sqlMapId = "CarInfors.update";
        Object result = sharedDao.update(sqlMapId, dataMap);
        return result;
    }

    public Object delete(String CAR_INFOR_ID) {
        // Object result = sqlSessionTemplate.delete(sqlMapId, dataMap);
        String sqlMapId = "CarInfors.delete";
        HashMap dataMap = new HashMap<>();
        dataMap.put("CAR_INFOR_ID", CAR_INFOR_ID);

        Object result = sharedDao.delete(sqlMapId, dataMap);
        // client가 
        return result;
    }
}
