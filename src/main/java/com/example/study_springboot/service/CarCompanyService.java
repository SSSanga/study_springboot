// package com.example.study_springboot.service;

// import java.util.HashMap;
// import java.util.Map;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;
// import org.springframework.transaction.annotation.Transactional;

// import com.example.study_springboot.dao.SharedDao;

// @Service
// @Transactional
// public class CarCompanyService {
//     @Autowired
//     SharedDao sharedDao;
// // <!-- mybatis foreach Map.put("CAR_INFOR_ID_LIST",CAR_INFOR_ID_LIST)-->

//     public Object selectInUID(Map dataMap) {
//                 // 아예 받아올때 hashmap자체로 받아올 수 있게
//                 // map으로 한 이유는 hashmap보다 상위 클래스이므로
//                 // or 아예 가장 최상위의 Object로 받아도 상관무. 
//         String sqlMapId = "CarCompany.selectInUID";
              
//         Object result = sharedDao.getList(sqlMapId, dataMap);
//         return result;

//     }

//     // 검색 (search : 첫번째 조건 YEAR, 두번째 조건 CAR_NAME)
//     // SharedDao에서 public Object getList 사용
//     public Object selectSearch(String search, String words) {
//         String sqlMapId = "CarCompany.selectSearch";

//         HashMap dataMap = new HashMap<>();
//         dataMap.put("search", search);
//         dataMap.put("words", words);

//         Object result = sharedDao.getList(sqlMapId, dataMap);
//         return result;

//     }

//     public Object selectAll(String COMPANY_ID) {
//         String sqlMapId = "CarCompany.selectAll";

//         HashMap dataMap = new HashMap<>();
//         dataMap.put("CAR_INFOR_ID", COMPANY_ID);

//         Object result = sharedDao.getList(sqlMapId, dataMap);
//         return result;

//     }

//     public Object selectDetail(String COMPANY_ID) {
//         // SharedDao에서 호출한다. _GetOne 하나만 호출
//         // public Object getOne(String sqlMapId, Object dataMap)
//         String sqlMapId = "CarCompany.selectByUID";
//         // sqlMapId= xml의 namespace
//         // Object dataMap = xml의 연결하고자 하는 tage의 id

//         HashMap dataMap = new HashMap<>();
//         dataMap.put("CAR_INFOR_ID", COMPANY_ID);

//         Object result = sharedDao.getOne(sqlMapId, dataMap);
//         return result;

//     }

//     public Object insert(Map dataMap) {
//         // 입력 or 삽입 in sharedDao
//         // Object result = sqlSessionTemplate.insert(sqlMapId, dataMap);
//         String sqlMapId = "CarCompany.insert";
//         Object result = sharedDao.insert(sqlMapId, dataMap);
//         return result;
//     }

//     public Object update(Map dataMap) {
//         // 업데이트 in sharedDao
//         // Object result = sqlSessionTemplate.update(sqlMapId, dataMap);
//         String sqlMapId = "CarCompany.update";
//         Object result = sharedDao.update(sqlMapId, dataMap);
//         return result;
//     }

//     public Object delete(String COMPANY_ID) {
//         // Object result = sqlSessionTemplate.delete(sqlMapId, dataMap);
//         String sqlMapId = "CarCompany.delete";
//         HashMap dataMap = new HashMap<>();
//         dataMap.put("COMPANY_ID", COMPANY_ID);

//         Object result = sharedDao.delete(sqlMapId, dataMap);
//         // client가
//         return result;
//     }

//     // 2번 insert. 레코드 1개, 2번 insert = PK 중복이라 안될것임.
//     public Object insertDouble(Map dataMap) {
//         String sqlMapId = "CarCompany.insert";
//         // sucess
//         Object result = sharedDao.insert(sqlMapId, dataMap);
//         // error
//         result = sharedDao.insert(sqlMapId, dataMap);

//         return result;
//     }

// }
