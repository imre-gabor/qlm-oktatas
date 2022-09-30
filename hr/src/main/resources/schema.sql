CREATE TABLE employee
(
    id serial primary key,
    name varchar(255),
    job varchar(255),
    salary integer NOT NULL,
    works_since timestamp without time zone
);


CREATE TABLE hr_user
(
    username varchar(255) primary key,
    password varchar(255)
);