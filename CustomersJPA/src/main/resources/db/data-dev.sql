DELETE FROM customers;

INSERT INTO customers (id, name, surname, age, city, number, expiration, cvv)
VALUES
    (NEXT VALUE FOR customer_seq, '****', '****', 24, 'Milano', '1****5**812**5**8', '1*/2*', '***');
INSERT INTO customers (id, name, surname, age, city, number, expiration, cvv)
VALUES
    (NEXT VALUE FOR customer_seq, '****', '****', 57, 'Torino', '1**12**2****4**4', '0*/2*', '***');
INSERT INTO customers(id, name, surname, age, city, number, expiration, cvv)
VALUES
    (NEXT VALUE FOR customer_seq, '*****', '*******', 34, 'Roma', '8****321***5*3*1', '0*/2*', '***');