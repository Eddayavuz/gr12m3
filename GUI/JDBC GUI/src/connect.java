import java.sql.*;
import java.util.ArrayList;

public class connect {
    private static final String URL = "jdbc:mysql://localhost:3306/SimpleCompany"; // path of DB
    private static final String USER = "root"; // username
    private static final String PASSWORD = "root1234!"; // password

    // method for executing ANY QUERY. (see the parameters list)
    public static ArrayList<String> executeQuery(String query, String column1, String column2) {
        ArrayList<String> results = new ArrayList<>(); // arraylist to hold the results of query.

        // try and catch wrapped connection. WHY try and catch?
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD); // step 1: establish connection
             Statement statement = connection.createStatement(); // step 2: create statement
             ResultSet rs = statement.executeQuery(query)) { // step 3: execute the query

            // as long as there's data in the row, it will return true.
            while (rs.next()) {
                String row = column1 + ": " + rs.getString(column1) + " | " + column2 + ": " + rs.getString(column2); // store that row in a variable.
                results.add(row); // store row variable in the arraylist
                }
        } catch (SQLException e) {
            results.add("SQL Error: " + e.getMessage());
        }
        return results; // at the end of the method, return the result arraylist.
    }
}
