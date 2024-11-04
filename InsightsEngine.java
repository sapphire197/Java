import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InsightsEngine {
    public double calculateMonthlyExpense(int userId, String month) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "SELECT SUM(amount) as total FROM expenses WHERE user_id = ? AND DATE_FORMAT(date, '%Y-%m') = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, userId);
            stmt.setString(2, month);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getDouble("total");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public String recommendSaving(int userId) {
        // Placeholder for more complex insights based on user spending habits
        return "Consider setting aside a portion of your entertainment budget for savings.";
    }
}
