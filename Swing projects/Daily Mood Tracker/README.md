# Daily Mood Tracker

## Description
The **Daily Mood Tracker** is a simple Java Swing application that allows users to log their mood throughout the day. It enables users to select moods like Happy, Sad, Angry, and Neutral. At the end of the day, users can review their emotional trends and receive feedback based on their entries.

## Features
- **Mood Input**: Choose from Happy, Sad, Angry, or Neutral.
- **Timestamped Log**: Every mood entry is logged with a timestamp.
- **Mood Summary**: Provides a summary and feedback on emotional patterns at the end of the day.
- **Feedback**: Simple feedback such as "You were mostly happy today!" based on the most frequently logged mood.

## Technologies Used
- **Java** for the core logic.
- **Swing** for the GUI (Graphical User Interface).
- **JTextArea** for displaying mood logs.
- **JButton** for logging mood and generating summaries.
- **JOptionPane** for mood summary feedback.

## How to Run
1. Clone the repository to your local machine.
2. Compile and run the `MoodTrackerApp.java` file.
3. A GUI window will appear, allowing you to select and log your mood.
4. Press "Show Summary" at the end of the day to view your emotional trend.

## Code Example

```java
JButton happyButton = new JButton("Happy");
JButton sadButton = new JButton("Sad");
JButton angryButton = new JButton("Angry");
JButton neutralButton = new JButton("Neutral");
JButton showSummaryButton = new JButton("Show Summary");
...
chatArea.append(mood + " at " + timeStamp + "\n");
...
JOptionPane.showMessageDialog(this, summary);
```
## Future Enhancements
Add more mood options.<br>
Export mood logs to a CSV or text file.<br>
Add graphical mood charts for visualization.
