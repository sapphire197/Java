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
- **JList** for selecting items from predefined lists.
- **JTextArea** for displaying shopping lists and recommendations.
- **HashMap** for organizing items by category.

## How to Run
1. Clone the repository to your local machine.
2. Compile and run the `ShoppingAssistantApp.java` file.
3. A GUI window will appear where you can:
   - Select a category from the dropdown.
   - Choose an item from the list.
   - Click **"Add Item"** to add the selected item to your shopping list.
   - Click **"Mark as Bought"** to mark selected items from the shopping list as bought.
   - Click **"Show Recommendations"** to view suggestions based on previously bought items.

## Code Example

```java
categoryComboBox = new JComboBox<>(categories);
itemListModel = new DefaultListModel<>();
itemList = new JList<>(itemListModel);
addItemButton = new JButton("Add Item");
markAsBoughtButton = new JButton("Mark as Bought");
showRecommendationsButton = new JButton("Show Recommendations");

// Adding item to the shopping list
shoppingList.computeIfAbsent(category, k -> new ArrayList<>()).add(selectedItem);
```

## Future Enhancements
- Implement item search functionality.
- Export shopping lists to a CSV or text file.
- Add more categories and improve recommendations.
- Enhance UI/UX for better user interaction.

---