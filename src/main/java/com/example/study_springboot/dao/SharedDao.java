package com.example.study_springboot.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SharedDao {
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    // 레코드 여러개
    public Object getList(String sqlMapId, Object dataMap) {
        Object result = sqlSessionTemplate.selectList(sqlMapId, dataMap);
        return result;
    }

    // 레코드 하나  우선적으로 이거 사용할것. 
    public Object getOne(String sqlMapId, Object dataMap) {
        Object result = sqlSessionTemplate.selectOne(sqlMapId, dataMap);
        return result;
    }

    // 수정
    public Object update(String sqlMapId, Object dataMap) {
        Object result = sqlSessionTemplate.update(sqlMapId, dataMap);
        return result;
    }

    // 삽입
    public Object insert(String sqlMapId, Object dataMap) {
        Object result = sqlSessionTemplate.insert(sqlMapId, dataMap);
        return result;
    }

    // 삭제
    public Object delete(String sqlMapId, Object dataMap) {
        Object result = sqlSessionTemplate.delete(sqlMapId, dataMap);
        return result;
    }
}
