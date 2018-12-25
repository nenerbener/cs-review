-- query all three tables with Name, Order and Product Ordered
select customers.last_name as 'Name', orders.order_id as 'Order', products.product_name as 'Product'
from customers
left join orders on orders.customer_id=customers.customer_id
left join products on products.product_id=orders.product_id;

-- query all three tables with Name, Order and Product Ordered. Joint first, middle and last name
select CONCAT(customers.first_name," ",customers.middle_name," ",customers.last_name) as 'Name', orders.order_id as 'Order', products.product_name as 'Product'
from customers
left join orders on orders.customer_id=customers.customer_id
left join products on products.product_id=orders.product_id;

-- query all three tables with Name, Order and Product Ordered. Joint first, middle and last name where last name is jacob
select CONCAT(customers.first_name," ",customers.middle_name," ",customers.last_name) as 'Name', orders.order_id as 'Order', products.product_name as 'Product'
from customers
left join orders on orders.customer_id=customers.customer_id
left join products on products.product_id=orders.product_id
where customers.last_name = 'jacob';