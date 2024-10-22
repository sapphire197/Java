import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class Contact {
    private String name;
    private String phone;
    private String email;

    public Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public String toString() {
        return name + " - " + phone + " - " + email;
    }
}

public class ContactManager extends JFrame implements ActionListener {
    private JTextField nameField, phoneField, emailField;
    private JButton addButton, deleteButton;
    private DefaultListModel<Contact> contactListModel;
    private JList<Contact> contactList;

    public ContactManager() {
        // Create the text fields for input
        nameField = new JTextField(15);
        phoneField = new JTextField(15);
        emailField = new JTextField(15);

        // Create the buttons
        addButton = new JButton("Add Contact");
        deleteButton = new JButton("Delete Contact");

        // Create the contact list model and JList
        contactListModel = new DefaultListModel<>();
        contactList = new JList<>(contactListModel);
        contactList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Add action listeners to the buttons
        addButton.addActionListener(this);
        deleteButton.addActionListener(this);

        // Arrange components in the panel
        JPanel inputPanel = new JPanel(new GridLayout(4, 2));
        inputPanel.add(new JLabel("Name:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Phone:"));
        inputPanel.add(phoneField);
        inputPanel.add(new JLabel("Email:"));
        inputPanel.add(emailField);
        inputPanel.add(addButton);
        inputPanel.add(deleteButton);

        // Set up the frame layout
        setLayout(new BorderLayout());
        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(contactList), BorderLayout.CENTER);

        // Set the frame properties
        setTitle("Contact Management System");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            String name = nameField.getText();
            String phone = phoneField.getText();
            String email = emailField.getText();

            if (!name.isEmpty() && !phone.isEmpty() && !email.isEmpty()) {
                contactListModel.addElement(new Contact(name, phone, email));
                nameField.setText("");
                phoneField.setText("");
                emailField.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == deleteButton) {
            int selectedIndex = contactList.getSelectedIndex();
            if (selectedIndex != -1) {
                contactListModel.remove(selectedIndex);
            } else {
                JOptionPane.showMessageDialog(this, "Please select a contact to delete.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        new ContactManager();
    }
}
