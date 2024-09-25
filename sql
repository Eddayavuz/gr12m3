CREATE DATABASE company;

CREATE TABLE company.employee(
id int,
name varchar(255));

CREATE TABLE company.products(
id int,
name varchar(255),
quantity int);

CREATE TABLE company.customers(
id int,
name varchar(255),
address text
);

INSERT INTO company.products VALUES
(1, 'Watermelon', 5), 
(2, 'Frigde', 10), 
(3, 'Macbook', 5), 
(4, 'Nail polish', 20);


INSERT INTO company.employee VALUES
(1, 'Eda'), 
(2, 'Ece'), 
(3, 'Ebru'), 
(4, 'Esra');

INSERT INTO company.customers VALUES
(1, 'Eda', 'Sofia'), 
(2, 'Ece', 'Eindhoven'), 
(3, 'Ebru', 'Istanbul'), 
(4, 'Esra', 'istanbul');

UPDATE company.customers
SET address = 'Eindhoven'
WHERE name = 'Eda';

DELETE FROM company.customers
WHERE name = 'Esra';
