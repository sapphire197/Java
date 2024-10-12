import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

public class ShoppingAssistantApp extends JFrame implements ActionListener {
    private JComboBox<String> categoryComboBox;
    private JTextField itemInput;
    private JTextArea shoppingListArea, recommendationArea;
    private JButton addItemButton, markAsBoughtButton, showRecommendationsButton;
    private HashMap<String, ArrayList<String>> shoppingList;
    private ArrayList<String> boughtItems;

    public ShoppingAssistantApp() {
        // Initialize components
        String[] categories = { "Groceries", "Electronics", "Clothes" };
        categoryComboBox = new JComboBox<>(categories);
        itemInput = new JTextField(15);
        shoppingListArea = new JTextArea(10, 20);
        recommendationArea = new JTextArea(5, 20);
        addItemButton = new JButton("Add Item");
        markAsBoughtButton = new JButton("Mark as Bought");
        showRecommendationsButton = new JButton("Show Recommendations");

        shoppingListArea.setEditable(false);
        recommendationArea.setEditable(false);

        shoppingList = new HashMap<>();
        boughtItems = new ArrayList<>();

        // Set up layout and add components
        JPanel panel = new JPanel();
        panel.add(new JLabel("Select Category:"));
        panel.add(categoryComboBox);
        panel.add(new JLabel("Enter Item:"));
        panel.add(itemInput);
        panel.add(addItemButton);
        panel.add(markAsBoughtButton);
        panel.add(showRecommendationsButton);
        panel.add(new JScrollPane(shoppingListArea));
        panel.add(new JScrollPane(recommendationArea));

        addItemButton.addActionListener(this);
        markAsBoughtButton.addActionListener(this);
        showRecommendationsButton.addActionListener(this);

        setLayout(new FlowLayout());
        add(panel);

        // Window settings
        setTitle("Smart Shopping Assistant");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addItemButton) {
            String category = (String) categoryComboBox.getSelectedItem();
            String item = itemInput.getText();
            if (!item.isEmpty()) {
                shoppingList.computeIfAbsent(category, k -> new ArrayList<>()).add(item);
                shoppingListArea.append(category + ": " + item + "\n");
                itemInput.setText("");
            }
        } else if (e.getSource() == markAsBoughtButton) {
            String selectedText = shoppingListArea.getSelectedText();
            if (selectedText != null && !boughtItems.contains(selectedText)) {
                boughtItems.add(selectedText);
                shoppingListArea.append(selectedText + " - Bought\n");
            }
        } else if (e.getSource() == showRecommendationsButton) {
            recommendItems();
        }
    }

    private void recommendItems() {
        StringBuilder recommendations = new StringBuilder("Recommendations:\n");
        for (String item : boughtItems) {
            if (item.contains("Groceries")) {
                recommendations.append("Similar to ").append(item).append(": Milk, Bread\n");
            } else if (item.contains("Electronics")) {
                recommendations.append("Similar to ").append(item).append(": Phone Charger\n");
            } else if (item.contains("Clothes")) {
                recommendations.append("Similar to ").append(item).append(": T-shirts, Jeans\n");
            }
        }
        recommendationArea.setText(recommendations.toString());
    }

    public static void main(String[] args) {
        new ShoppingAssistantApp();
    }
}
