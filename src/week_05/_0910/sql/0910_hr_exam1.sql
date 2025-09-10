SHOW TABLES;

DESC employees;
SELECT * FROM employees;

/* 컬럼결합 계산 --------------------- */
SELECT CONCAT(first_name, ' ', last_name) AS full_name
FROM employees;

SELECT 
    first_name,
    salary,
    salary * 12 AS annual_salary
FROM employees;


/* 연산 --------------------- */
SELECT * FROM employees 
WHERE (department_id = 90 OR department_id = 100)
  AND salary >= 10000;
  



SELECT * FROM employees;

/* 실습1 ----------- */
-- 1. 모든 직원 이름 , 이메일
SELECT concat(first_name, ' ', last_name) as '이름+성',
	email as 이메일
    FROM employees;
  
-- 2. 급여 1500 이상 직원
SELECT * FROM employees
	WHERE salary >= 1500 is not NULL;

-- 3. 2005년에 입사한 직원
SELECT * FROM employees
	WHERE year(hire_date) = 2005;
    

/* 실습2 ----------- */
-- 1. 이름 an 직원
SELECT * FROM employees
	WHERE first_name LIKE '%an%' or last_name LIKE '%an%';

-- 2. 이메일 S 시작, 급여 내림차순
SELECT * FROM employees
	WHERE email LIKE 'S%'
    ORDER BY salary desc;
    

/* 실습3 ----------- */
-- 1. 부서별 직원 수, 평균급여
SELECT 
	department_id as 부서번호,
    COUNT(*) as '부서별 직원 수',
    avg(salary) as 평균급여
    FROM employees
    GROUP BY department_id;

-- 2. 직원이 5명 이상 부서
SELECT 
	department_id as 부서번호,
    COUNT(department_id) as '부서별 직원 수'
    FROM employees
    GROUP BY department_id
    HAVING COUNT(*) >= 5;
    