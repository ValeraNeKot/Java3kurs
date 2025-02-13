package val.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseHandler {
	private static final String URL = "jdbc:mysql://localhost:3306/matrix_app?useSSL=false&allowPublicKeyRetrieval=true";
    private static final String USER = "root"; 
    private static final String PASSWORD = "bb8c3po@kukulera"; 

    public DatabaseHandler() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println("Соединение с базой данных установлено.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveCalculation(int size, String matrix, double mainAvg, double secondaryAvg, double result) {
        String query = "INSERT INTO calculations (matrix_size, matrix, main_diagonal_avg, secondary_diagonal_avg, result, timestamp) "
                + "VALUES (?, ?, ?, ?, ?, NOW())";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setInt(1, size);
            stmt.setString(2, matrix);
            stmt.setDouble(3, mainAvg);
            stmt.setDouble(4, secondaryAvg);
            stmt.setDouble(5, result);

            stmt.executeUpdate();
            System.out.println("Результат вычислений успешно сохранён в БД.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void printHistory() {
        String sql = "SELECT id, timestamp, matrix_size, result FROM calculations ORDER BY timestamp DESC";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("История вычислений:");
            while (rs.next()) {
                System.out.printf(
                    "ID: %d | Время: %s | Размер: %d | Результат: %.2f%n",
                    rs.getInt("id"),
                    rs.getTimestamp("timestamp"),
                    rs.getInt("matrix_size"),
                    rs.getDouble("result")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
