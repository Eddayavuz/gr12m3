import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class form1 extends JFrame {
    private JTextArea textArea1;
    private JPanel panel1;
    private JButton button1;
    private JButton listDepartmentsButton;
    private JTextArea textArea2;

    public form1() {
        setSize(700, 400);
        setContentPane(panel1);
        setVisible(true);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1.setText(""); // Clear previous results
                ArrayList<String> clients = connect.executeQuery("SELECT * FROM SimpleCompany.Clients", "ClientID", "ClientName");
                for (String client : clients) {
                    textArea1.append(client + "\n");
                }
            }
        });

        listDepartmentsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea2.setText(""); // Clear previous results
                ArrayList<String> departments = connect.executeQuery("SELECT * FROM SimpleCompany.Departments", "DepartmentID", "DepartmentName");
                for (String department : departments) {
                    textArea2.append(department + "\n");
                }
            }
        });
    }
}
