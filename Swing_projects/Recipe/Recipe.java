import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

public class Recipe extends JFrame implements ActionListener {
    private JTextField ingredientField;
    private JButton addButton, suggestButton;
    private JTextArea ingredientListArea, recipeArea;

    private ArrayList<String> ingredients;
    private HashMap<String, String> recipes;

    public Recipe() {
        // Initialize ingredient list and recipe database
        ingredients = new ArrayList<>();
        recipes = new HashMap<>();
        initializeRecipes();

        // Create GUI components
        ingredientField = new JTextField(15);
        addButton = new JButton("Add Ingredient");
        suggestButton = new JButton("Suggest Recipe");
        ingredientListArea = new JTextArea(5, 20);
        recipeArea = new JTextArea(5, 20);
        recipeArea.setEditable(false);
        ingredientListArea.setEditable(false);

        addButton.addActionListener(this);
        suggestButton.addActionListener(this);

        // Layout components on panel
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Enter Ingredient:"));
        inputPanel.add(ingredientField);
        inputPanel.add(addButton);

        JPanel ingredientPanel = new JPanel();
        ingredientPanel.setLayout(new BorderLayout());
        ingredientPanel.add(new JLabel("Your Ingredients:"), BorderLayout.NORTH);
        ingredientPanel.add(new JScrollPane(ingredientListArea), BorderLayout.CENTER);

        JPanel recipePanel = new JPanel();
        recipePanel.setLayout(new BorderLayout());
        recipePanel.add(new JLabel("Suggested Recipe:"), BorderLayout.NORTH);
        recipePanel.add(new JScrollPane(recipeArea), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(suggestButton);

        // Set up main frame layout
        setLayout(new BorderLayout());
        add(inputPanel, BorderLayout.NORTH);
        add(ingredientPanel, BorderLayout.WEST);
        add(recipePanel, BorderLayout.EAST);
        add(buttonPanel, BorderLayout.SOUTH);

        setTitle("Recipe Suggestion App");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    // Initialize the recipe database with some predefined recipes
    private void initializeRecipes() {
        recipes.put("tomato,cheese", "Tomato and Cheese Sandwich");
        recipes.put("egg,cheese", "Cheese Omelette");
        recipes.put("potato,onion", "Mashed Potatoes with Onion");
        recipes.put("tomato,onion", "Tomato Onion Salad");
        recipes.put("pasta,tomato", "Tomato Pasta");
        recipes.put("egg,tomato", "Tomato Scrambled Eggs");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            String ingredient = ingredientField.getText().trim().toLowerCase();
            if (!ingredient.isEmpty() && !ingredients.contains(ingredient)) {
                ingredients.add(ingredient);
                ingredientField.setText("");
                updateIngredientList();
            }
        } else if (e.getSource() == suggestButton) {
            suggestRecipe();
        }
    }

    // Update the ingredients text area
    private void updateIngredientList() {
        ingredientListArea.setText("");
        for (String ingredient : ingredients) {
            ingredientListArea.append(ingredient + "\n");
        }
    }

    // Suggest a recipe based on the current list of ingredients
    private void suggestRecipe() {
        recipeArea.setText("");
        for (String key : recipes.keySet()) {
            String[] requiredIngredients = key.split(",");
            if (ingredients.containsAll(java.util.Arrays.asList(requiredIngredients))) {
                recipeArea.append(recipes.get(key) + "\n");
            }
        }

        if (recipeArea.getText().isEmpty()) {
            recipeArea.setText("No matching recipes found.");
        }
    }

    public static void main(String[] args) {
        new Recipe();
    }
}
