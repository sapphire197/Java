import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MoodTrackerApp extends JFrame implements ActionListener {
    private ArrayList<String> moodList;
    private JTextArea moodDisplay;
    private JButton happyButton, sadButton, angryButton, neutralButton, showSummaryButton;

    public MoodTrackerApp() {
        // Initialize components
        moodList = new ArrayList<>();
        moodDisplay = new JTextArea(10, 30);
        moodDisplay.setEditable(false);

        happyButton = new JButton("Happy");
        sadButton = new JButton("Sad");
        angryButton = new JButton("Angry");
        neutralButton = new JButton("Neutral");
        showSummaryButton = new JButton("Show Summary");

        // Set layout and add components
        JPanel moodPanel = new JPanel();
        moodPanel.add(happyButton);
        moodPanel.add(sadButton);
        moodPanel.add(angryButton);
        moodPanel.add(neutralButton);
        moodPanel.add(showSummaryButton);
        add(new JScrollPane(moodDisplay), BorderLayout.CENTER);
        add(moodPanel, BorderLayout.SOUTH);

        // Add action listeners
        happyButton.addActionListener(this);
        sadButton.addActionListener(this);
        angryButton.addActionListener(this);
        neutralButton.addActionListener(this);
        showSummaryButton.addActionListener(this);

        // Set window properties
        setTitle("Daily Mood Tracker");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String mood = "";
        if (e.getSource() == happyButton) mood = "Happy";
        if (e.getSource() == sadButton) mood = "Sad";
        if (e.getSource() == angryButton) mood = "Angry";
        if (e.getSource() == neutralButton) mood = "Neutral";

        if (!mood.isEmpty()) {
            String timeStamp = new SimpleDateFormat("HH:mm:ss").format(new Date());
            moodList.add(mood + " at " + timeStamp);
            moodDisplay.append(mood + " at " + timeStamp + "\n");
        }

        if (e.getSource() == showSummaryButton) {
            showMoodSummary();
        }
    }

    private void showMoodSummary() {
        int happyCount = 0, sadCount = 0, angryCount = 0, neutralCount = 0;
        for (String moodEntry : moodList) {
            if (moodEntry.contains("Happy")) happyCount++;
            if (moodEntry.contains("Sad")) sadCount++;
            if (moodEntry.contains("Angry")) angryCount++;
            if (moodEntry.contains("Neutral")) neutralCount++;
        }

        String summary = "Mood Summary:\n";
        summary += "Happy: " + happyCount + "\n";
        summary += "Sad: " + sadCount + "\n";
        summary += "Angry: " + angryCount + "\n";
        summary += "Neutral: " + neutralCount + "\n";

        if (happyCount > sadCount && happyCount > angryCount) {
            summary += "You had a mostly happy day!";
        } else if (sadCount > happyCount) {
            summary += "You seemed a bit sad today. Hope tomorrow is better!";
        } else if (angryCount > happyCount) {
            summary += "Try to calm down and relax.";
        } else {
            summary += "You had a neutral day!";
        }

        JOptionPane.showMessageDialog(this, summary);
    }

    public static void main(String[] args) {
        new MoodTrackerApp();
    }
}
