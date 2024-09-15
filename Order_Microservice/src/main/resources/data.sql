-- Sample data for CustomerOrder (including embedded Address fields)
INSERT INTO customer_order (id, customerid, paid, street, state, country, post_code, f_name, l_name)
VALUES (1, 1, false, '123 Main St', 'CA', 'USA', '90001', 'John', 'Doe');

INSERT INTO customer_order (id, customerid, paid, street, state, country, post_code, f_name, l_name)
VALUES (2, 2, true, '456 Market St', 'NY', 'USA', '10001', 'Jane', 'Smith');

INSERT INTO customer_order (id, customerid, paid, street, state, country, post_code, f_name, l_name)
VALUES (3, 3, false, '789 Broadway', 'TX', 'USA', '75001', 'Tom', 'Brown');

INSERT INTO customer_order (id, customerid, paid, street, state, country, post_code, f_name, l_name)
VALUES (4, 4, true, '101 Pine St', 'FL', 'USA', '33101', 'Lucy', 'White');

-- Sample data for ProductInfo
INSERT INTO product_info (id, product_id, full_name, quantity)
VALUES (1, 101, 'Laptop', 2);

INSERT INTO product_info (id, product_id, full_name, quantity)
VALUES (2, 102, 'Smartphone', 1);

INSERT INTO product_info (id, product_id, full_name, quantity)
VALUES (3, 103, 'Tablet', 3);

INSERT INTO product_info (id, product_id, full_name, quantity)
VALUES (4, 104, 'Smartwatch', 5);

-- Link the products to the customer orders
-- Using customer_order_included_products table for many-to-many relationship
INSERT INTO customer_order_included_products (customer_order_id, included_products_id)
VALUES (1, 1);  -- John Doe's order includes a Laptop

INSERT INTO customer_order_included_products (customer_order_id, included_products_id)
VALUES (2, 2);  -- Jane Smith's order includes a Smartphone

INSERT INTO customer_order_included_products (customer_order_id, included_products_id)
VALUES (3, 3);  -- Tom Brown's order includes a Tablet

INSERT INTO customer_order_included_products (customer_order_id, included_products_id)
VALUES (4, 4);  -- Lucy White's order includes a Smartwatch

-- Sample data for Shipped (Shipping details for the placed order)
INSERT INTO shipped (id, order_id, delivered)
VALUES (1, 1, false);  -- John Doe's order is not yet delivered

INSERT INTO shipped (id, order_id, delivered)
VALUES (2, 2, true);   -- Jane Smith's order has been delivered

INSERT INTO shipped (id, order_id, delivered)
VALUES (3, 3, false);  -- Tom Brown's order is not yet delivered

INSERT INTO shipped (id, order_id, delivered)
VALUES (4, 4, true);   -- Lucy White's order has been delivered
