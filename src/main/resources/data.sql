-- CREATE TABLE Product
-- (
--     id           INT AUTO_INCREMENT PRIMARY KEY,
--     serialNumber VARCHAR(255) NOT NULL,
--     manufacturer VARCHAR(255) NOT NULL,
--     price DOUBLE NOT NULL,
--     quantity     INT          NOT NULL
-- );

CREATE TABLE Desktop
(
    id           INT AUTO_INCREMENT PRIMARY KEY,
    serial_number VARCHAR(255) NOT NULL,
    manufacturer VARCHAR(255) NOT NULL,
    price DOUBLE NOT NULL,
    quantity     INT          NOT NULL,
    form_factor   VARCHAR(255) NOT NULL
);

CREATE TABLE HardDrive
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


-- Вставка данных в таблицу Desktop
INSERT INTO Desktop (serial_number, manufacturer, price, quantity, form_factor)
VALUES ('SN654321', 'HP', 700.00, 5, 'DESKTOP');
INSERT INTO Desktop (serial_number, manufacturer, price, quantity, form_factor)
VALUES ('adfgadgd', 'MSI', 9760.00, 5, 'NETTOP');

-- Вставка данных в таблицу HardDrive
INSERT INTO HardDrive (serial_number, manufacturer, price, quantity, capacity)
VALUES ('SN789012', 'Seagate', 100.00, 20, 1024);

-- Вставка данных в таблицу Laptop
INSERT INTO Laptop (serial_number, manufacturer, price, quantity, size)
VALUES ('SN345678', 'Lenovo', 1200.00, 7, 15);
INSERT INTO Laptop (serial_number, manufacturer, price, quantity, size)
VALUES ('JOPA228', 'MSI', 1777.00, 2, 19);



-- Вставка данных в таблицу Monitor
INSERT INTO Monitor (serial_number, manufacturer, price, quantity, diagonal)
VALUES ('SN987654', 'Samsung', 300.00, 8, 24.0);

