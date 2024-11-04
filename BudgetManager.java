import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BudgetManager {
    public boolean setBudget(int userId, String category, double limitAmount, String startDate, String endDate) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO budgets (user_id, category, limit_amount, start_date, end_date) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, userId);
            stmt.setString(2, category);
            stmt.setDouble(3, limitAmount);
            stmt.setString(4, startDate);
            stmt.setString(5, endDate);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ResultSet getBudgets(int userId) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM budgets WHERE user_id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, userId);
            return stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}

