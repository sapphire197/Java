// Client Code

import java.io.*;
import java.net.*;
import javax.swing.*;

public class Client {
    private static Socket socket;
    private static PrintWriter writer;

    public static void main(String[] args) {
        try {
            socket = new Socket("localhost", 8080);
            writer = new PrintWriter(socket.getOutputStream(), true);
            
            JFrame frame = new JFrame("Chat");
            JTextField input = new JTextField();
            JTextArea messages = new JTextArea();
            messages.setEditable(false);

            input.addActionListener(e -> {
                String message = input.getText();
                writer.println(message);
                input.setText("");
            });

            frame.add(new JScrollPane(messages), "Center");
            frame.add(input, "South");
            frame.setSize(400, 300);
            frame.setVisible(true);

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String msg;
            while ((msg = reader.readLine()) != null) {
                messages.append(msg + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
