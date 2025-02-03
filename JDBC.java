import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/SimpleCompany"; // database name
        String username = "root"; // MySQL username
        String password = "root1234!"; // MySQL password
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            // Connection established successfully
            System.out.println("Connection successful!");
        } catch (SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }
}
