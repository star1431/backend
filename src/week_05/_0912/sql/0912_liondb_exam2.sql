SELECT * FROM A;
SELECT * FROM B;

-- 컬럼 추가
ALTER TABLE A ADD COLUMN age INT;

-- 컬럼 수정
ALTER TABLE A MODIFY COLUMN age VARCHAR(50);

-- 컬럼 이름 변경
ALTER TABLE A CHANGE COLUMN name user_name INT;

-- 컬럼 삭제
ALTER TABLE A DROP COLUMN age;

-- 외래키 추가
ALTER TABLE A ADD CONSTRAINT fk_a_b FOREIGN KEY (user_name) REFERENCES B(name);

-- 인덱스 추가
CREATE INDEX idx_a_name ON A(user_name);

-- 제약조건 삭제
ALTER TABLE A DROP FOREIGN KEY fk_a_b;







-- 컬럼 추가 (B 테이블의 id를 참조할 외래키용 컬럼)
ALTER TABLE A ADD COLUMN b_id INT;

-- 컬럼 수정 (예: b_id를 NOT NULL로 변경)
ALTER TABLE A MODIFY COLUMN b_id INT NOT NULL;

-- 컬럼 이름 변경 (name → user_name)
ALTER TABLE A CHANGE COLUMN name user_name VARCHAR(50);

-- 컬럼 삭제 (예: user_name 컬럼 삭제)
ALTER TABLE A DROP COLUMN user_name;

-- 외래키 추가 (A.b_id → B.name 컬럼 참조)
ALTER TABLE A
    ADD CONSTRAINT fk_a_b FOREIGN KEY (b_id) REFERENCES B(name);

-- 인덱스 추가 (검색 빠르게 하려고 b_id에 인덱스 생성)
CREATE INDEX idx_a_b_id ON A(b_id);

-- 제약조건 삭제 (외래키 제거)
ALTER TABLE A DROP FOREIGN KEY fk_a_b;