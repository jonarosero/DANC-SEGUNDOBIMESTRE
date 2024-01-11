-- Crear la tabla tlb_invoices
CREATE TABLE tlb_invoices (
    id INT PRIMARY KEY,
    number_invoice VARCHAR(255),
    description VARCHAR(255),
    customer_id INT,
    create_at TIMESTAMP,
    state VARCHAR(50)
);

-- Crear la tabla tbl_invoce_items
CREATE TABLE tbl_invoce_items (
    id INT PRIMARY KEY AUTO_INCREMENT,
    invoice_id INT,
    product_id INT,
    quantity INT,
    price DECIMAL(10, 2),
    FOREIGN KEY (invoice_id) REFERENCES tlb_invoices(id)
);

INSERT INTO tlb_invoices (id, number_invoice, description, customer_id, create_at, state) VALUES(1, '0001', 'invoice office items', 1, NOW(),'CREATED');

INSERT INTO tbl_invoce_items ( invoice_id, product_id, quantity, price ) VALUES(1, 1 , 1, 178.89);
INSERT INTO tbl_invoce_items ( invoice_id, product_id, quantity, price)  VALUES(1, 2 , 2, 12.5);
INSERT INTO tbl_invoce_items ( invoice_id, product_id, quantity, price)  VALUES(1, 3 , 1, 40.06);