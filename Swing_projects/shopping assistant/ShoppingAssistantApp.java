import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

public class ShoppingAssistantApp extends JFrame implements ActionListener {
    // UI Components
    private JComboBox<String> categoryComboBox;
    private JList<String> itemList;
    private DefaultListModel<String> itemListModel;
    private JTextArea shoppingListArea;
    private JTextArea recommendationArea;
    private JButton addItemButton;
    private JButton markAsBoughtButton;
    private JButton showRecommendationsButton;

    // Data Structures
    private HashMap<String, ArrayList<String>> shoppingList; // Organizes items by category
    private ArrayList<String> boughtItems; // Tracks bought items

    // Constructor
    public ShoppingAssistantApp() {
        // Initialize components
        String[] categories = { "Groceries", "Electronics", "Clothes" };
        categoryComboBox = new JComboBox<>(categories);
        itemListModel = new DefaultListModel<>();
        itemList = new JList<>(itemListModel);
        shoppingListArea = new JTextArea(10, 30);
        recommendationArea = new JTextArea(5, 30);
        addItemButton = new JButton("Add Item");
        markAsBoughtButton = new JButton("Mark as Bought");
        showRecommendationsButton = new JButton("Show Recommendations");

        // Set properties for JTextArea
        shoppingListArea.setEditable(false);
        recommendationArea.setEditable(false);

        // Set up the data structures
        shoppingList = new HashMap<>();
        boughtItems = new ArrayList<>();

        // Populate the item list based on categories
        populateItemList();

        // Set up UI
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Select Category:"));
        inputPanel.add(categoryComboBox);
        inputPanel.add(new JLabel("Items:"));
        inputPanel.add(new JScrollPane(itemList));
        inputPanel.add(addItemButton);
        inputPanel.add(markAsBoughtButton);
        inputPanel.add(showRecommendationsButton);

        JPanel displayPanel = new JPanel();
        displayPanel.setLayout(new BorderLayout());
        displayPanel.add(new JScrollPane(shoppingListArea), BorderLayout.CENTER);
        displayPanel.add(new JScrollPane(recommendationArea), BorderLayout.SOUTH);

        // Add components to the frame
        add(inputPanel, BorderLayout.NORTH);
        add(displayPanel, BorderLayout.CENTER);

        // Add action listeners
        addItemButton.addActionListener(this);
        markAsBoughtButton.addActionListener(this);
        showRecommendationsButton.addActionListener(this);

        // Window settings
        setTitle("Smart Shopping Assistant");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window
        setVisible(true);
    }

    // Method to populate item list based on category selection
    private void populateItemList() {
        String selectedCategory = (String) categoryComboBox.getSelectedItem();
        itemListModel.clear();

        switch (selectedCategory) {
            case "Groceries":
                itemListModel.addElement("Milk");
                itemListModel.addElement("Bread");
                itemListModel.addElement("Eggs");
                break;
            case "Electronics":
                itemListModel.addElement("Phone Charger");
                itemListModel.addElement("Headphones");
                itemListModel.addElement("Laptop");
                break;
            case "Clothes":
                itemListModel.addElement("T-shirt");
                itemListModel.addElement("Jeans");
                itemListModel.addElement("Sweater");
                break;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addItemButton) {
            String category = (String) categoryComboBox.getSelectedItem();
            String selectedItem = itemList.getSelectedValue();

            if (selectedItem != null) {
                shoppingList.computeIfAbsent(category, k -> new ArrayList<>()).add(selectedItem);
                shoppingListArea.append(category + ": " + selectedItem + " (Pending)\n");
            } else {
                JOptionPane.showMessageDialog(this, "Please select an item.");
            }
        } else if (e.getSource() == markAsBoughtButton) {
            String selectedText = shoppingListArea.getSelectedText();
            if (selectedText != null && !boughtItems.contains(selectedText)) {
                boughtItems.add(selectedText);
                shoppingListArea.append(selectedText.replace(" (Pending)", " (Bought)") + "\n");
            } else {
                JOptionPane.showMessageDialog(this, "Please select an item to mark as bought.");
            }
        } else if (e.getSource() == showRecommendationsButton) {
            recommendItems();
        }
    }

    private void recommendItems() {
        StringBuilder recommendations = new StringBuilder("Recommendations:\n");
        for (String item : boughtItems) {
            if (item.contains("Milk")) {
                recommendations.append("Similar to ").append(item).append(": Bread, Cheese\n");
            } else if (item.contains("Phone Charger")) {
                recommendations.append("Similar to ").append(item).append(": Power Bank, USB Cable\n");
            } else if (item.contains("T-shirt")) {
                recommendations.append("Similar to ").append(item).append(": Shirt, Hoodie\n");
            }
        }
        if (recommendations.length() == 15) { // If no recommendations were added
            recommendations.append("No recommendations available.");
        }
        recommendationArea.setText(recommendations.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ShoppingAssistantApp::new);
    }
}
