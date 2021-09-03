CREATE TABLE IF NOT EXISTS users
(
    id serial PRIMARY KEY NOT NULL,
    name VARCHAR(500) NOT NULL,
    email VARCHAR(500) NOT NULL,
    password_hash VARCHAR(5000) NOT NULL,
    hash_iterations INTEGER NOT NULL,
    is_deleted BOOLEAN NOT NULL
);

CREATE TABLE IF NOT EXISTS units
(
    id serial PRIMARY KEY NOT NULL,
    unit_name VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS product_categories
(
    id serial PRIMARY KEY NOT NULL,
    product_category_name VARCHAR(500)
);

CREATE TABLE IF NOT EXISTS product_sub_categories
(
     id serial PRIMARY KEY NOT NULL,
     product_category_id serial NOT NULL,
     product_sub_category_name VARCHAR(500)
);

CREATE TABLE IF NOT EXISTS manufacturers
(
    id serial PRIMARY KEY NOT NULL,
    manufacturer_name VARCHAR(500)
);

CREATE TABLE IF NOT EXISTS products
(
    id serial PRIMARY KEY NOT NULL,
    product_name VARCHAR(500) NOT NULL,
    product_price REAL NOT NULL,
    description VARCHAR(1000),
    product_subcategory_id serial NOT NULL,
    unit_id serial NOT NULL,
    manufacturer_id serial NOT NULL

);

CREATE TABLE IF NOT EXISTS shopping_cart_items
(
    id serial PRIMARY KEY NOT NULL,
    product_id serial NOT NULL,
    shopping_cart_id serial NOT NULL,
    quantity REAL NOT NULL,
    item_price REAL NOT NULL

);

CREATE TABLE IF NOT EXISTS shopping_carts
(
    id serial PRIMARY KEY NOT NULL,
    user_id serial NOT NULL,
    registered_at DATE NOT NULL

);

CREATE TABLE IF NOT EXISTS order_statuses
(
    id serial PRIMARY KEY NOT NULL,
    status_name VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS orders
(
    id serial PRIMARY KEY NOT NULL,
    user_id serial NOT NULL,
    date_of_order DATE NOT NULL,
    order_status_id serial NOT NULL,
    order_sum REAL NOT NULL,
    is_payed BOOLEAN NOT NULL

);

CREATE TABLE IF NOT EXISTS order_elements
(
    id serial PRIMARY KEY NOT NULL,
    order_id serial NOT NULL,
    product_name VARCHAR(1000) NOT NULL

);
