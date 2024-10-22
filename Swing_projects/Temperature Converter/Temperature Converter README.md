# Temperature Converter Application

A simple **Java Swing** GUI application that allows users to convert temperatures between Celsius and Fahrenheit.

## Features
- Convert temperature from Celsius to Fahrenheit.
- Convert temperature from Fahrenheit to Celsius.
- Simple and user-friendly interface.
- Displays the result of the conversion.

## Technologies Used
- Java
- Swing (JFrame, JTextField, JRadioButton, JButton, JLabel, JPanel)
- AWT for event handling (`ActionEvent`, `ActionListener`)

## How to Run

1. **Clone or Download the Repository**.
   - Use `git clone` to clone the project or download it as a zip file.

2. **Compile the Code**:
   - Open a terminal or command prompt.
   - Navigate to the directory where `TemperatureConverter.java` is located.
   - Run the following command to compile the Java file:
     ```bash
     javac TemperatureConverter.java
     ```

3. **Run the Application**:
   - After compiling, run the application using:
     ```bash
     java TemperatureConverter
     ```

## How It Works

- The application opens a GUI window with:
  - An input field to enter the temperature.
  - Two radio buttons to choose between Celsius to Fahrenheit conversion or Fahrenheit to Celsius conversion.
  - A "Convert" button to perform the conversion.
  - A label to display the result of the conversion.

- Enter the temperature in the input field, select the desired conversion, and click "Convert". The result will be displayed below the button.

- If an invalid input (non-numeric) is entered, an error message ("Invalid input!") will be displayed.
