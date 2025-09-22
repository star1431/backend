
-- CREATE DATABASE minimoviedb;
-- GRANT ALL PRIVILEGES on minimoviedb.* to 'star1431'@'%';
-- SHOW GRANTS FOR 'star1431'@'%';
USE minimoviedb;

-- SET FOREIGN_KEY_CHECKS = 0;
-- DROP TABLE IF EXISTS reserved_seat, seats, movies, age_grade;
-- SET FOREIGN_KEY_CHECKS = 1;


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
    id 			int	        	PRIMARY KEY AUTO_INCREMENT, -- 삭제 추가 반복되면 아이디는 계속 누적
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



-- table : 좌석
CREATE TABLE seats (
    movie_id        int    	PRIMARY KEY NOT NULL,
    row_num			int		CHECK(10 > row_num > 0) NOT NULL DEFAULT 6,
    col_num			int		CHECK(10 > col_num > 0) NOT NULL DEFAULT 6,
    FOREIGN KEY (movie_id) REFERENCES movies(id) ON DELETE CASCADE
);

INSERT into seats(movie_id,row_num,col_num) VALUE
(1, 5, 6),
(2, 6, 6),
(3, 5, 5),
(4, 4, 4),
(5, 6, 6)
;

-- table : 예약좌석 (영화id, 코드번호)
CREATE TABLE reserved_seat (
    movie_id  INT NOT NULL,
    seat_code VARCHAR(5) NOT NULL,
    PRIMARY KEY (movie_id, seat_code),  -- 중복예약 차단
    FOREIGN KEY (movie_id) REFERENCES seats(movie_id) ON DELETE CASCADE -- 외래키 제약
);

INSERT INTO reserved_seat (movie_id, seat_code) VALUES
(1,'A1'),(1,'A2'),
(1,'B3');

INSERT INTO reserved_seat (movie_id, seat_code) VALUES
(3,'C1'),(3,'C2');

INSERT INTO reserved_seat (movie_id, seat_code) VALUES
(4,'A1'),(4,'C3'),
(4,'A2'),(4,'B4'),
(4,'D1'),(4,'C2');

INSERT INTO reserved_seat (movie_id, seat_code) VALUES
(5,'D1'),(5,'A1'),
(5,'B2'),(5,'C3'),
(5,'A2'),(5,'B3'),
(5,'C4'),
(5,'A3'),(5,'B4'),
(5,'A4'),(5,'B5'),
(5,'A5'),(5,'A6');


-- SHOW TABLES

commit;
