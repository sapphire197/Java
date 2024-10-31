import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class EnhancedMotivationApp extends JFrame {
    private JLabel quoteLabel;
    private JButton nextButton, exitButton;
    private Random random = new Random();
    
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

    // Array of different font styles for variety
    private Font[] fonts = {
        new Font("Arial", Font.BOLD, 18),
        new Font("Serif", Font.ITALIC, 18),
        new Font("SansSerif", Font.PLAIN, 18),
        new Font("Verdana", Font.BOLD | Font.ITALIC, 18),
        new Font("Tahoma", Font.PLAIN, 18)
    };

    public EnhancedMotivationApp() {
        // Set up the frame
        setTitle("Enhanced Motivation & Dedication");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create the quote label and set its properties
        quoteLabel = new JLabel(getRandomQuote(), SwingConstants.CENTER);
        quoteLabel.setFont(getRandomFont());
        quoteLabel.setForeground(Color.WHITE);

        // Create the "Next Quote" button and add an action listener
        nextButton = new JButton("Next Quote");
        nextButton.setFont(new Font("Arial", Font.PLAIN, 14));
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateQuoteAndStyle();
            }
        });

        // Create the "Exit" button to close the application
        exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Arial", Font.PLAIN, 14));
        exitButton.addActionListener(e -> System.exit(0));

        // Set up the layout and add components
        setLayout(new BorderLayout());
        add(quoteLabel, BorderLayout.CENTER);

        // Panel for buttons at the bottom
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(nextButton);
        buttonPanel.add(exitButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // Initial background color
        getContentPane().setBackground(getRandomColor());
    }

    // Method to update the quote, font, and background color
    private void updateQuoteAndStyle() {
        quoteLabel.setText(getRandomQuote());
        quoteLabel.setFont(getRandomFont());
        getContentPane().setBackground(getRandomColor());
    }

    // Get a random quote from the array
    private String getRandomQuote() {
        int index = random.nextInt(quotes.length);
        return quotes[index];
    }

    // Get a random font from the array
    private Font getRandomFont() {
        int index = random.nextInt(fonts.length);
        return fonts[index];
    }

    // Generate a random background color
    private Color getRandomColor() {
        int red = random.nextInt(256);
        int green = random.nextInt(256);
        int blue = random.nextInt(256);
        return new Color(red, green, blue);
    }

    public static void main(String[] args) {
        // Create and display the app
        SwingUtilities.invokeLater(() -> {
            EnhancedMotivationApp app = new EnhancedMotivationApp();
            app.setVisible(true);
        });
    }
}

