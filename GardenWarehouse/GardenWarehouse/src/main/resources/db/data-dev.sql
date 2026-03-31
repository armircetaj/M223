DELETE FROM items;

INSERT INTO items (id, code, type, name, price, itemCount)
VALUES
    (NEXT VALUE FOR warehouse_seq, '**c-*2', 'Seed', 'Tomato Seeds', 12.99, 8);
INSERT INTO items (id, code, type, name, price, itemCount)
VALUES
    (NEXT VALUE FOR warehouse_seq, '**a-*8', 'Pesticide', 'GMO Pesticide', 8.99, 12);
INSERT INTO items (id, code, type, name, price, itemCount)
VALUES
    (NEXT VALUE FOR warehouse_seq, '**x-*3', 'Fertilizer', 'Ground Fertilizer', 24.99, 7);