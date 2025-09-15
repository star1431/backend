
show databases;

use likedb;

DROP TABLE IF EXISTS user;

CREATE TABLE user (
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    email VARCHAR(255) NOT NULL UNIQUE,
    name VARCHAR(50) NOT NULL,
    password VARCHAR(500) NOT NULL,
    regdate TIMESTAMP DEFAULT NOW(),
    INDEX idx_email (email)
);

DROP TABLE IF EXISTS role;

CREATE TABLE role (
    role_id INT PRIMARY KEY,
    name VARCHAR(20) NOT NULL
);

-- 기본 권한 데이터
INSERT INTO role(role_id, name) VALUES
(1, 'ROLE_USER'),
(2, 'ROLE_ADMIN');

DROP TABLE IF EXISTS board;

CREATE TABLE board (
    board_id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(100) NOT NULL,
    content TEXT NULL,
    user_id INT NOT NULL,
    regdate TIMESTAMP DEFAULT NOW(),
    view_cnt INT DEFAULT 0,
    FOREIGN KEY (user_id) REFERENCES user(user_id),
    INDEX idx_regdate (regdate DESC)
);

commit;