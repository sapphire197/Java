

### Enhanced Code: `AdvancedAlertSystem.java`
```java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;
import javax.sound.sampled.*;
import java.io.File;

public class AdvancedAlertSystem {

    // Method to show an alert dialog with advanced features
    public static void showAlert(String title, String message, String alertType, int timeout) {
        // Set the icon based on alert type
        Icon icon;
        String soundFile;
        switch (alertType.toLowerCase()) {
            case "info":
                icon = UIManager.getIcon("OptionPane.informationIcon");
                soundFile = "sounds/info.wav";
                break;
            case "warning":
                icon = UIManager.getIcon("OptionPane.warningIcon");
                soundFile = "sounds/warning.wav";
                break;
            case "error":
                icon = UIManager.getIcon("OptionPane.errorIcon");
                soundFile = "sounds/error.wav";
                break;
            default:
                icon = UIManager.getIcon("OptionPane.questionIcon");
                soundFile = "sounds/default.wav";
        }

        // Play sound notification
        playSound(soundFile);

        // Create the JOptionPane dialog
        JDialog dialog = new JDialog();
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        JOptionPane optionPane = new JOptionPane(message, JOptionPane.PLAIN_MESSAGE, JOptionPane.DEFAULT_OPTION, icon);
        dialog.setContentPane(optionPane);
        dialog.setTitle(title);
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);

        // Set a timeout to auto-close the dialog
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                dialog.dispose();
            }
        }, timeout);
    }

    // Method to play sound notifications
    private static void playSound(String soundFile) {
        try {
            File audioFile = new File(soundFile);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (Exception e) {
            System.err.println("Error playing sound: " + e.getMessage());
        }
    }

    // Sample usage of the alert system
    public static void main(String[] args) {
        JFrame frame = new JFrame("Advanced Alert System");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        // Buttons for different alerts
        JButton infoButton = new JButton("Info Alert");
        JButton warningButton = new JButton("Warning Alert");
        JButton errorButton = new JButton("Error Alert");

        infoButton.addActionListener(e -> showAlert("Information", "This is an info alert.", "info", 3000));
        warningButton.addActionListener(e -> showAlert("Warning", "This is a warning alert.", "warning", 5000));
        errorButton.addActionListener(e -> showAlert("Error", "This is an error alert.", "error", 7000));

        frame.add(infoButton);
        frame.add(warningButton);
        frame.add(errorButton);

        frame.setVisible(true);
    }
}
```

---

### Explanation of Enhancements
1. **Sound Notifications**:
   - The `playSound` method plays a specific sound file based on the alert type.
   - Ensure that the `sounds/` folder contains the `.wav` files (`info.wav`, `warning.wav`, `error.wav`).

2. **Timeout Alerts**:
   - The `TimerTask` is used to automatically close the dialog after the specified timeout (in milliseconds).

3. **Custom Icons**:
   - Uses different icons provided by the `UIManager` for each alert type.

---

### Required Files
- **Sound Files**: Create a folder named `sounds` in the project directory with the following files:
  - `info.wav`
  - `warning.wav`
  - `error.wav`
  - `default.wav`

Make sure these sound files are in `.wav` format and stored in the correct directory.

---

### Running the Enhanced Application
1. Compile the Java file:
   ```bash
   javac AdvancedAlertSystem.java
   ```
2. Run the compiled Java program:
   ```bash
   java AdvancedAlertSystem
   ```

The application window will display buttons to trigger different types of alerts, each with its own sound and auto-closing behavior.

This code covers all the enhancements requested. Let me know if you need further modifications!
