import java.sql.*;

public class BankAccount {
    private int accountId;
    private Connection conn;

    public BankAccount(int accountId) throws SQLException {
        this.accountId = accountId;
        this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ATMSystem", "username", "password");
    }

    public double getBalance() throws SQLException {
        String query = "SELECT balance FROM accounts WHERE account_id = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(1, accountId);
        ResultSet rs = stmt.executeQuery();
        rs.next();
        return rs.getDouble("balance");
    }

    public void deposit(double amount) throws SQLException {
        updateBalance(amount);
        recordTransaction("Deposit", amount);
    }

    public boolean withdraw(double amount) throws SQLException {
        if (amount <= getBalance()) {
            updateBalance(-amount);
            recordTransaction("Withdraw", amount);
            return true;
        } else {
            return false;
        }
    }

    private void updateBalance(double amount) throws SQLException {
        String update = "UPDATE accounts SET balance = balance + ? WHERE account_id = ?";
        PreparedStatement stmt = conn.prepareStatement(update);
        stmt.setDouble(1, amount);
        stmt.setInt(2, accountId);
        stmt.executeUpdate();
    }

    private void recordTransaction(String type, double amount) throws SQLException {
        String insert = "INSERT INTO transactions (account_id, type, amount) VALUES (?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(insert);
        stmt.setInt(1, accountId);
        stmt.setString(2, type);
        stmt.setDouble(3, amount);
        stmt.executeUpdate();
    }
}
