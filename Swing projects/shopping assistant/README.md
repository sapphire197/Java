Project Title:
Daily Mood Tracker

Description:
The Daily Mood Tracker is a simple Java Swing application designed to help users log their moods throughout the day. Users can select different moods (Happy, Sad, Angry, Neutral) at any time, and the application timestamps each entry. At the end of the day, users can view a summary of their mood trends and receive feedback based on their emotional patterns.

Features:
Mood Input: Users can choose from four predefined moods: Happy, Sad, Angry, or Neutral.
Timestamped Entries: Each mood entry is automatically timestamped and displayed in a text area.
Mood Summary: The application generates a mood summary at the end of the day, providing simple feedback based on the most frequently logged mood.
Feedback: The application offers insights such as "You were mostly happy today!" or "Try to relax more tomorrow."
Technologies Used:
Java: Programming language.
Swing: Java GUI framework for building the user interface.
ArrayList: Used to store mood entries and timestamps.
JTextArea: Displays the mood log and summary.
JButton: Used for mood selection and summary display.
JOptionPane: Displays the mood summary and feedback.
How to Run:
Download the source code.
Compile and run the MoodTrackerApp.java file.
A GUI window will appear where you can select moods and log them throughout the day.
At the end of the day, press the "Show Summary" button to view the mood summary.
Code Snippet:
java
Copy code
happyButton = new JButton("Happy");
sadButton = new JButton("Sad");
angryButton = new JButton("Angry");
neutralButton = new JButton("Neutral");
showSummaryButton = new JButton("Show Summary");
...
moodDisplay.append(mood + " at " + timeStamp + "\n");
...
JOptionPane.showMessageDialog(this, summary);
Future Enhancements:
Adding more mood options.
Exporting mood logs to a CSV file.
Implementing a chart-based mood visualization.
