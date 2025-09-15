
CREATE TABLE books (
    pk_id   int PRIMARY KEY AUTO_INCREMENT,
    isbn    varchar(20) UNIQUE NOT NULL,
    bname   varchar(100) UNIQUE NOT NULL,
    author  varchar(30) NOT NULL,
    price   int CHECK ( price >= 0),
    cr_date DATE DEFAULT (curdate())
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
-- ENGINE=InnoDB → 트랜잭션, FK 제약조건 지원
-- DEFAULT CHARSET=utf8mb4 → 한글 + 이모지까지 안전하게 저장


-- 추가
INSERT INTO books (isbn, bname, author, price, cr_date) VALUES
('11-0001', '개미', '베르나르 베르베르', 15000, '1993-01-01'),
('11-0002', '나무', '베르나르 베르베르', 15000, '1995-01-01'),
('11-0003', '파피용', '베르나르 베르베르', 15000, '2000-01-01'),
('12-0001', '용의자 X의 헌신', '히가시노 게이고', 14000, '2005-08-29'),
('12-0002', '백야행', '히가시노 게이고', 16000, '1999-01-01'),
('12-0003', '나미야 잡화점의 기적', '히가시노 게이고', 15000, '2012-03-28'),
('13-0001', '채식주의자', '한강', 12000, '2007-10-30'),
('13-0002', '소년이 온다', '한강', 13000, '2014-05-19'),
('13-0003', '흰', '한강', 14000, '2016-09-01');

-- 수정
UPDATE books SET bname = '흰2' WHERE isbn = '13-0003';
UPDATE books SET bname = '나무2', author = '베르나르 베르베르 2세' WHERE pk_id = 2;

-- 삭제
DELETE FROM books WHERE isbn = '13-0001';

SELECT * FROM books;

-- 인덱스 추가
CREATE INDEX books_author_idx
    ON books(author);

-- 인덱스 확인
SHOW INDEX FROM books;

-- 인덱스 삭제
ALTER TABLE books
    DROP INDEX books_author_idx;

-- 복합 인덱스
CREATE INDEX books_muti_idx
    ON books(isbn, bname);


ALTER TABLE books
    DROP INDEX books_muti_idx;


-- 인덱스 사용 전
EXPLAIN SELECT * FROM books
        WHERE author = '히가시노 게이고';

-- 인덱스 생성
CREATE INDEX books_author_idx
    ON books(author);

-- 인덱스 사용 후
EXPLAIN SELECT * FROM books
        WHERE author = '히가시노 게이고';



SELECT * FROM books;

commit;

