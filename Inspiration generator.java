import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MotivationApp extends JFrame {
    private JLabel quoteLabel;
    private JButton nextButton;
    private int quoteIndex = 0;
    
    // Array of motivational quotes
    private String[] quotes = {
        "Believe in yourself and all that you are.",
        "Your limitation—it’s only your imagination.",
        "Push yourself, because no one else is going to do it for you.",
        "Sometimes later becomes never. Do it now.",
        "Success doesn’t just find you. You have to go out and get it.",
        "Dream it. Wish it. Do it.",
        "Great things never come from comfort zones.",
        "Stay dedicated. It’s not going to happen overnight.",
        "Work hard in silence, let success make the noise.",
        "Don’t stop until you’re proud."
    };

    public MotivationApp() {
        // Set up the frame
        setTitle("Motivation & Dedication");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create the quote label and set its properties
        quoteLabel = new JLabel(quotes[quoteIndex], SwingConstants.CENTER);
        quoteLabel.setFont(new Font("Arial", Font.BOLD, 16));
        quoteLabel.setForeground(new Color(51, 102, 255));

        // Create the "Next Quote" button and add an action listener
        nextButton = new JButton("Next Quote");
        nextButton.setFont(new Font("Arial", Font.PLAIN, 14));
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showNextQuote();
            }
        });

        // Set up the layout and add components
        setLayout(new BorderLayout());
        add(quoteLabel, BorderLayout.CENTER);
        add(nextButton, BorderLayout.SOUTH);
    }

    // Method to show the next quote
    private void showNextQuote() {
        quoteIndex = (quoteIndex + 1) % quotes.length; // Cycle through quotes
        quoteLabel.setText(quotes[quoteIndex]);
    }

    public static void main(String[] args) {
        // Create and display the app
        SwingUtilities.invokeLater(() -> {
            MotivationApp app = new MotivationApp();
            app.setVisible(true);
        });
    }
}
