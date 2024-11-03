CREATE DATABASE ATMSystem;
USE ATMSystem;

CREATE TABLE accounts (
    account_id INT PRIMARY KEY,
    balance DOUBLE
);

CREATE TABLE transactions (
    transaction_id INT AUTO_INCREMENT PRIMARY KEY,
    account_id INT,
    type VARCHAR(50),
    amount DOUBLE,
    date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (account_id) REFERENCES accounts(account_id)
);

INSERT INTO accounts (account_id, balance) VALUES (1, 1000.0);
