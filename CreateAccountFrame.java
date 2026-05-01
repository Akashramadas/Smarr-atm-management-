package ui;

import javax.swing.*;
import java.awt.*;
import dao.AccountDAO;

public class CreateAccountFrame extends JFrame {

    public CreateAccountFrame() {
        setTitle("Create Account");
        setSize(300, 250);
        setLayout(new GridLayout(4, 2));

        JTextField nameField = new JTextField();
        JTextField pinField = new JTextField();
        JTextField balField = new JTextField();

        JButton createBtn = new JButton("Create");

        add(new JLabel("Name"));
        add(nameField);
        add(new JLabel("PIN"));
        add(pinField);
        add(new JLabel("Initial Balance"));
        add(balField);
        add(createBtn);

        createBtn.addActionListener(e -> {
            try {
                AccountDAO dao = new AccountDAO();
                dao.createAccount(
                    nameField.getText(),
                    Integer.parseInt(pinField.getText()),
                    Double.parseDouble(balField.getText())
                );
                JOptionPane.showMessageDialog(this, "Account Created!");
                dispose();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        setVisible(true);
    }
}
