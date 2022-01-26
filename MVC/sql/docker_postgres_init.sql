CREATE DATABASE springmvc
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'en_US.utf8'
    LC_CTYPE = 'en_US.utf8'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

\connect springmvc;

CREATE TABLE IF NOT EXISTS Person (
                                      id SERIAL NOT NULL,
                                      name varchar,
                                      age int,
                                      email varchar
);

INSERT INTO Person (id, name, age, email)
VALUES (default, 'Dennis', 23, 'den@springmvc.ru');

INSERT INTO Person (id, name, age, email)
VALUES (default, 'Nikita', 24, 'nik@springmvc.ru');

INSERT INTO Person (id, name, age, email)
VALUES (default, 'Ivan', 52, 'ivan@springmvc.ru');