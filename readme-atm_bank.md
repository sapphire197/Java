# ATM System with GUI and Database Integration

This project is a simulation of an ATM (Automated Teller Machine) system with an interactive GUI built in Java Swing. It uses MySQL for database management, providing functionality for checking balance, depositing, withdrawing, and viewing transaction history.

---

## Project Structure

### Files

1. **`BankAccount.java`** - Handles bank account operations, including balance retrieval, deposits, withdrawals, and transaction records, by interacting with the database.
2. **`ATMGUI.java`** - The main GUI file. It provides an interactive interface for ATM operations using Java Swing components.
3. **`ATMSystem.sql`** - SQL script to set up the MySQL database with necessary tables (`accounts` and `transactions`).
4. **`README.md`** - Documentation file for project setup, concepts, and theories.

---

## Requirements

- **Java Development Kit (JDK) 8 or higher**
- **MySQL Database Server**
- **MySQL JDBC Driver** (Connector/J)
- **Java Swing Library** (included in JDK)

---

## Database Setup

1. Open your MySQL client (like MySQL Workbench) and execute the `ATMSystem.sql` file to set up the database and tables.
2. Ensure you have a database named `ATMSystem` with two tables:
   - **`accounts`**: Stores `account_id` and `balance` for each user.
   - **`transactions`**: Logs transactions (type, amount, date) for each account.
3. Example SQL code to create the tables is included in `ATMSystem.sql`.

---

## How to Run the Project

1. **Clone or download** this repository.
2. **Compile** both Java files:
   ```bash
   javac BankAccount.java ATMGUI.java
   ```
3. **Run** the main class `ATMGUI`:
   ```bash
   java ATMGUI
   ```
4. **Database Connection**: Update the database connection details in `BankAccount.java`:
   ```java
   this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ATMSystem", "username", "password");
   ```
   Replace `"username"` and `"password"` with your MySQL credentials.

---

## Application Overview

The project involves two main components:

1. **Bank Account Management**
   - Methods in `BankAccount.java` allow deposits, withdrawals, and balance checking by interacting with the MySQL database.
   - Each transaction is recorded in the `transactions` table for future reference.

2. **ATM GUI**
   - `ATMGUI.java` creates a Swing-based interface for user interactions.
   - Users can perform basic ATM operations like depositing, withdrawing, and viewing transaction history.

### Database Schema

#### `accounts` Table
- **`account_id`** (INT, Primary Key): Unique identifier for each account.
- **`balance`** (DOUBLE): Stores the current balance of the account.

#### `transactions` Table
- **`transaction_id`** (INT, AUTO_INCREMENT, Primary Key): Unique ID for each transaction.
- **`account_id`** (INT, Foreign Key): The account linked to the transaction.
- **`type`** (VARCHAR): Type of transaction (e.g., "Deposit", "Withdraw").
- **`amount`** (DOUBLE): Amount involved in the transaction.
- **`date`** (TIMESTAMP): Timestamp of when the transaction occurred.

---

## Key Concepts and Theories

### 1. **Java Swing**
   - **Swing** is a part of Java Foundation Classes (JFC) for building graphical user interfaces (GUIs).
   - Swing provides a more flexible and sophisticated GUI compared to the Abstract Window Toolkit (AWT).
   - In this project:
     - `JFrame` creates the main window.
     - `JLabel`, `JTextField`, `JButton`, and `JTextArea` are used for ATM functions like displaying balance, accepting deposit/withdrawal amounts, and showing transaction history.
   - **Event Handling**: Each button has an `ActionListener` to handle clicks, which triggers respective methods.

### 2. **JDBC (Java Database Connectivity)**
   - JDBC is an API that enables Java applications to interact with databases.
   - The project uses JDBC to connect to MySQL, retrieve balances, and record transactions.
   - **PreparedStatement** is used for SQL queries, which enhances security by preventing SQL injection.
   - Connection management ensures efficient database usage and transaction logging.

### 3. **Relational Database Theory**
   - A relational database organizes data into tables (relations) with rows and columns.
   - This project uses a **normalized schema**:
     - Separate tables for `accounts` and `transactions` to ensure data consistency and prevent redundancy.
     - **Foreign Key Constraint**: Ensures referential integrity by linking transactions to specific accounts.

### 4. **Transaction Logging**
   - Each operation (deposit/withdraw) is logged as a transaction for accountability and historical record-keeping.
   - This reflects **ACID properties** (Atomicity, Consistency, Isolation, Durability), ensuring that operations on the account are consistent and reliable.
   - Using **transactions** in financial applications helps in tracking history and troubleshooting any discrepancies.

### 5. **Design Patterns: MVC (Model-View-Controller)**
   - This project implicitly follows the MVC pattern:
     - **Model**: `BankAccount.java` - Contains the business logic and interacts with the database.
     - **View**: Swing components in `ATMGUI.java` - Manages the display and user interaction.
     - **Controller**: Event handlers in `ATMGUI.java` act as the bridge, calling model methods based on user inputs.

---

## Sample Code Snippets

### Fetching Balance from Database
```java
public double getBalance() throws SQLException {
    String query = "SELECT balance FROM accounts WHERE account_id = ?";
    PreparedStatement stmt = conn.prepareStatement(query);
    stmt.setInt(1, accountId);
    ResultSet rs = stmt.executeQuery();
    rs.next();
    return rs.getDouble("balance");
}
```

### Recording Transactions
```java
private void recordTransaction(String type, double amount) throws SQLException {
    String insert = "INSERT INTO transactions (account_id, type, amount) VALUES (?, ?, ?)";
    PreparedStatement stmt = conn.prepareStatement(insert);
    stmt.setInt(1, accountId);
    stmt.setString(2, type);
    stmt.setDouble(3, amount);
    stmt.executeUpdate();
}
```

### Swing Button Example
```java
JButton depositButton = new JButton("Deposit");
depositButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        double amount = Double.parseDouble(amountField.getText());
        try {
            account.deposit(amount);
            updateBalance();
            transactionArea.append("Deposited: $" + amount + "\n");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
});
```

---

## Future Enhancements

- **User Authentication**: Implement login and password security for each account.
- **Error Handling**: Improve exception handling for robustness.
- **UI Enhancements**: Use more advanced Swing components or migrate to JavaFX for a modern interface.
- **Multi-Account Management**: Add the ability to switch between multiple accounts.

---

## Troubleshooting

- **Database Connection Issues**: Ensure MySQL server is running and check the JDBC URL, username, and password.
- **SQL Exceptions**: Review SQL syntax and ensure tables are set up according to the `ATMSystem.sql` schema.
- **UI Freezing**: Heavy database operations in the GUI can cause lag; consider using separate threads for background tasks.

---

## License

This project is licensed under the MIT License.
