use ecommerce;

-- drop the databases
DROP table orders;
DROP table customers;
DROP table products;

-- customer database 
create table customers (
customer_id MEDIUMINT not null auto_increment primary key,
first_name VARCHARACTER(45),
middle_name CHARACTER,
last_name VARCHARACTER(75)
);

-- product database
create table products (
product_id MEDIUMINT not null auto_increment primary key,
product_name VARCHARACTER(100)
);

-- order database
create table orders (
order_id MEDIUMINT not null,
customer_id MEDIUMINT not null,
product_id MEDIUMINT not null,
FOREIGN key (customer_id) REFERENCES customers(customer_id),
FOREIGN key (product_id) REFERENCES products(product_id)
);

-- delete customer database
DELETE FROM orders;
DELETE FROM customers;
DELETE FROM products;

-- add one customer
INSERT into customers
VALUES (null,'ted','h','jacob');
INSERT into customers
VALUES (null,'fred','i','fracob');
INSERT into customers
VALUES (null,'ed','j','acob');
INSERT into customers
VALUES (null,'ned','k','nacob');
INSERT into customers
VALUES (null,'sted','j','stacob');

-- add one product
INSERT into products
VALUES (null,'bluetooth speaker');
INSERT into products
VALUES (null,'headphones');
INSERT into products
VALUES (null,'ipad');
INSERT into products
VALUES (null,'iphone');
INSERT into products
VALUES (null,'led light pack');

-- add one order
INSERT into orders
VALUES (1,1,1);
INSERT into orders
VALUES (1,1,2);
INSERT into orders
VALUES (2,2,3);
INSERT into orders
VALUES (2,2,4);
INSERT into orders
VALUES (2,2,5);