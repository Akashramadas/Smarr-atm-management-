package ui;

import javax.swing.*;
import java.awt.*;
import dao.AccountDAO;

public class DashboardFrame extends JFrame {

    public DashboardFrame() {
        setTitle("ATM System");
        setSize(400, 300);
        setLayout(new GridLayout(5, 1));

        JButton createBtn = new JButton("Create Account");
        JButton balanceBtn = new JButton("Check Balance");
        JButton exitBtn = new JButton("Exit");

        add(createBtn);
        add(balanceBtn);
        add(exitBtn);

        createBtn.addActionListener(e -> new CreateAccountFrame());
        balanceBtn.addActionListener(e -> checkBalance());
        exitBtn.addActionListener(e -> System.exit(0));

        setVisible(true);
    }

    private void checkBalance() {
        try {
            int acc = Integer.parseInt(JOptionPane.showInputDialog("Enter Account No"));
            int pin = Integer.parseInt(JOptionPane.showInputDialog("Enter PIN"));

            AccountDAO dao = new AccountDAO();
            double bal = dao.getBalance(acc, pin);

            if (bal >= 0)
                JOptionPane.showMessageDialog(this, "Balance: ₹" + bal);
            else
                JOptionPane.showMessageDialog(this, "Invalid Details");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
