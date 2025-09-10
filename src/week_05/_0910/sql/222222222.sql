CREATE TABLE dept ( -- 부서 테이블
	deptno	int  NOT NULL  AUTO_INCREMENT,
	dname	varchar(20),
	loc		varchar(20),
	CONSTRAINT pk_dept PRIMARY KEY ( deptno )
 ) engine=InnoDB;

CREATE TABLE emp ( -- 직원 테이블
	empno	int  NOT NULL  AUTO_INCREMENT,
	ename	varchar(20),
	job		varchar(20),
	mgr		smallint,
	hiredate	date,
	sal		numeric(7,2),
	comm	numeric(7,2),
	deptno	int,
	CONSTRAINT pk_emp PRIMARY KEY ( empno )
 ) engine=InnoDB;