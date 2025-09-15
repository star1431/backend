SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS reserved_seat, seats, movies, age_grade;
SET FOREIGN_KEY_CHECKS = 1;

-- table : 관람등급  
CREATE TABLE age_grade (
    code_name	varchar(3) PRIMARY KEY,
    label 		varchar(30)
);
INSERT into age_grade VALUE 
	('ALL', '전체 이용가'),
	('R12', '12세 이용가'),
	('R15', '15세 이용가'),
	('R19', '청소년 관람불가')
    ;
    
-- table : 무비
CREATE TABLE movies (
	id 			int	        	PRIMARY KEY AUTO_INCREMENT,
    title		varchar(100)    UNIQUE NOT NULL,
    age_grade 	varchar(3)		NOT NULL,
    genre   	varchar(30) 	NOT NULL,
    price		int		    	CHECK (price >= 0) DEFAULT 10000,
    FOREIGN KEY (age_grade) REFERENCES age_grade(code_name) -- 외래키 제약
);
INSERT into movies VALUE 
	(null, '어벤져스-엔드게임', 'R15', '히어로', 12000),
	(null, '범죄도시', 'R19', '액션', 13000),
	(null, '겨울왕국', 'ALL', '애니메이션', 10000),
	(null, '기생충', 'R15', '드라마', 11000),
	(null, '인터스텔라', 'R12', 'SF', 11000)
    ;



-- table : 좌석 // 고민중....!
CREATE TABLE seats (
	id 				int    	PRIMARY KEY AUTO_INCREMENT,
	row_num			int		CHECK(row_num > 0) DEFAULT 6,
	col_num			int		CHECK(col_num > 0) DEFAULT 6,
    reserved_code 	text
);


-- table : 예약좌석 (영화id, 코드번호)
CREATE TABLE reserved_seat (
  movie_id  INT NOT NULL,
  seat_code VARCHAR(5) NOT NULL,
  PRIMARY KEY (movie_id, seat_code),  -- 중복예약 차단
  FOREIGN KEY (movie_id) REFERENCES movies(id) -- 외래키 제약
);

INSERT INTO reserved_seat (movie_id, seat_code) VALUES	
	(1,'A1'),(1,'A2'),(1,'B3');

INSERT INTO reserved_seat (movie_id, seat_code) VALUES
	(3,'C1'),(3,'C2');

INSERT INTO reserved_seat (movie_id, seat_code) VALUES
	(4,'A1'),(4,'C3'),(4,'A2'),(4,'B4'),(4,'D6'),(4,'B5'),(4,'D1'),(4,'C2');

INSERT INTO reserved_seat (movie_id, seat_code) VALUES
	(5,'D1'),(5,'A1'),(5,'B2'),(5,'C3'),(5,'A2'),(5,'B3'),(5,'C4'),
	(5,'A3'),(5,'B4'),(5,'A4'),(5,'B5'),(5,'A5'),(5,'A6');


-- SHOW TABLES

commit;

SELECT * FROM movies;
SELECT * FROM age_grade;
SELECT * FROM reserved_seat;

SELECT movie_id, group_concat(seat_code ORDER BY seat_code) FROM reserved_seat
	GROUP BY movie_id;

-- 매핑확인
SELECT
	m.id, concat('M-', lpad(m.id, '4', 0)) as '영화 ID',
    m.title as '영화제목', ag.label as'관람등급', 
    m.genre as '장르', m.price as '가격',
    rs.좌석합침 as '예매된 좌석'
	FROM movies m
    -- 관람등급
	LEFT JOIN age_grade as ag 
	ON ag.code_name = m.age_grade
    -- 예약좌석
    LEFT JOIN (
		SELECT movie_id, group_concat(seat_code ORDER BY seat_code) as '좌석합침' 
			FROM reserved_seat
			GROUP BY movie_id
    ) as rs
    ON rs.movie_id = m.id;
