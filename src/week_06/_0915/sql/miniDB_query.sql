SHOW DATABASES ;
USE minprojdb;


SHOW GRANTS FOR 'star1431'@'%';

GRANT ALL PRIVILEGES on minprojdb.* to 'star1431'@'%';
FLUSH PRIVILEGES;

SELECT * FROM movies;
commit;


ALTER TABLE movies AUTO_INCREMENT = 1;
