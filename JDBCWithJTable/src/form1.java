import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

// Class definition for the GUI form
public class form1 extends JFrame {
    // GUI components
    private JPanel panel1;
    private JTable table1;
    private JComboBox<String> comboBox1;

    private DefaultTableModel model; // Table model to manage data dynamically
    private ArrayList<String[]> clients; // List to store client data retrieved from the database

    // Constructor to initialize the GUI
    public form1() {
        // Set window size
        setSize(700, 400);

        // Attach the main panel to the JFrame
        setContentPane(panel1);

        // Make the form visible
        setVisible(true);

        // Initialize the table model with column names
        model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"Client Name", "Contact Email"});
        table1.setModel(model); // Attach model to table

        // Execute initial database query to fetch client data
        clients = connect.executeQuery("SELECT ClientName, ContactEmail FROM SimpleCompany.clients", "ClientName", "ContactEmail");

        // Populate the table with the retrieved data
        updateTable();

        // ActionListener for the ComboBox (sorting options)
        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Check which sorting option is selected
                if (comboBox1.getSelectedIndex() == 0) {
                    // Sort clients by Contact Email in ascending order
                    clients = connect.executeQuery("SELECT ClientName, ContactEmail FROM SimpleCompany.clients ORDER BY ContactEmail ASC", "ClientName", "ContactEmail");
                } else if (comboBox1.getSelectedIndex() == 1) {
                    // Sort clients by Contact Email in descending order
                    clients = connect.executeQuery("SELECT ClientName, ContactEmail FROM SimpleCompany.clients ORDER BY ContactEmail DESC", "ClientName", "ContactEmail");
                }
                updateTable(); // Refresh the table to display sorted data
            }
        });
    }

    // Method to update the table with the latest client data
    private void updateTable() {
        model.setRowCount(0); // Clear all existing rows in the table
        for (String[] client : clients) {
            model.addRow(client); // Add each client's data as a new row
        }
    }
}
