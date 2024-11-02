# Task Management System with Real-Time Collaboration

## Overview
The **Task Management System with Real-Time Collaboration** is a desktop application built using Java Swing that allows users to manage tasks, collaborate in real-time, and track deadlines. This system supports multiple users and provides features such as task prioritization, real-time chat, and notifications.

## Features
- User authentication and management
- Create, edit, and delete tasks
- Set deadlines and priorities
- Real-time collaboration through chat
- Notifications for task updates and deadlines

## File Structure
```
TaskManagementSystem/
│
├── src/
│   ├── DatabaseConnection.java         # Database connection utility
│   ├── UserAuthentication.java         # User authentication logic
│   ├── TaskManager.java                 # Task management logic
│   ├── Server.java                      # Server for real-time collaboration
│   ├── Client.java                      # Client for real-time collaboration
│   ├── Task.java                       # Task model class
│   └── Main.java                       # Main application entry point
│
├── db/
│   └── setup.sql                       # SQL script to set up the database
│
├── lib/                                # Any additional libraries (if needed)
│
└── README.md                           # Project documentation
```

## Prerequisites
- Java Development Kit (JDK 8 or higher)
- MySQL Server
- IDE (Eclipse, IntelliJ IDEA, or similar)

## Setup Steps

### 1. Clone the Repository
Clone this repository to your local machine using:
```bash
git clone https://github.com/yourusername/TaskManagementSystem.git
```
Navigate to the project directory:
```bash
cd TaskManagementSystem
```

### 2. Set Up the MySQL Database
- Open your MySQL client (e.g., MySQL Workbench).
- Create a new database by running the following SQL script located in `db/setup.sql`:

```sql
CREATE DATABASE task_management;

USE task_management;

CREATE TABLE users (
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL
);

CREATE TABLE tasks (
    task_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    title VARCHAR(100),
    description TEXT,
    priority INT,
    deadline DATE,
    status VARCHAR(20),
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);
```

### 3. Configure Database Connection
Edit the `DatabaseConnection.java` file to set your MySQL credentials:
```java
private static final String URL = "jdbc:mysql://localhost:3306/task_management";
private static final String USER = "your_username";
private static final String PASSWORD = "your_password";
```

### 4. Compile the Project
Use your IDE to compile the project, ensuring all dependencies are included.

### 5. Run the Server
- Open a terminal or command prompt.
- Navigate to the project directory and run the server:
```bash
java src.Server
```

### 6. Run the Client
- Open another terminal or command prompt.
- In the project directory, run the client:
```bash
java src.Client
```

### 7. Create User Accounts
1. Use the client application to create user accounts.
2. Log in with the created accounts to manage tasks.

## Usage
- After logging in, users can:
  - Create new tasks with titles, descriptions, priorities, and deadlines.
  - Edit existing tasks to update their status or details.
  - Delete tasks that are no longer needed.
  - Use the chat feature to communicate with other users in real-time.

## Additional Features
- Integrate a reminder system using `java.util.Timer` for upcoming deadlines.
- Use libraries like JFreeChart to visualize task statistics.

## Contributing
If you'd like to contribute to this project, feel free to fork the repository and submit a pull request with your improvements or features.
