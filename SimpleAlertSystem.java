import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;
import javax.sound.sampled.*;
import java.io.File;

public class SimpleAlertSystem {

    // Method to show an alert dialog with advanced features
    public static void showAlert(String alertTitle, String alertMsg, String alertType, int closeTime) {
        Icon alertIcon;
        String soundPath;

        // Set icon and sound based on alert type
        switch (alertType.toLowerCase()) {
            case "info":
                alertIcon = UIManager.getIcon("OptionPane.informationIcon");
                soundPath = "sounds/info.wav";
                break;
            case "warning":
                alertIcon = UIManager.getIcon("OptionPane.warningIcon");
                soundPath = "sounds/warning.wav";
                break;
            case "error":
                alertIcon = UIManager.getIcon("OptionPane.errorIcon");
                soundPath = "sounds/error.wav";
                break;
            default:
                alertIcon = UIManager.getIcon("OptionPane.questionIcon");
                soundPath = "sounds/default.wav";
        }

        // Play sound
        playSound(soundPath);

        // Create alert dialog
        JDialog alertDialog = new JDialog();
        alertDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        JOptionPane alertPane = new JOptionPane(alertMsg, JOptionPane.PLAIN_MESSAGE, JOptionPane.DEFAULT_OPTION, alertIcon);
        alertDialog.setContentPane(alertPane);
        alertDialog.setTitle(alertTitle);
        alertDialog.pack();
        alertDialog.setLocationRelativeTo(null);
        alertDialog.setVisible(true);

        // Close the alert automatically after specified time
        Timer closeTimer = new Timer();
        closeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                alertDialog.dispose();
            }
        }, closeTime);
    }

    // Method to play sound
    private static void playSound(String soundFile) {
        try {
            File file = new File(soundFile);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
            Clip audioClip = AudioSystem.getClip();
            audioClip.open(audioStream);
            audioClip.start();
        } catch (Exception e) {
            System.err.println("Sound error: " + e.getMessage());
        }
    }

    // Main method to test alerts
    public static void main(String[] args) {
        JFrame window = new JFrame("Simple Alert System");
        window.setSize(400, 300);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(new FlowLayout());

        // Buttons for different alerts
        JButton infoBtn = new JButton("Info Alert");
        JButton warningBtn = new JButton("Warning Alert");
        JButton errorBtn = new JButton("Error Alert");

        infoBtn.addActionListener(e -> showAlert("Info", "This is an info alert.", "info", 3000));
        warningBtn.addActionListener(e -> showAlert("Warning", "This is a warning alert.", "warning", 5000));
        errorBtn.addActionListener(e -> showAlert("Error", "This is an error alert.", "error", 7000));

        // Add buttons to the window
        window.add(infoBtn);
        window.add(warningBtn);
        window.add(errorBtn);

        window.setVisible(true);
    }
}
