/* 날짜형 함수 사용 (날짜 데이터 처리) */

-- 1. employees 테이블에서 각 직원의 입사 연도(year)를 조회하세요.
SELECT * FROM employees;
SELECT date_format(hire_date, '%Y년') as 입사연도 FROM employees;

-- 2. job_history 테이블에서 각 기록의 근무 기간을 월(months) 단위로 계산하세요.
SELECT * FROM job_history;
SELECT concat(timestampdiff(month, start_date, end_date),'개월') as 근무개월 FROM job_history;

-- 3. employees 테이블에서 오늘로부터 입사한 지 30년이 된 직원들의 이름과 입사 날짜를 조회하세요.
SELECT first_name, last_name, hire_date
	FROM employees
    WHERE timestampdiff(year, hire_date, curdate()) >= 30;

-- 4. employees 테이블에서 이번 달이 입사월인 직원들의 이름과 이메일을 조회하세요
SELECT first_name, last_name, email, hire_date
	FROM employees
    WHERE month(hire_date) = month(curdate());
    
-- 5. employees 테이블에서 입사 날짜가 최근 30년 이내인 직원들의 이름과 입사날짜 조회하세요.
SELECT first_name, last_name, hire_date
	FROM employees
    WHERE timestampdiff(year, hire_date, curdate()) <= 30;

-- 6. job_history 테이블에서 직원이 특정 부서에 근무한 기간을 일(days) 단위로 조회하세요. 
SELECT department_id, employee_id, sum(datediff(end_date, start_date)) as '부서 총근무일' 
	FROM job_history
	GROUP BY department_id, employee_id;

-- 7. employees 테이블에서 가장 오래전에 입사한 직원의 이름과 입사 날짜를 조회하세요. 
SELECT first_name, last_name, hire_date FROM employees
ORDER BY hire_date asc
LIMIT 1;

-- 8. employees 테이블에서 각 직원의 입사일로부터 경과한 일수를 조회하세요.
SELECT datediff(curdate(), hire_date) as '입사일 경과일수' FROM employees;

-- 9. job_history 테이블에서 1999년대에 시작된 모든 근무 기록을 조회하세요. 
SELECT start_date, end_date FROM job_history
	WHERE year(start_date) = 1999;

-- 10. employees 테이블에서 각 직원의 입사 날짜를 요일로 표시하세요.
SELECT 
	employee_id,
	first_name,
	last_name,
	email,
	phone_number,
	DATE_FORMAT(hire_date, '%Y년 %m월 %d일') as hire_date,
	job_id,
	salary,
	commission_pct,
	manager_id,
	department_id
	FROM employees;
    

/* 숫자형 함수 사용 (수치 데이터 처리) */

-- 1. employees 테이블에서 각 직원의 급여에 10% 인상된 금액을 계산하여 조회하세요.
SELECT *, round((salary * 1.1), 2) as '10%인상금액' FROM employees;

-- 2. jobs 테이블에서 각 직업의 최소 급여와 최대 급여의 차이를 계산하세요.
SELECT *, (max_salary - min_salary) as '최소 최대차이' FROM jobs;

-- 3. employees 테이블에서 각 직원의 급여를 원화(KRW)로 환산하여 조회하세요 (환율 가정: 1 USD = 1200 KRW).
SELECT *, (salary * 1200) as 'KRW' FROM employees;

-- 4. employees 테이블에서 전체 직원의 평균 급여보다 높은 급여를 받는 직원들의 이름과 급여를 조회하세요.
SELECT first_name, last_name, salary FROM employees
	WHERE salary >= (SELECT avg(salary) FROM employees);

-- 5. employees 테이블에서 각 직원의 급여에서 평균 급여를 뺀 금액을 계산하여 조회하세요.
SELECT *, round((salary - (SELECT avg(salary) FROM employees)), 2) as '평균임금차이' FROM employees;

-- 6. employees 테이블에서 급여의 표준 편차를 계산하여 조회하세요.
-- 루트(평균(급여제곱) - 제곱(급여평균)) = 표준편차 // 어렵네요..
SELECT sqrt(avg(power(salary, 2)) - power(avg(salary), 2)) as '급여 표준편차' FROM employees;
SELECT stddev(salary) as '급여 표준편차' FROM employees; -- 다른방식 (함수제공)

-- 7. employees 테이블에서 각 직원의 연봉을 계산하고, 연봉이 가장 높은 순으로 정렬하여 조회하세요.
SELECT *, (salary * 12) '연봉' FROM employees
	ORDER BY 연봉 desc;

-- 8. job_history 테이블에서 각 기록에 대해 부서 변경 횟수를 계산하세요.
SELECT * FROM job_history;
SELECT employee_id, (count(DISTINCT department_id) - 1) as '변경횟수' FROM job_history
	GROUP BY employee_id;

-- 9. employees 테이블에서 직원들의 급여를 오름차순으로 정렬하여 조회하세요.
SELECT * FROM employees ORDER BY salary asc;