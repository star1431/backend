/* ==== 서버/세션 정보 조회 ==== */
SELECT version(); 	-- MySQL 버전
SHOW DATABASES; 	-- DB(스키마) 목록
SELECT user();		-- 현재 사용자정보
SELECT DATABASE();  -- 현재 스키마


/* ==== 데이터베이스 ==== */
CREATE DATABASE mydb;	-- db 생성
DROP DATABASE mydb;		-- db 삭제
USE mydb;				-- 해당 스키마 전환

/* ==== 테이블 === */
SHOW TABLES;            -- 현재 스키마 테이블 목록
SHOW TABLES FROM my2db;  -- 특정 스키마 테이블 목록
SELECT * FROM my2db.table_name; -- 스키마 테이블 정보

/* ==== 테이블 생성 === */
CREATE TABLE test_table (
    id INT AUTO_INCREMENT PRIMARY KEY,  -- 프라이머리키 + 1씩 자동증가
    name VARCHAR(50), -- name 글자 50자 제한
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP -- 생성된 타이머 삽입
);

CREATE TABLE emp ( -- 직원 테이블
	empno                int  NOT NULL  AUTO_INCREMENT, -- 정수, NULL 불가, 1씩 자동증가
	ename                varchar(20),
	job      			 varchar(20),
	mgr                  smallint, 			-- 작은 정수(대략 -32768~32767)
	hiredate             date, 				-- YYYY-MM-DD
	sal                  numeric(7,2),		-- 소수 둘째자리
	comm                 numeric(7,2),
	deptno               int, 				-- 정수, 외래키
	CONSTRAINT pk_emp PRIMARY KEY ( empno ) -- 기본키: empno 고유/중복불가/인덱스 자동생성
 ) engine=InnoDB; 	-- InnoDB 엔진 (트랜잭션/외래키/행잠금 지원)


/* ==== 사용자 ==== */
-- 유저 호스트 정보
SELECT user, host FROM mysql.user;

-- 유저 생성
CREATE USER'test'@'%' IDENTIFIED by '1234';

-- 비밀번호 변경
ALTER USER 'test'@'%' IDENTIFIED by '4321';

-- 사용자 삭제            
DROP USER 'test'@'%';

-- 사용자 권한 확인
SHOW GRANTS for 'test'@'%';


/* ==== 권한 부여 ==== */
-- 해당 스키마 전체 권한 설정
GRANT ALL PRIVILEGES ON my.* to 'hr'@'%';

-- 읽기 전용 권한 설정
GRANT SELECT ON mydb.* to 'reader'@'%';

-- DML 만 사용
GRANT SELECT, INSERT, UPDATE, DELETE ON mydb.* to 'test'@'%';

-- 개발자 예시 ( DML, DDL 일부 포함)
GRANT SELECT, INSERT, UPDATE, DELETE, CREATE, ALTER, INDEX
ON mydb.* to 'test'@'%';

-- 특정 테이블만 허용
GRANT SELECT ON mydb.orders to 'test'@'%';

-- 특정 열만 UPDATE 허용
GRANT UPDATE (attr_name1, attr_name2) ON mydb.orders to 'test'@'%';

/* ==== 권한 회수 ==== */
-- 해당 스키마 전체 권한 회수
REVOKE ALL PRIVILEGES ON mydb.* FROM 'test'@'%';

-- 권한 회수(일부만)
REVOKE INSERT, UPDATE ON mydb.* FROM 'test'@'%';

-- 위임권 회수
REVOKE GRANT OPTION ON mydb.* FROM 'test'@'%';


/* ==== 권한 확인 및 적용 ==== */
-- 최종 확인
SHOW GRANTS FOR 'test'@'%';

-- 권한 적용
FLUSH PRIVILEGES;

