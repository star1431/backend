SELECT @@version, @@version_comment, @@hostname, @@port, @@datadir;
SHOW TABLES FROM mysql LIKE 'default_roles';
SELECT USER() AS login_user, CURRENT_USER() AS effective_user, DATABASE() AS current_schema;






/* 유저생성, 권한부여 --------------------- */

-- 유저생성
CREATE USER 'star1431'@'%' IDENTIFIED BY 'star1431';
CREATE USER 'lion'@'%' IDENTIFIED BY 'lion1234';
CREATE USER 'hr'@'%' IDENTIFIED BY 'hr1234';


SELECT USER();
CREATE DATABASE likedb;

SHOW DATABASES;

USE mysql;

-- 권한부여
GRANT ALL PRIVILEGES on likedb.* to 'lion'@'%';
GRANT ALL PRIVILEGES on likedb.* to 'star1431'@'%';
commit;

FLUSH PRIVILEGES;


/* 사용자 확인 삭제 --------------- */

-- 유저 정보보기
SELECT user,host FROM mysql.user WHERE user = 'star1431';
SELECT user,host FROM mysql.user WHERE user = 'hr';

-- 유저 삭제
DROP user 'lion'@'localhost';


/* 권한 취소 --------------- */
SHOW GRANTS FOR 'lion'@'%';
SHOW GRANTS FOR 'star1431'@'%';

-- 모든 권한 취소
REVOKE ALL PRIVILEGES ON likedb.* FROM 'lion'@'%';

-- 특정 권한만 취소
REVOKE INSERT, UPDATE ON liondb.* FROM 'lion'@'%';

FLUSH PRIVILEGES;

/* 모든 유저 정보 ------------ */
SELECT user,host FROM mysql.user;
SELECT * FROM mysql.user;

SHOW TABLES FROM liondb;

SELECT * FROM liondb.test_table;





/* 뭐가먼지 모르곘당 ------------- */
-- A) 읽기 전용 계정 (DB 단위)
GRANT SELECT ON likedb.* TO 'lion'@'%';

-- B) 개발 계정 (DML + DDL 일부)
GRANT SELECT, INSERT, UPDATE, DELETE, CREATE, ALTER
ON likedb.* TO 'lion'@'%';

-- C) 특정 테이블만 권한
GRANT SELECT ON likedb.emp TO 'lion'@'%';

-- D) 특정 열만 UPDATE 가능
GRANT UPDATE (sal, comm) ON likedb.emp TO 'lion'@'%';

-- E) 루틴 실행
GRANT EXECUTE ON PROCEDURE likedb.raise_bonus TO 'lion'@'%';

-- F) 권한 회수(특정 DB만)
REVOKE ALL PRIVILEGES ON likedb.* FROM 'lion'@'%';

-- G) 확인
SHOW GRANTS FOR 'dev'@'%';



