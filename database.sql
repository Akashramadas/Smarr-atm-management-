CREATE DATABASE atmdb;
USE atmdb;

CREATE TABLE accounts (
    acc_no INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    pin INT,
    balance DOUBLE
);
