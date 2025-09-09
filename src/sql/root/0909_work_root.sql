-- db 확인
SHOW DATABASES;

-- db 생성
CREATE DATABASE hr;

-- 유저 생성
CREATE USER 'hr'@'%' IDENTIFIED BY '1234';

-- 유저 목록 보기
SELECT user,host FROM mysql.user;

-- 유저 db권한 지정
GRANT ALL PRIVILEGES ON hr.* TO 'hr'@'%';

-- 유저 권한 확인
SHOW GRANTS FOR 'hr'@'%';

-- 권한 적용
FLUSH PRIVILEGES;

/* -- hr커넥션 후 hr-schema-sql 실행 -- */

-- hr db에 테이블 생성 후 테이블 목록 
SHOW TABLES FROM hr;

-- 각 테이블 확인
SELECT * FROM hr.regions;
SELECT * FROM hr.locations;
SELECT * FROM hr.jobs;
SELECT * FROM hr.job_history;
SELECT * FROM hr.employees;
SELECT * FROM hr.emp_details_view;
SELECT * FROM hr.departments;
SELECT * FROM hr.countries;


