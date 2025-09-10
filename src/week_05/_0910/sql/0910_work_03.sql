/* 문자 함수를 이용한 SQL 연습 문제 */

-- 1. 직원의 성(last_name)을 대문자로 변환하여 조회하기
SELECT last_name, upper(last_name) as "성" FROM employees;

-- 2. 직원의 이름(first_name)의 첫 글자를 추출하기
SELECT first_name, substr(first_name,1,1) FROM employees;

-- 3. 직원의 성(last_name)에서 'a'가 몇 번 나오는지 세기
SELECT last_name,
	length(last_name) - 
	length( replace(lower(last_name), 'a', '') ) 
    as 'a갯수'
    FROM employees;
    
-- 4.직원의 이메일에서 도메인 부분만 추출하기 (@ 이후 문자열) // 없어서 job_id 대체
SELECT * FROM employees;
SELECT substring_index(job_id, '_', -1) as 뒷글자 FROM employees;

-- 5.직원의 전체 이름을 성과 이름으로 구분하여 조회하기 // 전체이름없어서 합쳐서 구분나누기
SELECT 
	substring_index(concat(first_name, ' ', last_name), ' ', -1) as 성,
	substring_index(concat(first_name, ' ', last_name), ' ', 1) as 이름
    FROM employees;

-- 6. 직원의 이름(first_name)에서 세 번째 문자부터 세 글자 가져오기:
SELECT substr(first_name, 3, 3) as '3번째 세글자' FROM employees;

-- 7. 모든 직원의 성(last_name)을 쉼표와 공백 후 이름(first_name)으로 표시하기
SELECT concat(last_name, ', ', first_name) as '성, 이름' FROM employees;

-- 8. 직원의 이름(first_name)의 길이를 구하여 조회하기
SELECT first_name, length(first_name) as 길이 FROM employees;

-- 9. 직원의 성(last_name)이 'King'인 직원 찾기 (대소문자 구분 없이):
SELECT last_name FROM employees
	WHERE upper(last_name) = 'KING';

-- 10. 직원의 성(last_name) 중 'M'으로 시작하는 사람들의 수 구하기:
SELECT SUM(last_name LIKE 'M%') as 'M시작 사람 수' FROM employees;
	