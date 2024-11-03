import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ATMGUI extends JFrame {
    private BankAccount account;
    private JLabel balanceLabel;
    private JTextField amountField;
    private JTextArea transactionArea;

    public ATMGUI(BankAccount account) {
        this.account = account;
        setTitle("ATM System");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initComponents();
    }

    private void initComponents() {
        balanceLabel = new JLabel("Balance: $" + fetchBalance());
        amountField = new JTextField(10);
        transactionArea = new JTextArea(10, 30);
        transactionArea.setEditable(false);

        JButton depositButton = new JButton("Deposit");
        JButton withdrawButton = new JButton("Withdraw");
        JButton historyButton = new JButton("Transaction History");

        depositButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double amount = Double.parseDouble(amountField.getText());
                try {
                    account.deposit(amount);
                    updateBalance();
                    transactionArea.append("Deposited: $" + amount + "\n");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        withdrawButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double amount = Double.parseDouble(amountField.getText());
                try {
                    if (account.withdraw(amount)) {
                        updateBalance();
                        transactionArea.append("Withdrew: $" + amount + "\n");
                    } else {
                        JOptionPane.showMessageDialog(null, "Insufficient balance!");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        historyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    displayTransactionHistory();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        JPanel panel = new JPanel();
        panel.add(balanceLabel);
        panel.add(new JLabel("Amount:"));
        panel.add(amountField);
        panel.add(depositButton);
        panel.add(withdrawButton);
        panel.add(historyButton);
        panel.add(new JScrollPane(transactionArea));

        add(panel);
    }

    private double fetchBalance() {
        try {
            return account.getBalance();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    private void updateBalance() {
        balanceLabel.setText("Balance: $" + fetchBalance());
    }

    private void displayTransactionHistory() throws SQLException {
        transactionArea.setText("");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ATMSystem", "username", "password");
        String query = "SELECT * FROM transactions WHERE account_id = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(1, account.getAccountId());
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            transactionArea.append(
                    rs.getString("type") + ": $" + rs.getDouble("amount") + " on " + rs.getTimestamp("date") + "\n");
        }
    }

    public static void main(String[] args) {
        try {
            BankAccount userAccount = new BankAccount(1); // Account with ID 1
            ATMGUI atmGui = new ATMGUI(userAccount);
            atmGui.setVisible(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
