CREATE DATABASE book_inventory;

USE book_inventory;

CREATE TABLE books (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    genre VARCHAR(100),
    publication_year INT,
    is_borrowed BOOLEAN DEFAULT FALSE
);
