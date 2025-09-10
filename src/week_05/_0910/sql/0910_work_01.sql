/* SELECT 문 사용 (기본 검색) */

-- 1. employees 테이블에서 직원의 이름(first_name), 성(last_name)을 조회하세요.
SELECT first_name as 이름, first_name as 성 FROM employees;

-- 2. departments 테이블에서 모든 부서의 이름(department_name)과 위치 ID(location_id)를 조회하세요.
SELECT department_name as 부서명, location_id as '위치 ID' FROM departments;

-- 3. jobs 테이블에서 직업 ID(job_id)와 직업 타이틀(job_title)을 조회하세요.
SELECT job_id as '직업 ID', job_title as 직업타이틀 FROM jobs;

-- 4. locations 테이블에서 각 위치의 주소(street_address)와 우편번호(postal_code)를 조회하세요.
SELECT street_address as 주소, postal_code as 우편번호 FROM locations;

-- 5. countries 테이블에서 국가 ID(country_id)와 국가 이름(country_name)을 조회하세요.
SELECT country_id as '국가 ID', country_name as '국가 이름' FROM countries;

-- 6. regions 테이블에서 지역 ID(region_id)와 지역 이름(region_name)을 조회하세요.
SELECT region_id as '지역 ID', region_name as '지역 이름' FROM regions;

-- 7. employees 테이블에서 모든 직원의 직업 ID(job_id)를 조회하세요.
SELECT job_id as '직업 ID' FROM employees;

-- 8. departments 테이블에서 부서 ID(department_id)별로 부서 이름(department_name)을 조회하세요.
SELECT department_id as '부서 ID', department_name as '부서 이름' FROM departments;

-- 9. job_history 테이블에서 직원 ID(employee_id)와 부서 ID(department_id)를 조회하세요.
SELECT employee_id as '직원 ID', department_id as '부서 ID' FROM job_history;

-- 10. employees 테이블에서 직원 ID(employee_id), 이름(first_name)과 성(last_name)을 조회하세요.
SELECT employee_id as '직원 ID', first_name as '이름', last_name as '성' FROM employees;

