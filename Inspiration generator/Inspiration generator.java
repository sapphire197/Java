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
        "Believe in yourself and all that you are."
        "Your limitation—it’s only your imagination."
        "Push yourself, because no one else is going to do it for you."
        "Sometimes later becomes never. Do it now."
        "Success doesn’t just find you. You have to go out and get it."
        "Dream it. Wish it. Do it."
        "Great things never come from comfort zones."
        "Stay dedicated. It’s not going to happen overnight."
        "Work hard in silence, let success make the noise."
        "Don’t stop until you’re proud."
        "Your only limit is you."
        "Doubt kills more dreams than failure ever will."
        "You don’t have to be great to start, but you have to start to be great."
        "The harder you work for something, the greater you’ll feel when you achieve it."
        "Don’t wish for it. Work for it."
        "Success is the sum of small efforts repeated day in and day out."
        "The way to get started is to quit talking and begin doing."
        "Don’t watch the clock; do what it does. Keep going."
        "Set your goals high, and don’t stop till you get there."
        "Success is not how high you have climbed, but how you make a positive difference."
        "Dream big and dare to fail."
        "Act as if what you do makes a difference. It does."
        "What lies behind us and what lies before us are tiny matters compared to what lies within us."
        "Opportunities don't happen. You create them."
        "Your passion is waiting for your courage to catch up."
        "Believe you can, and you’re halfway there."
        "Don't limit your challenges. Challenge your limits."
        "Do what you can, with what you have, where you are."
        "Success is the best revenge."
        "If it doesn’t challenge you, it won’t change you."
        "It’s going to be hard, but hard does not mean impossible."
        "Great things take time. Be patient."
        "You are capable of amazing things."
        "Believe in your infinite potential."
        "You are stronger than you know."
        "Stay positive, work hard, make it happen."
        "The key to success is to focus on goals, not obstacles."
        "Sometimes we're tested not to show our weaknesses, but to discover our strengths."
        "Be so good they can’t ignore you."
        "The future belongs to those who believe in the beauty of their dreams."
        "The only way to achieve the impossible is to believe it is possible."
        "The secret of getting ahead is getting started."
        "In the middle of every difficulty lies opportunity."
        "The only limit to our realization of tomorrow is our doubts today."
        "Success isn’t always about greatness. It’s about consistency."
        "The only place where success comes before work is in the dictionary."
        "You don’t find willpower, you create it."
        "You only fail when you stop trying."
        "Your attitude determines your direction."
        "Discipline is the bridge between goals and accomplishment."
        "Do what is right, not what is easy."
        "Hardships often prepare ordinary people for an extraordinary destiny."
        "If you want to fly, give up everything that weighs you down."
        "Make your life a masterpiece; imagine no limitations on what you can be."
        "Stay focused, go after your dreams, and keep moving toward your goals."
        "Success is not final; failure is not fatal. It is the courage to continue that counts."
        "You are braver than you believe, stronger than you seem, and smarter than you think."
        "If people are doubting how far you can go, go so far that you can’t hear them anymore."
        "There is no elevator to success; you have to take the stairs."
        "Sometimes you win, sometimes you learn."
        "Success usually comes to those who are too busy to be looking for it."
        "Hustle until you no longer have to introduce yourself."
        "If you’re going through hell, keep going."
        "A winner is a dreamer who never gives up."
        "You don’t get what you wish for. You get what you work for."
        "Don’t downgrade your dream just to fit your reality. Upgrade your conviction."
        "Dream big, stay positive, work hard, and enjoy the journey."
        "It’s not about perfect. It’s about effort."
        "Be fearless in the pursuit of what sets your soul on fire."
        "Pain is temporary. Quitting lasts forever."
        "Doubt kills more dreams than failure ever will."
        "A goal without a plan is just a wish."
        "The best revenge is massive success."
        "Be the change you wish to see in the world."
        "Failure is not the opposite of success; it’s part of success."
        "Small steps in the right direction can turn out to be the biggest step of your life."
        "Do it now; sometimes later becomes never."
        "Be stronger than your excuses."
        "Don’t stop when you’re tired. Stop when you’re done."
        "The harder the struggle, the more glorious the triumph."
        "Fall seven times, stand up eight."
        "Believe in your dreams. They were given to you for a reason."
        "Focus on your goals, not your fear."
        "Success is walking from failure to failure with no loss of enthusiasm."
        "If you can dream it, you can do it."
        "Believe in yourself, take on your challenges, dig deep within yourself."
        "You’re allowed to scream, you’re allowed to cry, but do not give up."
        "Don’t be pushed around by the fears in your mind. Be led by the dreams in your heart."
        "The journey of a thousand miles begins with one step."
        "The road to success is always under construction."
        "What you get by achieving your goals is not as important as what you become."
        "Success is liking yourself, liking what you do, and liking how you do it."
        "Strength doesn’t come from what you can do. It comes from overcoming what you thought you couldn’t."
        "Don’t count the days; make the days count."
        "The only way to do great work is to love what you do."
        "Success is a journey, not a destination."
        "Life is about making an impact, not making an income."
        "Stay humble. Stay hungry."
        "The biggest risk is not taking any risk."
        "To succeed, we must first believe that we can."
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

