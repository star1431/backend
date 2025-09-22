USE minimoviedb;
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
