import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class form1 extends JFrame {
    private JTextArea textArea1;
    private JPanel panel1;
    private JButton button1;

    public form1() {

        setSize(700,400);
        setContentPane(panel1);
        setVisible(true);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                connect myObj = new connect();
                for(String item : myObj.getClientsData()){
                    textArea1.append(item+ "\n");

                }
            }
        });
    }
}
