SHOW DATABASES ;
USE miniprojectDB;


SHOW GRANTS FOR 'star1431'@'%';

GRANT ALL PRIVILEGES on miniprojectDB.* to 'star1431'@'%';
FLUSH PRIVILEGES;

SELECT * FROM movies;
commit;


ALTER TABLE movies AUTO_INCREMENT = 1;
