import java.sql.*;
import java.util.ArrayList;

public class connect {
    private static final String URL = "jdbc:mysql://localhost:3306/SimpleCompany"; // path of DB
    private static final String USER = "root"; // username
    private static final String PASSWORD = "root1234!"; // password

    // method for executing ANY QUERY. (see the parameters list)
    public static ArrayList<String[]> executeQuery(String query, String column1, String column2) {
        ArrayList<String[]> results = new ArrayList<>(); // arraylist to hold the results of query.

        // try and catch wrapped connection. WHY try and catch?
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD); // step 1: establish connection
             Statement statement = connection.createStatement(); // step 2: create statement
             ResultSet rs = statement.executeQuery(query)) { // step 3: execute the query

            while (rs.next()) {
                // Create a new row to store data for this record
                String[] row = new String[2]; // Assumes that each row has two columns to store.

                // Get the data for the first column (column1) and store it in the row
                row[0] = rs.getString(column1);

                // Get the data for the second column (column2) and store it in the row
                row[1] = rs.getString(column2);

                // Add this row to the results list
                results.add(row);
            }
        } catch (SQLException e) {
            // If there's an exception (e.g., a connection issue or query issue), print the error message.
            System.out.println("SQL Error: " + e.getMessage());
        }
        // Return the results ArrayList containing all rows from the result set
        return results;
    }
}
