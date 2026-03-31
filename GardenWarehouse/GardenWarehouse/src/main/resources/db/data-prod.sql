DELETE FROM items;

INSERT INTO items (id, code, type, name, price, itemCount)
VALUES
    (NEXT VALUE FOR warehouse_seq, 'zkc-12', 'Seed', 'Tomato Seeds', 12.99, 8),
    (NEXT VALUE FOR warehouse_seq, 'pla-78', 'Pesticide', 'GMO Pesticide', 8.99, 12),
    (NEXT VALUE FOR warehouse_seq, 'xex-33', 'Fertilizer', 'Ground Fertilizer', 24.99, 7);