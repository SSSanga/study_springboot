-- 조건 검색
SELECT *
FROM car_infors
WHERE 1=1
-- 년도 ~보다 이상
AND YEAR > '2020';
-- CAR_NAME으로 
-- AND CAR_NAME LIKE '소%';

-- 전체
SELECT *
FROM car_infors;

-- 상세 : 하나의 레코드만 나와야함. COMPANY_ID는 여러개 나올 수 있으므로
-- UNIQUE_ID로 SELECT 하고자 함. 
SELECT *
FROM db_cars.car_infors
WHERE CAR_INFOR_ID = 'CI002';

-- 입력
INSERT INTO car_infors (CAR_NAME,YEAR,CAR_INFOR_ID,COMPANY_ID)
VALUES ('쏘렌토','2020','CAR-02','C002');

-- 수정
UPDATE car_infors
SET CAR_NAME = '코나'
WHERE CAR_INFOR_ID = 'CAR-02';

-- 삭제
DELETE FROM car_infors
WHERE CAR_INFOR_ID='CAR-02';

SELECT * FROM db_cars.car_infors WHERE CAR_INFOR_ID ='CI002';



