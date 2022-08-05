CREATE TABLE IF NOT EXISTS product_positions
(
    id    INTEGER PRIMARY KEY ,
    name  VARCHAR(200) NOT NULL ,
    description VARCHAR(254) NOT NULL ,
    price BIGINT  NOT NULL
);

CREATE SEQUENCE IF NOT EXISTS products_id_seq
    INCREMENT 1
    START 3
    OWNED BY product_positions.id;

CREATE TABLE IF NOT EXISTS product_objects
(
    id    uuid  PRIMARY KEY,
    receive_date  DATE default now(),
    expiration_date DATE NOT NULL,
    serial_num INTEGER NOT NULL,
    isDefective BOOLEAN default FALSE,
    product_id INTEGER,
    additional_info VARCHAR(1000) NOT NULL,
    FOREIGN KEY(product_id) REFERENCES product_positions(id)
);
-- CREATE SEQUENCE products_id_seq START WITH 3 INCREMENT BY 1;