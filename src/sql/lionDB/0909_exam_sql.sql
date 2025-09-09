/* 테이블 생성 */
CREATE TABLE test_table (
	/* id 자동증가 및 기본키 */
    id INT AUTO_INCREMENT PRIMARY KEY, 
    /* 이름(50자) */
    name VARCHAR(50), 
    /* 생성시간 자동 기록 */
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

/* 테이블 목록 */
show tables;

/* 데이터 넣기 */
INSERT INTO test_table (name) VALUES ('테스트');

/* 테이블 내용 보기 */
SELECT * FROM test_table;

/* id key값 기준 행 제거 */
DELETE FROM test_table WHERE id IN (2, 3, 4); 

/* ------------------------------------------------------ */
