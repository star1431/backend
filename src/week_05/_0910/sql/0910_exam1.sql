
/* 산술 --------------------- */
SELECT 3+5;
SELECT VERSION(); SELECT NOW();

SELECT sin(pi()/4), (4+1)*5;
SELECT 
    USER(),
    CURRENT_DATE;

SELECT
	user(),
    current_date;
    


/* 데이터 조회 --------------------- */
DESC emp; -- 스키마 정보 확인 (type, null 여부 등)

SELECT * FROM emp;  -- 전체 조회
SELECT job FROM emp; -- 특정 컬럼 조회
SELECT DISTINCT job FROM emp; -- 특정 컬럼 중복값 제외 조회
SELECT DISTINCT job, empno FROM emp; 

-- 별칭 부여
SELECT empno 사번, 
	ename AS "사원 이름", 
    mgr AS 매니저 
    FROM emp;

/* 컬럼결합 계산 --------------------- */
-- 문자열 결합
SELECT concat(ename, ' [', job, ']') AS "이름 [직원]" FROM emp;

-- 산술 연산
SELECT 
    ename,
    sal,
    sal / 12 AS "월급"
FROM emp;


/* 조건 --------------------- */
SELECT * FROM emp WHERE deptno = 10;
SELECT * FROM emp WHERE job = 'manager';
SELECT * FROM emp WHERE sal > 2500;
SELECT * FROM emp WHERE sal > 2500 and job = 'manager';
SELECT * FROM emp 
	WHERE (deptno = 10 or deptno = 20)
    and sal >= 2000;
    
-- and 연산
SELECT * FROM emp 
	WHERE sal >= 1000 and deptno = 10;

-- or 연산
SELECT * FROM emp
	WHERE deptno = 10 or deptno = 20;

-- not 연산
SELECT * FROM emp
	WHERE not deptno = 30;


-- in
SELECT * FROM emp 
WHERE deptno in (10, 20); -- 10, 20 인 것

-- not in
SELECT * FROM emp 
WHERE deptno not in (20, 30); -- 20, 30 아닌 것

-- 비트윈 : 일반 범위
SELECT * FROM emp 
	WHERE sal BETWEEN 2300 and 3000; -- 2300이상 3000이하

-- 비트윈 : 날짜 범위
SELECT * FROM emp 
	WHERE hiredate BETWEEN '1981-01-01' and '1981-12-31';
    
    
    
/* 라이크 --------------------- */

-- 이름이 F로 시작
SELECT * FROM emp
	WHERE ename like 'F%';

-- 이름이 두번째 O 
SELECT * FROM emp
	WHERE ename like '_O%';

-- 1981년 입사
SELECT * FROM emp
	WHERE hiredate like '1981%';
-- 함수형 방식
SELECT * FROM emp
	WHERE year(hiredate) = 1981;


-- 9월 입사
SELECT * FROM emp
	WHERE hiredate like '____-09%';
-- 함수형 방식
SELECT * FROM emp
	WHERE month(hiredate) = 9;

/* 널처리 --------------------- */
SELECT * FROM emp;

SELECT * FROM emp
	WHERE comm is NULL;
    
-- 결합 널 처리

-- ifnull : null인 경우 대체 처리
SELECT comm, ifnull(comm, -1) -- null를 -1로 대체
	FROM emp;


SELECT ename, sal, comm, 
	sal + ifnull(comm, 0) as 상여금포함연봉 
    FROM emp;
    -- sal 연봉 | comm 상여금 (null있음) 
    
SELECT ename, comm, job, 
	coalesce(comm, job, '하하') 
    FROM emp;
    -- comm 이 null이면 job을 쓰고, 
    -- job도 null이면 '하하'
    

/* 정렬 --------------------- */

SELECT * FROM emp;

SELECT * FROM emp 
	ORDER BY ename asc; -- 오름차순
SELECT * FROM emp 
	ORDER BY ename desc; -- 내림차순


SELECT deptno, ename, sal FROM emp
	ORDER BY deptno, sal asc;
    -- 부서번호, 연봉 오름차순

SELECT deptno, ename, sal FROM emp
	ORDER BY deptno asc, sal desc;
    -- 부서번호 오름차순, 연봉 내림차순

SELECT empno, mgr*22 as 월급, ename FROM emp
    ORDER BY 월급 desc, ename asc;
    -- 별칭기준 내림차순, 이름 오름차순

SELECT deptno, job, ename, sal
    FROM emp
    ORDER BY deptno asc
    LIMIT 0, 5;  -- 2 페이지

DESC emp;

-- 대소문자
SELECT upper('hello'), lower('WORLD'); -- HELLO | world
-- 문자열 결합
SELECT concat('Hello', ' ', 'World'); -- Hello World
-- 부분 문자열
SELECT substring('Hello World', 1, 5); -- Hello
SELECT substr('Hello World', 1, 5); -- Hello
-- 문자열 길이
SELECT length('Hello World'); -- 11
-- 공백 제거
SELECT trim('  양쪽 공백  '),
	ltrim('  좌측 공백'), 
    rtrim('우측 공백  ');
