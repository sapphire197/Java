# Book Inventory System

## Overview

The Book Inventory System is a Java-based application designed to help manage a library's book collection, tracking details such as title, author, genre, publication year, and availability status. It includes a database connection for persistent storage, allowing users to add, update, delete, and search for books. This application can be useful for small libraries, bookstores, or personal collections, offering a straightforward interface for book management.

## Features

- **Add Books**: Add new books with details like title, author, genre, publication year, and availability status.
- **Update Book Details**: Modify existing book information.
- **Delete Books**: Remove books from the inventory.
- **Search and Filter**: Search for books by title, author, genre, or availability.
- **Database Integration**: Uses an SQLite database to store and retrieve book details.
  
## Project Structure

### Files

1. **Book.java**: Contains the `Book` class that defines book properties.
2. **BookDAO.java**: Data Access Object (DAO) that handles database interactions.
3. **BookInventoryApp.java**: Main application class for user interactions.
4. **DatabaseManager.java**: Sets up the database connection and ensures the table is created if it doesn’t already exist.

### Classes

- **Book**: Represents a book with attributes like title, author, genre, publication year, and availability status.
- **BookDAO**: Handles CRUD (Create, Read, Update, Delete) operations on the database.
- **BookInventoryApp**: Main application class that runs the command-line interface and manages user inputs.
- **DatabaseManager**: Manages the connection to the SQLite database.

## Installation and Setup

### Prerequisites

- **Java Development Kit (JDK)**: Version 8 or higher.
- **SQLite**: An SQLite JDBC driver is needed to run this project.

### Setup

1. **Clone the Repository**
   ```bash
   git clone https://github.com/yourusername/BookInventorySystem.git
   cd BookInventorySystem
   ```

2. **Database Setup**
   - Ensure `sqlite-jdbc.jar` is included in your project’s classpath.

3. **Compile the Code**
   ```bash
   javac Book.java BookDAO.java BookInventoryApp.java DatabaseManager.java
   ```

4. **Run the Application**
   ```bash
   java BookInventoryApp
   ```

## Code Structure and Explanation

### 1. Book.java

```java
public class Book {
    private int id;
    private String title;
    private String author;
    private String genre;
    private int publicationYear;
    private boolean isBorrowed;

    // Constructors, getters, and setters...
}
```

The `Book` class defines:
- **id**: Unique identifier for each book.
- **title, author, genre, publicationYear**: Descriptive attributes.
- **isBorrowed**: Boolean indicating availability.

### 2. BookDAO.java

```java
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    private Connection connection;

    public BookDAO(Connection connection) {
        this.connection = connection;
    }

    public void addBook(Book book) {
        // Implementation for adding a book to the database
    }

    public List<Book> getAllBooks() {
        // Implementation for fetching all books
    }

    // Other CRUD methods for update, delete, search...
}
```

The `BookDAO` class interacts with the database and provides methods to:
- Add a new book.
- Retrieve all books.
- Update and delete books.
- Search for specific books by title or author.

### 3. DatabaseManager.java

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
    public static Connection getConnection() {
        // Method to establish a connection to the SQLite database
    }
}
```

This class sets up the SQLite database connection, allowing the application to persist data.

### 4. BookInventoryApp.java

```java
import java.util.Scanner;

public class BookInventoryApp {
    public static void main(String[] args) {
        // Main method to run the application
        // Provides a command-line interface for interacting with the system
    }
}
```

This main class provides the command-line interface, prompting the user to choose actions such as adding, updating, deleting, or viewing books.

## How to Use the Application

1. Run the application with `java BookInventoryApp`.
2. Choose an action from the menu, such as:
   - Adding a book.
   - Viewing all books.
   - Searching for a book by title or author.
   - Updating or deleting a book.
3. Follow the prompts for each action.

### Sample Console Interaction

```plaintext
Welcome to the Book Inventory System
1. Add Book
2. View All Books
3. Search Book
4. Update Book
5. Delete Book
6. Exit
Choose an option: 1
Enter title: "To Kill a Mockingbird"
Enter author: "Harper Lee"
Enter genre: "Fiction"
Enter publication year: 1960
Is the book borrowed? (yes/no): no
Book added successfully!
```

## Future Improvements

- **GUI Implementation**: Use Java Swing to build a graphical interface.
- **Enhanced Search**: Add search filters by genre, publication year, or availability.
- **User Authentication**: Restrict access with login credentials.
- **Export Data**: Allow data export to CSV or Excel for easy backup.
