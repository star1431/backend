   
/*db 설계 */
-- 스키마 : 학생 / id, name, age, email, created_date
CREATE TABLE students (
	id 		int             PRIMARY KEY AUTO_INCREMENT, -- 기본키, 자동 증가 (반드시 존재)
    name 	varchar(20)     NOT NULL, -- null 허용 X
    age 	smallint        CHECK ( age > 0 and age <= 150 ), -- 범위 체크
    email	varchar(100)    UNIQUE,  -- 중복 허용 X
	created_date  datetime  DEFAULT CURRENT_TIMESTAMP
    -- 인설트할 때 빈값인 경우 기본값 현재날짜시간로 지정
);

INSERT into students(name,age,email) VALUE('짱구', 8, '짱구123@gmail.com');
INSERT into students VALUE(null, '철수', 12, '철수123@gmail.com', curdate());


SHOW TABLES;
desc students;

SELECT * FROM students;
DROP TABLE students;


-- 스키마 : 상품 (id, name, price, reg_date)
CREATE TABLE products (
	id 			int 			PRIMARY KEY AUTO_INCREMENT,
    name 		varchar(150) 	UNIQUE NOT NULL,
    price 		int 			CHECK(price >= 0),
    reg_date 	datetime
);

SHOW TABLES;
DROP TABLE products;
desc products;

INSERT into products(name,price) VALUE('pen', 3000);
INSERT into products VALUE(null, 'pen2', 3000, null);



SELECT * FROM products;