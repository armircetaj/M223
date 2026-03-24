CREATE TABLE IF NOT EXISTS customers (
    id IDENTITY,
    name VARCHAR(50) NOT NULL,
    surname VARCHAR(50) NOT NULL,
    age INT NOT NULL,
    city VARCHAR(100),
    number VARCHAR(50),
    expiration VARCHAR(10),
    cvv VARCHAR(10)
    );