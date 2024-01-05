-- Crear la tabla de regiones
CREATE TABLE tbl_regions (
    id INT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

-- Insertar datos en la tabla de regiones
INSERT INTO tbl_regions (id, name) VALUES (1, 'Sudamérica');
INSERT INTO tbl_regions (id, name) VALUES (2, 'Centroamérica');
INSERT INTO tbl_regions (id, name) VALUES (3, 'Norteamérica');
INSERT INTO tbl_regions (id, name) VALUES (4, 'Europa');
INSERT INTO tbl_regions (id, name) VALUES (5, 'Asia');
INSERT INTO tbl_regions (id, name) VALUES (6, 'Africa');
INSERT INTO tbl_regions (id, name) VALUES (7, 'Oceanía');
INSERT INTO tbl_regions (id, name) VALUES (8, 'Antártida');

-- Crear la tabla de clientes
CREATE TABLE tbl_customers (
    id INT PRIMARY KEY AUTO_INCREMENT,
    number_id VARCHAR(20) NOT NULL,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    photo_url VARCHAR(255),
    region_id INT,
    state VARCHAR(50) NOT NULL,
    FOREIGN KEY (region_id) REFERENCES tbl_regions(id)
);

-- Insertar datos en la tabla de clientes
INSERT INTO tbl_customers (number_id, first_name, last_name, email, photo_url, region_id, state)
VALUES ('1104048713', 'Jaime', 'Guzmán', 'profesor@tec.com', '', 1, 'CR');
