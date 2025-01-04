import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class events extends JFrame{
    private JPanel panel;
    private JButton loginButton;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JLabel warning;
    private JLabel pic;
    private JCheckBox iAgreeToTermsCheckBox;


    public events() {

        // ESSENTIALS
        setSize(500,500);
        setContentPane(panel);
        setVisible(true);
        loginButton.setEnabled(false);

        textField1.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                if (textField1.getText().length() <= 5){
                    warning.setForeground(Color.RED);
                    warning.setText("username can't be smaller than 5 characters.");
                  textField1.requestFocus();
                }else{
                    warning.setText(" ");
                }
            }
        });
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (passwordField1.getText().equals("password")){
                    warning.setForeground(Color.GREEN);
                    warning.setText("bravo!");
                }else{
                    warning.setForeground(Color.RED);
                    warning.setText("wrong!");
                }
            }
        });
        iAgreeToTermsCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                loginButton.setEnabled(iAgreeToTermsCheckBox.isSelected());
            }
        });
    }

}

