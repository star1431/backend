show tables;
SELECT * FROM employees;
SELECT * FROM departments;

-- 사원의 이름과 부서명을 출력
SELECT e.first_name, e.last_name, d.department_name FROM employees e
	JOIN departments d USING (department_id);
    
-- 부서별 평균 급여보다 많이 받는 직원

SELECT e.first_name, e.last_name, e.salary FROM employees e
	WHERE e.salary > (
		SELECT avg(i.salary) FROM employees i
        WHERE i.department_id = e.department_id
    );

SELECT e.first_name, e.last_name, e.salary, i.avg_sal FROM employees e
	JOIN (
		SELECT department_id, avg(salary) as avg_sal FROM employees
        GROUP BY department_id
    ) as i USING (department_id)
    WHERE e.salary > i.avg_sal;
    
    
    
    
    
 