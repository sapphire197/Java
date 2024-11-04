import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExpenseManager {
    public boolean addExpense(int userId, String category, double amount, String date, String description) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO expenses (user_id, category, amount, date, description) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, userId);
            stmt.setString(2, category);
            stmt.setDouble(3, amount);
            stmt.setString(4, date);
            stmt.setString(5, description);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ResultSet getExpenses(int userId) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM expenses WHERE user_id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, userId);
            return stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}

