import java.sql.*;
import java.util.ArrayList;

public class connect {
    public ArrayList<String> getClientsData() {
        String url = "jdbc:mysql://localhost:3306/SimpleCompany"; // Database URL
        String username = "root"; // MySQL Username
        String password = "root1234!"; // MySQL Password
        String query = "SELECT * FROM SimpleCompany.Clients"; // SQL Query
        ArrayList<String> clientsData = new ArrayList<>();

        // Using try-with-resources to manage the connection, statement, and result set
        try (Connection con = DriverManager.getConnection(url, username, password);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)) {

            System.out.println("Connection Established successfully");

            while (rs.next()) {
                // Add data to the list
                String clientInfo = "Client ID: " + rs.getInt("ClientID") + ", Name: " + rs.getString("ClientName");
                clientsData.add(clientInfo);
            }
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
        }
        return clientsData;
    }
}
