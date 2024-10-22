# Contact Management System

## Overview
The Contact Management System is a simple Java Swing application that allows users to manage their contacts by adding, displaying, and deleting them. Each contact consists of a name, phone number, and email address. This application is designed to demonstrate basic GUI development with Java and object-oriented programming concepts.

## Features
- **Add Contact**: Users can add a new contact by entering the name, phone number, and email address.
- **Delete Contact**: Users can delete a selected contact from the list.
- **Display Contacts**: All contacts are displayed in a list format for easy viewing.
- **Input Validation**: The application checks that all fields are filled before adding a contact and prompts the user if not.

## Requirements
- Java Development Kit (JDK) 8 or higher
- Integrated Development Environment (IDE) such as Eclipse, IntelliJ IDEA, or any text editor

## How to Run the Application
1. **Clone the Repository**:
   ```bash
   git clone https://github.com/yourusername/contact-management-system.git
   cd contact-management-system
   ```

2. **Compile the Code**:
   Ensure you are in the directory where the `ContactManager.java` file is located. Use the following command to compile the code:
   ```bash
   javac ContactManager.java
   ```

3. **Run the Application**:
   After compiling, run the application using:
   ```bash
   java ContactManager
   ```

4. **Usage Instructions**:
   - Enter the contact details in the provided text fields.
   - Click "Add Contact" to add the contact to the list.
   - Select a contact from the list and click "Delete Contact" to remove it.

## Improvements and Future Enhancements
While the Contact Management System provides a basic interface for managing contacts, there are several potential improvements and features that could enhance its functionality:

1. **Persistent Storage**: Implement file storage (e.g., CSV, JSON) or database integration (e.g., SQLite) to save contacts so that they remain available even after the application is closed.

2. **Edit Contact**: Allow users to edit existing contact details after selection, providing a more complete management experience.

3. **Search Functionality**: Add a search feature to quickly find contacts by name, phone, or email.

4. **Improved User Interface**: Enhance the UI with better styling, layout adjustments, and user experience improvements.

5. **Contact Categories**: Implement categories or tags for contacts to organize them better.

6. **Multi-threading**: Utilize multi-threading to improve performance, especially if integrating with a database for larger contact lists.

7. **Unit Testing**: Write unit tests for the Contact class and the overall application logic to ensure reliability and ease of maintenance.
