DELETE FROM instrument;

INSERT INTO instrument (id, type, brand, model, price, stock)
VALUES
    (NEXT VALUE FOR store_seq, 'Guitar', 'Fender', 'Les Paul', 289.99, 2),
    (NEXT VALUE FOR store_seq, 'Piano', 'Gibson', 'CFX', 1599.99, 4),
    (NEXT VALUE FOR store_seq, 'Guitar', 'Gibson', 'Stratocaster', 399.99, 6),
    (NEXT VALUE FOR store_seq, 'Drums', 'Yamaha', 'P71L', 549.99, 3);


