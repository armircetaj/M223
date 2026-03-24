DELETE FROM customers;

INSERT INTO customers (id, name, surname, age, city, number, expiration, cvv)
VALUES
    (100, 'Mario', 'Rossi', 24, 'Milano', '1234567812345678', '12/26', '123'),
    (101, 'Guido', 'Bianchi', 34, 'Roma', '8765432187654321', '06/25', '456'),
    (102, 'Gino', 'Verdi', 57, 'Torino', '1111222233334444', '09/27', '789');