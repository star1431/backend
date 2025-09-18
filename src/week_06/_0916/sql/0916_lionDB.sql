SHOW DATABASES;
USE minprojdb;
SHOW TABLES;


SHOW TABLES FROM liondb;

DESC  products;
SELECT  * FROM movies;

ALTER TABLE products AUTO_INCREMENT = 1;


# ALTER TABLE products
#     MODIFY COLUMN reg_date DATETIME DEFAULT CURRENT_TIMESTAMP;

# UPDATE products
# SET reg_date = NOW()
# WHERE reg_date IS NULL;
CREATE TABLE products (
    id 			int 			PRIMARY KEY AUTO_INCREMENT,
    name 		varchar(150) 	UNIQUE NOT NULL,
    price 		int 			CHECK(price >= 0),
    reg_date 	datetime 		DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO products(name,price) VALUE('pen', 3000);
INSERT INTO products VALUE(null, 'pen2', 3000 , now());









commit;