# Simple Alert System

A lightweight Java-based alert system with advanced features, including customizable alert types, sound notifications, and auto-closing dialogs. Built using **Java Swing**, this project is ideal for learning and implementing notification systems in desktop applications.

---

## Features

- **Custom Alert Types**: Supports `Info`, `Warning`, `Error`, and `Default` alert categories.
- **Sound Notifications**: Plays distinct sounds for each alert type.
- **Auto-Close Feature**: Alerts automatically close after a specified duration.
- **Simple and Intuitive UI**: Easy-to-use interface with minimal buttons and actions.

---

## Project Structure

```
SimpleAlertSystem/
│
├── src/
│   └── SimpleAlertSystem.java      # Main Java code
│
├── sounds/
│   ├── info.wav                   # Sound for info alerts
│   ├── warning.wav                # Sound for warning alerts
│   ├── error.wav                  # Sound for error alerts
│   └── default.wav                # Default alert sound
│
└── README.md                       # Documentation
```

---

## Prerequisites

1. **Java Development Kit (JDK)**:
   - Install JDK 8 or later from [Oracle](https://www.oracle.com/java/technologies/javase-downloads.html) or [OpenJDK](https://openjdk.org/).
2. **Sound Files**:
   - Ensure the `sounds/` folder contains `.wav` files for different alert types.
   - Example files:
     - `info.wav`: Gentle sound for informational alerts.
     - `warning.wav`: Mild alarm for warnings.
     - `error.wav`: Critical alarm for errors.
     - `default.wav`: Default alert sound.

---

## Setup Instructions

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/your-username/SimpleAlertSystem.git
   cd SimpleAlertSystem
   ```

2. **Compile the Code**:
   ```bash
   javac src/SimpleAlertSystem.java
   ```

3. **Run the Application**:
   ```bash
   java -cp src SimpleAlertSystem
   ```

4. **Verify Alerts**:
   - Click the buttons to test different alerts.
   - Ensure sounds play and dialogs auto-close after their respective durations.

---

## How It Works

1. **Alert Dialog**:
   - The `showAlert` method dynamically generates a `JOptionPane` dialog with a custom icon and message.
   - Alerts auto-close after a timeout using `Timer` and `TimerTask`.

2. **Sound Notifications**:
   - The `playSound` method uses `javax.sound.sampled` to play `.wav` files corresponding to the alert type.

3. **UI Interaction**:
   - Buttons trigger specific alerts (`Info`, `Warning`, `Error`) using `ActionListener`.

---

## Customization

1. **Adding New Alert Types**:
   - Modify the `showAlert` method to add new cases for additional alert types.

2. **Changing Timeout**:
   - Adjust the `closeTime` parameter passed to `showAlert` for each button.

3. **Updating Sound Files**:
   - Replace the `.wav` files in the `sounds/` folder with your own custom audio.

4. **Custom Icons**:
   - Replace the default icons with your own images by setting `alertIcon` to a `new ImageIcon()`.

---

## Example Usage

1. **Triggering an Info Alert**:
   ```java
   showAlert("Info", "This is an informational alert.", "info", 3000);
   ```

2. **Triggering a Warning Alert**:
   ```java
   showAlert("Warning", "This is a warning alert.", "warning", 5000);
   ```

3. **Triggering an Error Alert**:
   ```java
   showAlert("Error", "This is an error alert.", "error", 7000);
   ```

---

## Technologies Used

- **Java Swing**: For building the graphical user interface (GUI).
- **Java Sound API**: For playing alert sounds.
- **Timer and TimerTask**: For managing alert auto-close functionality.

---

## Known Issues

- **Unsupported Sound Formats**:
  - Ensure the sound files are in `.wav` format; other formats might cause errors.
- **Slow Loading**:
  - Large sound files may delay alert display.

---

## Future Enhancements

1. **Custom Alert Designs**:
   - Add animations or transition effects to dialogs.
2. **Themed Alerts**:
   - Allow users to apply themes (dark/light mode) to alerts.
3. **Multilingual Support**:
   - Add localization to display alerts in multiple languages.
4. **Log Alerts**:
   - Maintain a log of displayed alerts in a file for reference.

---

## License

This project is licensed under the MIT License. See the `LICENSE` file for more details.

---

## Contributing

Contributions are welcome! Feel free to fork the repository, make improvements, and submit a pull request.

1. Fork the project.
2. Create your feature branch:
   ```bash
   git checkout -b feature/AmazingFeature
   ```
3. Commit your changes:
   ```bash
   git commit -m 'Add some AmazingFeature'
   ```
4. Push to the branch:
   ```bash
   git push origin feature/AmazingFeature
   ```
5. Open a pull request.

---
