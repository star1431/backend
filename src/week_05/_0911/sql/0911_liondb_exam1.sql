desc emp;
desc salgrade;

SELECT * FROM salgrade;
SELECT * FROM emp;
SELECT * FROM dept;

/* --------- */
insert into emp values( 1000, 'kim', 'CLERK', null, STR_TO_DATE('23-1-1982','%d-%m-%Y'), 1300, null, null);
-- DELETE FROM emp WHERE empno = 1000;
-- commit;


/* non-equi join */
SELECT e.ename, e.sal, s.grade FROM emp e, salgrade s
	WHERE e.sal BETWEEN s.min_salary and s.max_salary;


/* outer join */
-- right (우측 테이블 dept 정보 모두 포함)
SELECT e.ename, e.deptno, d.dname FROM emp e
	RIGHT OUTER JOIN dept d USING(deptno);
    -- emp 에 해당 부서 직원이 없으면 ename 은 null로 나타남

-- left (좌측 테이블 emp 정보 모두 포함)
SELECT e.ename, e.deptno, d.dname FROM emp e
	LEFT OUTER JOIN dept d USING(deptno);
    -- dept 에 해당부서없으면 dname 은 null로 나타남

-- union (두 테이블 합집합)
SELECT e.ename, e.deptno, d.dname FROM emp e
	RIGHT OUTER JOIN dept d USING(deptno)
    UNION
	SELECT e.ename, e.deptno, d.dname FROM emp e
	LEFT OUTER JOIN dept d USING(deptno);
    -- emp 직원, dept 부서 없어도 둘다 합집합으로 null로 나옴
    -- 즉 모든 직원 + 모든 부서 정보 한번에 노출


/* self join */
SELECT 
	e.empno as 사원번호,
    e.ename as 사원명,
    m.empno as '담당 매니저번호',
    m.ename as '담당 매니저명'
	FROM emp e, emp m
	WHERE e.mgr = m.empno;
    -- 사원 담당 mgr 값 기준으로 사원의 매니저를 같은 테이블에서 찾아 매칭
    

/* 서브 쿼리 */
SELECT * FROM emp;
SELECT deptno FROM emp WHERE ename = 'smith';
SELECT avg(sal) FROM emp WHERE deptno = 20;

-- 스미스 사원이 속한 부서의 평균 급여
SELECT avg(sal) FROM emp 
	WHERE deptno = (
		SELECT deptno FROM emp
		WHERE ename = 'smith'
	);

-- 전체 평균 급여보다 적은 급여를 받는 사원
SELECT ename, sal FROM emp
	WHERE sal <= (
		SELECT avg(sal) FROM emp
    );

-- 가장 먼저 입사한 사원
SELECT ename, hiredate FROM emp
	WHERE hiredate = (
		SELECT min(hiredate) FROM emp
    );

-- 부서이름이 SALES 인 사원 정보
SELECT * FROM emp
	WHERE deptno = (
		SELECT deptno FROM dept
			WHERE dname = 'SALES'
    );

--
SELECT deptno, max(sal) FROM emp
	GROUP BY deptno;
    
-- 부서별 평균금액 보다 낮은 해당 부서 사원들
SELECT ename, deptno, sal FROM emp e
	WHERE sal < (
		SELECT avg(sal) FROM emp
		WHERE deptno = e.deptno
    );
    
-- in은 무조건 '='이고, or의 결합임
-- 해당 부서 내에서 최고급여 받는 사원
SELECT ename, deptno, sal FROM emp
	WHERE (deptno, sal) in (
		SELECT deptno, max(sal) FROM emp
		GROUP BY deptno
    );
    


/* any 연산자 */
-- 비교 연산시 any () 안의 값들 중 하나 만족할 경우
SELECT ename, deptno, sal FROM emp
	-- 30번 부서 사람들 급여보다 하나라도 작을 경우
	WHERE sal > any (
		SELECT sal FROM emp
        WHERE deptno = 30
    );

/* all 비교 연산자 */
-- 비교 연산시 all () 안의 값들 중 전부 만족할 경우
SELECT ename, deptno, sal FROM emp
	-- 30번 부서 사람들 급여보다 모두 작을 경우
	WHERE sal > all (
		SELECT sal FROM emp
        WHERE deptno = 30
    );
    


/* 상관 쿼리 */

-- 사원의 급여가 자기 부서의 평균 급여보다 큰 경우
SELECT ename, sal, deptno FROM emp e
	WHERE e.sal > (
		SELECT avg(i.sal) FROM emp i
        WHERE i.deptno = e.deptno
        -- 내부부서번호 = 외부부서번호 (대상직원) 일치한 부서의 평균 구하여
        -- 비교함 (외부쿼리 튜플마다)
    );





SELECT empno, ename, deptno FROM emp
	WHERE deptno in (
		SELECT deptno FROM dept
		WHERE loc = 'DALLAS'
	);

-- 부서 내 최고 급여를 받고 있는 사원의 모든 정보와 최고급여 컬럼 추가
SELECT e.*, m.max_sal FROM emp e
	JOIN (
		SELECT deptno, max(sal) as max_sal FROM emp
        GROUP BY deptno
	) m on e.deptno = m.deptno and e.sal = m.max_sal; 
    

/* 익시트 */
SELECT * FROM emp;

-- 후임이 있는 직원들만 조회
SELECT e.empno, e.ename FROM emp e
	WHERE EXISTS (
		-- SELECT 1 : 행이 하나라도 존재하는 지 (빠르게체크)
		SELECT 1 FROM emp i
        WHERE i.mgr = e.empno
        -- 내부쿼리 사원번호 = 외부 사원번호
        -- 나 자신이 후임이 있는 경우
    );




/* 테스트용 테이블 */
CREATE TABLE A (name INT);
CREATE TABLE B (name INT);
INSERT INTO A VALUES (1), (2), (3);
INSERT INTO B VALUES (2), (3), (4);

/* UNION : 중복제거 합집합 */
SELECT name FROM A
UNION
SELECT name FROM B;
-- 결과: 1, 2, 3, 4

/* UNION ALL : 중복포함 합집합 */
SELECT name FROM A
UNION ALL
SELECT name FROM B;
-- 결과: 1, 2, 3, 2, 3, 4


/* INTERSECT : 교집합 */
/*
	SELECT name FROM A
	INTERSECT
	SELECT name FROM B;
*/

-- mysql은 지원안해서 조인 대체 
SELECT DISTINCT A.name 
FROM A 
INNER JOIN B ON A.name = B.name;
-- 결과: 2, 3


/* MINUS : 차집합 */
/*
	SELECT name FROM A
	MINUS
	SELECT name FROM B;
*/

-- mysql은 지원안해서 서브쿼리 대체 
SELECT name FROM A
WHERE name NOT IN (
    SELECT name FROM B
);
-- 결과: 1

SELECT 
    sal,
    ename,
    RANK() OVER(ORDER BY sal DESC) AS ranking
FROM emp;

SELECT 
    deptno,
    ename,
    sal,
    RANK() OVER(PARTITION BY deptno ORDER BY sal DESC) AS dept_rank
FROM emp;






SELECT ename, sal FROM emp
	WHERE sal <= (
		SELECT avg(sal) FROM emp 
    );
