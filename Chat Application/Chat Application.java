import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleChatApp extends JFrame implements ActionListener {
    private JTextArea chatArea;
    private JTextField user1Input, user2Input;
    private JButton sendUser1Button, sendUser2Button;

    public SimpleChatApp() {
        chatArea = new JTextArea();
        chatArea.setEditable(false);
        user1Input = new JTextField(20);
        user2Input = new JTextField(20);
        sendUser1Button = new JButton("Send (User 1)");
        sendUser2Button = new JButton("Send (User 2)");

        sendUser1Button.addActionListener(this);
        sendUser2Button.addActionListener(this);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(2, 2));
        inputPanel.add(user1Input);
        inputPanel.add(sendUser1Button);
        inputPanel.add(user2Input);
        inputPanel.add(sendUser2Button);

        setLayout(new BorderLayout());
        add(new JScrollPane(chatArea), BorderLayout.CENTER);
        add(inputPanel, BorderLayout.SOUTH);

        setTitle("Simple Chat Application");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == sendUser1Button) {
            String message = "User 1: " + user1Input.getText();
            chatArea.append(message + "\n");
            user1Input.setText("");
        } else if (e.getSource() == sendUser2Button) {
            String message = "User 2: " + user2Input.getText();
            chatArea.append(message + "\n");
            user2Input.setText("");
        }
    }

    public static void main(String[] args) {
        new SimpleChatApp();
    }
}