-- 문자열 치환
SELECT REPLACE('Hello World', 'World', 'MySQL'); -- Hello MySQL
-- 패딩
SELECT lpad('test', 5, '*'), -- *test 
	rpad('test', 7, '?');  -- tset???


-- 활용
SELECT
   deptno as 부서번호,
   empno as 사번, 
   ifnull(mgr, 7839) as 책임자, 
   job as 직급, 
   concat(ename, '님') as 사원명,
   hiredate as 입사일,
   concat(
	   abs(timestampdiff(year, hiredate, curdate())),
       "년"
   ) as 년차, 
   concat(floor(sal), '만원') as 연봉, 
   concat(floor(ifnull(comm, 0)), '만원') as 상여금
   FROM emp
   ORDER BY deptno asc;
   
   
/* 날짜 */

-- 현재날짜, 시간 등
SELECT curdate(), curtime(), now();
-- yyyy-mm-dd | hh:mm:ss | yyyy-mm-dd hh:mm:ss

-- 년월일 포맷팅
SELECT date_format(now(), '%y년 %m월 %d일');

   
-- 오늘 날짜와 시간
SELECT curdate() as 금일날짜, curtime() as 현재시간;

-- date_format : 몇년, 몇월, 몇일
SELECT 
    date_format(curdate(), '%Y년') as 년도, -- 2025년
    date_format(curdate(), '%m월') as 월, -- 09일
    date_format(curdate(), '%d일') as 일; -- 10일

-- 날짜연산 : date_add, date_sub
SELECT
	curdate() as 오늘날짜, 
	date_add(curdate(), interval 200 day) as '200일 후',
    date_sub(curdate(), interval 100 day) as '100일 전'; 
    -- 2025-09-10 | 2026-03-29 | 2025-06-02
    

-- 날짜차이 : datediff (일), timestampdiff(기준)
SELECT
	curdate() as 오늘날짜,
	abs(datediff('2024-01-01', now())) as '일차이',
    abs(timestampdiff(month, '2024-01-01', curdate())) as '월차이',
    abs(timestampdiff(year, '2024-01-01', curdate())) as '년도차이';
    -- 618 | 20 | 1
    

-- count: 행 개수
SELECT count(*) FROM emp; -- 전체 행 개수 : 14
SELECT count(comm) FROM emp; -- NULL 제외 행 개수

-- sum: 합계
SELECT sum(sal) as 총인건비 FROM emp; 
-- 29025.00

-- avg: 평균
SELECT avg(sal) as 평균인건비 FROM emp; 
-- 2073.214286

-- max, min: 최대값, 최소값
SELECT max(sal) as 최고연봉액, 
	min(sal) as 최저연금액 FROM emp;
    -- 5000.00 | 800.00


-- 직급별 평균연봉액
SELECT job, avg(sal) FROM emp
	GROUP BY job;
    
-- 부서 내 직급별 평균연봉액
SELECT deptno, job, avg(sal) FROM emp
	GROUP BY deptno, job
    ORDER BY 1, 2; -- 첫째,두번째열 (deptno,job) 오름차순


-- 10번 부서 제외 모든 사원ㅁ의 부서별, 직급별 평균 연봉액
-- 단 평균 1000이상

SELECT deptno, job, avg(sal) as 평균연봉액 FROM emp
	WHERE deptno != 10
    GROUP BY deptno, job
    HAVING avg(sal) >= 1000;


SELECT * FROM emp
    WHERE (deptno = 10 or deptno = 20)
    and sal >= 2000;



desc emp;
desc dept;
SELECT * FROM emp;

-- 크로스 조인
-- 모든 가능한 조합이며, 조건 없으면 emp 행수 × dept 행수
SELECT ename, sal, dname FROM emp, dept;
SELECT e.ename, e.sal, d.deptno, d.dname FROM emp e, dept d;
-- 해당 결과는 emp 하나의 행에 각 dept행 만큼 나옴

-- 이너 조인
-- 두 테이블에서 deptno가 일치하는 데이터만
SELECT e.ename, e.sal, d.deptno, d.dname
FROM emp e, dept d
WHERE e.deptno = d.deptno;


-- ansi join 방식 (NATURAL)
SELECT e.ename, e.sal, d.deptno, d.dname 
FROM emp e NATURAL join dept d;

-- JOIN ~ USING (동일한 컬럼명일 때)
SELECT e.ename, e.sal, d.deptno, d.dname 
FROM emp e join dept d USING(deptno);

-- ansi join 방식 (ON)
SELECT e.ename, e.sal, d.deptno, d.dname 
FROM emp e join dept d ON e.deptno = d.deptno;


-- 추가조건방식
SELECT e.ename, e.sal, d.deptno, d.dname 
FROM emp e, dept d
WHERE e.deptno = d.deptno
and e.deptno = 20;

SELECT e.ename, e.sal, d.deptno, d.dname 
FROM emp e NATURAL join dept d
WHERE e.deptno = 20;