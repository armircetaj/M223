DELETE FROM customers;

INSERT INTO customers (id, name, surname, age, city, number, expiration, cvv)
VALUES
    (NEXT VALUE FOR customer_seq, 'Mario', 'Rossi', 24, 'Milano', '1234567812345678', '12/26', '123');
INSERT INTO customers (id, name, surname, age, city, number, expiration, cvv)
VALUES
    (NEXT VALUE FOR customer_seq, 'Gino', 'Verdi', 57, 'Torino', '1111222233334444', '09/27', '789');
INSERT INTO customers(id, name, surname, age, city, number, expiration, cvv)
VALUES
    (NEXT VALUE FOR customer_seq, 'Guido', 'Bianchi', 34, 'Roma', '8765432187654321', '06/25', '456');