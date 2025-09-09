-- 버전확인
SELECT version();

-- db 목록
SHOW DATABASES;

-- 현재 사용자 확인
SELECT user();

-- 모든 사용자 정보 확인
SELECT user,host FROM mysql.user;

-- 특정 사용자
SELECT user, host FROM mysql.user WHERE user = 'lion';

-- db 생성
CREATE DATABASE lion2db;

-- db 삭제
DROP DATABASE lion2db;

-- 사용자 생성
CREATE USER 'lion2'@'%' IDENTIFIED by '1234';
/*
	'lion'@'%' = 사용자명 / IDENTIFIED by '1234' 사용자PW
    % = 모든 호스트 접근가능
    localhost = 로컬 (127.0.0.1)
    ip_addr = 특정 ip 가능
*/

-- 사용자 삭제
DROP USER 'lion2'@'%';

-- 테이블 생성
USE testdb; -- db 사용

CREATE TABLE test_table (
    id INT AUTO_INCREMENT PRIMARY KEY,  -- 프라이머리키 + 자동증가
    name VARCHAR(50), -- name 글자 50자 제한
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP -- 생성된 타이머 삽입
);

-- 사용자 db권한 확인
SHOW GRANTS FOR 'test'@'%';

-- 사용자 db권한 지정

-- A) 
GRANT ALL PRIVILEGES ON testdb.* TO 'test'@'%';

-- B) 읽기 전용 계정 (DB 단위)
GRANT SELECT ON likedb.* TO 'lion'@'%';

-- C) 개발 계정 (DML + DDL 일부)
GRANT SELECT, INSERT, UPDATE, DELETE, CREATE, ALTER
ON likedb.* TO 'lion'@'%';

-- D) 특정 테이블만 권한
GRANT SELECT ON likedb.emp TO 'lion'@'%';

-- E) 특정 열만 UPDATE 가능
GRANT UPDATE (sal, comm) ON likedb.emp TO 'lion'@'%';

-- F) 해당 db 권한 취소
REVOKE ALL PRIVILEGES ON testdb.* FROM 'test'@'%';

-- 권한 적용
FLUSH PRIVILEGES;

