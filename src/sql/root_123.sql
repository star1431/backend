
CREATE DATABASE miniprojectDB;
SHOW DATABASES;
GRANT ALL PRIVILEGES on miniprojectDB.* to 'star1431'@'%';
SHOW GRANTS FOR 'star1431'@'%';

SHOW DATABASES LIKE 'miniprojdb';
FLUSH PRIVILEGES;


ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'dwarf123ab@';

ALTER USER 'root'@'localhost' IDENTIFIED BY 'dwarf123ab@';
ALTER USER 'root'@'localhost' IDENTIFIED WITH caching_sha2_password BY 'dwarf123ab@';
FLUSH PRIVILEGES;


SELECT user, host, plugin
FROM mysql.user
WHERE user = 'root';

commit;
ALTER USER 'root'@'%' ACCOUNT LOCK;
FLUSH PRIVILEGES;

SELECT user, host, account_locked
FROM mysql.user
WHERE user='root';