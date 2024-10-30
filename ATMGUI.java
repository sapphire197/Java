import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

class BankAccount {
    private int accountID;
    private double balance;

    public BankAccount(int accountID) {
        this.accountID = accountID;
        this.balance = fetchBalanceFromDB();
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        updateBalanceInDB();
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            updateBalanceInDB();
            return true;
        } else {
            return false;
        }
    }

    private double fetchBalanceFromDB() {
        double balance = 0.0;
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/atmDB", "root", "password")) {
            PreparedStatement ps = connection.prepareStatement("SELECT balance FROM BankAccount WHERE accountID = ?");
            ps.setInt(1, accountID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                balance = rs.getDouble("balance");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return balance;
    }

    private void updateBalanceInDB() {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/atmDB", "root", "password")) {
            PreparedStatement ps = connection.prepareStatement("UPDATE BankAccount SET balance = ? WHERE accountID = ?");
            ps.setDouble(1, balance);
            ps.setInt(2, accountID);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

public class ATMGUI extends JFrame implements ActionListener {
    private BankAccount account;
    private JLabel balanceLabel;
    private JTextField amountField;
    private JButton checkBalanceBtn, depositBtn, withdrawBtn, exitBtn;

    public ATMGUI(BankAccount account) {
        this.account = account;
        setTitle("ATM Machine");
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        balanceLabel = new JLabel("Balance: $0.0");
        add(balanceLabel);

        amountField = new JTextField(10);
        add(amountField);

        checkBalanceBtn = new JButton("Check Balance");
        checkBalanceBtn.addActionListener(this);
        add(checkBalanceBtn);

        depositBtn = new JButton("Deposit");
        depositBtn.addActionListener(this);
        add(depositBtn);

        withdrawBtn = new JButton("Withdraw");
        withdrawBtn.addActionListener(this);
        add(withdrawBtn);

        exitBtn = new JButton("Exit");
        exitBtn.addActionListener(this);
        add(exitBtn);

        refreshBalance();
        setVisible(true);
    }

    public void refreshBalance() {
        balanceLabel.setText("Balance: $" + account.getBalance());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == checkBalanceBtn) {
            refreshBalance();
        } else if (e.getSource() == depositBtn) {
            double amount = Double.parseDouble(amountField.getText());
            account.deposit(amount);
            JOptionPane.showMessageDialog(this, "Deposit successful!");
            refreshBalance();
        } else if (e.getSource() == withdrawBtn) {
            double amount = Double.parseDouble(amountField.getText());
            boolean success = account.withdraw(amount);
            if (success) {
                JOptionPane.showMessageDialog(this, "Withdrawal successful!");
            } else {
                JOptionPane.showMessageDialog(this, "Insufficient balance!");
            }
            refreshBalance();
        } else if (e.getSource() == exitBtn) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BankAccount userAccount = new BankAccount(1); // Example account ID
            new ATMGUI(userAccount);
        });
    }
}
