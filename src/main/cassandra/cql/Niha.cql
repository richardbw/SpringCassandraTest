
CREATE KEYSPACE work WITH REPLICATION = { 'class' : 'SimpleStrategy','replication_factor': 3};
DESCRIBE KEYSPACE work;
USE work;

CREATE TABLE IF NOT EXISTS employees (
    id uuid, 
    name varchar,
    email varchar, 
    PRIMARY KEY (id,email)
);
INSERT INTO  employees (id,name,email) VALUES (now(),'abc','abc@gmail.com');
