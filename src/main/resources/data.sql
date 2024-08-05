CREATE TABLE Desktop
(
    id           INT AUTO_INCREMENT PRIMARY KEY,
    serial_number VARCHAR(255) NOT NULL,
    manufacturer VARCHAR(255) NOT NULL,
    price DOUBLE NOT NULL,
    quantity     INT          NOT NULL,
    form_factor   VARCHAR(255) NOT NULL
);

CREATE TABLE Hard_drive
(
    id           INT AUTO_INCREMENT PRIMARY KEY,
    serial_number VARCHAR(255) NOT NULL,
    manufacturer VARCHAR(255) NOT NULL,
    price DOUBLE NOT NULL,
    quantity     INT          NOT NULL,
    capacity     INT          NOT NULL
);

CREATE TABLE Laptop
(
    id           INT AUTO_INCREMENT PRIMARY KEY,
    serial_number VARCHAR(255) NOT NULL,
    manufacturer VARCHAR(255) NOT NULL,
    price DOUBLE NOT NULL,
    quantity     INT          NOT NULL,
    size         INT          NOT NULL
);

CREATE TABLE Monitor
(
    id           INT AUTO_INCREMENT PRIMARY KEY,
    serial_number VARCHAR(255) NOT NULL,
    manufacturer VARCHAR(255) NOT NULL,
    price DOUBLE NOT NULL,
    quantity     INT          NOT NULL,
    diagonal DOUBLE NOT NULL
);

INSERT INTO Desktop (serial_number, manufacturer, price, quantity, form_factor)
VALUES
    ('SN123456', 'Dell', 800.00, 10, 'DESKTOP'),
    ('SN789012', 'HP', 600.00, 5, 'NETTOP'),
    ('SN345678', 'Apple', 1200.00, 3, 'MONOBLOCK');

INSERT INTO Hard_drive (serial_number, manufacturer, price, quantity, capacity)
VALUES
    ('HD123456', 'Seagate', 100.00, 20, 500),
    ('HD789012', 'Western Digital', 120.00, 15, 1000),
    ('HD345678', 'Samsung', 150.00, 10, 2000);

INSERT INTO Laptop (serial_number, manufacturer, price, quantity, size)
VALUES
    ('LP123456', 'Lenovo', 900.00, 7, 13),
    ('LP789012', 'Dell', 950.00, 5, 15),
    ('LP345678', 'HP', 850.00, 10, 17);

INSERT INTO Monitor (serial_number, manufacturer, price, quantity, diagonal)
VALUES
    ('MN123456', 'Samsung', 200.00, 8, 24.0),
    ('MN789012', 'LG', 180.00, 12, 27.0),
    ('MN345678', 'Asus', 220.00, 5, 32.0);
;

