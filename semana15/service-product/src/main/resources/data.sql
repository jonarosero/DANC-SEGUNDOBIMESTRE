-- Crear la tabla de categorías
CREATE TABLE tbl_categories (
    id INT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

-- Crear la tabla de productos
CREATE TABLE tbl_products (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    stock INT,
    price DECIMAL(10, 2),
    status VARCHAR(50),
    create_at DATE,
    category_id INT,
    FOREIGN KEY (category_id) REFERENCES tbl_categories(id)
);

INSERT INTO tbl_categories (id, name) VALUES (1, 'shoes');
INSERT INTO tbl_categories (id, name) VALUES (2, 'books');
INSERT INTO tbl_categories (id, name) VALUES (3, 'electronics');

INSERT INTO tbl_products (name, description, stock,price,status, create_at,category_id)
VALUES ('adidas Cloudfoam Ultimate','Walk in the air in the black / black CLOUDFOAM ULTIMATE running shoe from ADIDAS',5,178.89,'CREATED','2018-09-05',1);

INSERT INTO tbl_products (name, description, stock,price,status, create_at,category_id)
VALUES ('under armour Men ''s Micro G Assert – 7','under armour Men ''Lightweight mesh upper delivers complete breathability . Durable leather overlays for stability ',4,12.5,'CREATED','2018-09-05',1);


INSERT INTO tbl_products (name, description, stock,price,status, create_at,category_id)
VALUES ('Spring Boot in Action','under armour Men '' Craig Walls is a software developer at Pivotal and is the author of Spring in Action',12,40.06,'CREATED','2018-09-05',2);