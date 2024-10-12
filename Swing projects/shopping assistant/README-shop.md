# Smart Shopping Assistant

## Description
The **Smart Shopping Assistant** is a Java Swing application that helps users manage their shopping lists by categorizing items (e.g., Groceries, Electronics, Clothes). It tracks which items have been purchased and provides recommendations based on previously bought products.

## Features
- **Category Selection**: Add items under categories like Groceries, Electronics, or Clothes.
- **Item Status**: Mark items as "Pending" or "Bought."
- **Shopping List**: View all items added to your shopping list.
- **Recommendations**: Receive suggestions based on past purchases.

## Technologies Used
- **Java** for core functionality.
- **Swing** for building the user interface.
- **JComboBox** for selecting item categories.
- **JTextArea** for displaying shopping lists and recommendations.
- **HashMap** for organizing items by category.

## How to Run
1. Clone the repository to your local machine.
2. Compile and run the `ShoppingAssistantApp.java` file.
3. A GUI window will appear where you can:
   - Add items to the shopping list.
   - Mark items as "Bought."
   - View shopping recommendations based on purchased items.

## Code Example

```java
categoryComboBox = new JComboBox<>(categories);
addItemButton = new JButton("Add Item");
markAsBoughtButton = new JButton("Mark as Bought");
showRecommendationsButton = new JButton("Show Recommendations");
...
shoppingList.computeIfAbsent(category, k -> new ArrayList<>()).add(item);
...
recommendationArea.setText(recommendations.toString());
```
## Future Enhancements
Implement item search functionality.
Export shopping lists to a CSV or text file.
Add more categories and improve recommendations.
