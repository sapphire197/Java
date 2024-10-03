# Simple Chat Application

This is a basic **Java Swing** application that simulates a local chat between two users. Each user has their own input field and "Send" button to send messages, which are displayed in a shared chat area.

## Features
- Two users can enter messages in their respective text fields.
- Messages from both users are displayed in the shared chat area.
- Simple GUI built using **Java Swing** components.

## Technologies Used
- Java
- Swing (JFrame, JTextArea, JTextField, JButton, JPanel)
- AWT for event handling (`ActionEvent`, `ActionListener`)

## How to Run

1. **Clone or Download the Repository**.
   - Use `git clone` to clone the project or download it as a zip file.

2. **Compile the Code**:
   - Open a terminal or command prompt.
   - Navigate to the directory where `SimpleChatApp.java` is located.
   - Run the following command to compile the Java file:
     ```bash
     javac SimpleChatApp.java
     ```

3. **Run the Application**:
   - After compiling, run the application using:
     ```bash
     java SimpleChatApp
     ```

## How It Works

- The application opens a GUI window with:
  - A shared chat area that displays the conversation between two users.
  - Two input fields at the bottom of the window for each user.
  - A "Send" button for each user to submit their message.

- Once a user types their message in the text field and clicks "Send", their message will appear in the chat area along with a user label (e.g., "User 1" or "User 2").

- Messages are appended in the chat area in the order they are sent.
