CREATE DATABASE ATMSystem;

USE ATMSystem;

CREATE TABLE accounts (
    account_id INT PRIMARY KEY AUTO_INCREMENT,
    balance DOUBLE NOT NULL
);

CREATE TABLE transactions (
    transaction_id INT PRIMARY KEY AUTO_INCREMENT,
    account_id INT,
    type VARCHAR(10),
    amount DOUBLE,
    date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (account_id) REFERENCES accounts(account_id)
);
