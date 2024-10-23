
# Recipe Suggestion App

This is a **Recipe Suggestion Application** developed using **Java Swing**. The app helps users get recipe suggestions based on the ingredients they have on hand. It includes basic ingredient input, recipe matching, and recipe suggestions from a predefined database. 

## Features
1. **Ingredient Input**: Users can input ingredients they have in the kitchen.
2. **Recipe Suggestion**: Based on the available ingredients, the app suggests recipes that can be made using those ingredients.
3. **Ingredient List Display**: Users can see a list of all the ingredients they've added.
4. **Recipe Display**: Recipes that match the entered ingredients are displayed in the text area. If no recipes match, the user is informed accordingly.

## How It Works

1. **Ingredient Input**: Users input ingredients in the text field and click the **"Add Ingredient"** button to add the ingredient to the list.
2. **Recipe Suggestion**: Once the ingredients are entered, the user clicks on the **"Suggest Recipe"** button to get recipe suggestions based on the ingredients provided.
3. **Ingredient Matching**: The application uses string matching to match the list of entered ingredients against predefined recipes stored in the application. If a match is found, the recipe name is displayed in the output area.

### Predefined Recipes:
- **Tomato and Cheese Sandwich**: Ingredients required: `tomato`, `cheese`.
- **Cheese Omelette**: Ingredients required: `egg`, `cheese`.
- **Mashed Potatoes with Onion**: Ingredients required: `potato`, `onion`.
- **Tomato Onion Salad**: Ingredients required: `tomato`, `onion`.
- **Tomato Pasta**: Ingredients required: `pasta`, `tomato`.
- **Tomato Scrambled Eggs**: Ingredients required: `egg`, `tomato`.

## Technologies Used
- **Java Swing**: For the user interface.
- **Java AWT**: To manage UI components and events.
- **HashMap**: To store the predefined recipes as key-value pairs (ingredients -> recipe name).
- **ArrayList**: To store the list of ingredients entered by the user.

## Code Overview

### **Main Components**:
1. **JTextField**: For users to input their ingredients.
2. **JButton**: Two buttons: 
   - One to add ingredients to the list.
   - Another to suggest recipes based on the entered ingredients.
3. **JTextArea**: Two areas:
   - One for displaying the list of ingredients entered.
   - Another for showing suggested recipes.
4. **HashMap**: Stores the recipes, where the key is a combination of ingredients, and the value is the recipe name.

### **Recipe Matching**:
The app matches ingredients using simple string matching. It compares the list of entered ingredients with the predefined recipes and suggests those that match exactly. If no recipe matches, the user is informed.

## Enhancements
Here are some ideas for how this project can be enhanced further:
1. **Database Integration**: Connect the app to a database to handle a larger collection of recipes and allow dynamic additions.
2. **Custom Recipe Input**: Allow users to input their own custom recipes, which the app can then suggest based on ingredients.
3. **Advanced Matching**: Implement an algorithm to suggest recipes even if some ingredients are missing or allow substitutions.
4. **Recipe Categories**: Add recipe categories like vegetarian, vegan, gluten-free, etc.

## Getting Started

### **Prerequisites**:
- JDK (Java Development Kit) installed on your machine.
- Basic knowledge of Java and Java Swing for further modifications.

### **How to Run the Program**:
1. **Compile the Java file**:
   ```bash
   javac RecipeSuggestionApp.java
   ```

2. **Run the program**:
   ```bash
   java RecipeSuggestionApp
   ```

## Example

### Input:
1. **Add Ingredients**: `tomato`, `cheese`
2. **Click Suggest Recipe**.

### Output:
```
Suggested Recipe:
Tomato and Cheese Sandwich
```

### If ingredients do not match any recipe:
```
No matching recipes found.
```

## Future Enhancements
- **Database Support**: To store and retrieve a large number of recipes.
- **Custom Recipe Input**: Allow users to create and save custom recipes.
- **Partial Matching**: Suggest recipes even if a few ingredients are missing, or suggest substitutes.

