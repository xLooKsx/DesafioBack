CREATE DATABASE "desafioBack"
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'Portuguese_Brazil.1252'
       LC_CTYPE = 'Portuguese_Brazil.1252'
       CONNECTION LIMIT = -1;

COMMENT ON DATABASE "desafioBack"
  IS 'user: postgres
senha: admin';

CREATE SEQUENCE id_customer START 1;

CREATE TABLE tb_customer_account(
 id_customer int primary key,
 cpf_cnpj varchar(14) unique,
 nm_cliente varchar(50),
 is_active int default 1,
 vl_total double precision
);

SELECT * FROM tb_customer_account 

INSERT INTO tb_customer_account 
		VALUES(nextval('id_customer'), '123456789', 'Lucas', 1, 100.56 )
			(nextval('id_customer'), '123456780', 'Luana', 1, 200.56 ),
			(nextval('id_customer'), '1234567809', 'Maria', 1, 400.56 ),
			(nextval('id_customer'), '123456749', 'Joao', 1, 600.56 ),
			(nextval('id_customer'), '123456779', 'Mario', 1, 800.56 ),
			(nextval('id_customer'), '123456769', 'Matheus', 1, 1000.56 ),
			(nextval('id_customer'), '123456729', 'Natasha', 1, 150.56 );

