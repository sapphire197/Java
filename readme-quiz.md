# Quiz Application

## Overview

The Quiz Application is a simple, interactive Java-based program that allows users to answer multiple-choice questions and receive a score based on their performance. It uses Java Swing for the graphical user interface (GUI) and follows an object-oriented structure for easy management and expansion of quiz questions.

## Features

- **Interactive GUI**: Easy-to-use interface with questions displayed one at a time.
- **Multiple-Choice Questions**: Each question includes four possible answers.
- **Score Calculation**: Score is updated based on correct answers and displayed at the end of the quiz.
- **Randomized Questions**: Ability to add a variety of questions and extend the quiz.

## Project Structure

### Files

1. **Question.java**: Contains the `Question` class to represent each quiz question.
2. **Quiz.java**: Contains the `Quiz` class to manage the list of questions and scoring.
3. **QuizApp.java**: Main application class that displays the GUI, handles user interaction, and manages the quiz flow.

### Classes

- **Question**: Stores individual question details, including text, options, and the correct answer.
- **Quiz**: Manages the list of questions, tracks the current question, and keeps score.
- **QuizApp**: Main class that runs the GUI, handles interactions, displays questions, and shows the score.

## Installation and Setup

### Prerequisites

- **Java Development Kit (JDK)**: Version 8 or higher is recommended.
- **Java Swing**: Included in the standard JDK, so no additional libraries are needed.

### Steps to Run

1. **Clone the Repository**
   ```bash
   git clone https://github.com/yourusername/QuizApplication.git
   cd QuizApplication
   ```

2. **Compile the Code**
   Ensure that all `.java` files are compiled in the same directory:
   ```bash
   javac Question.java Quiz.java QuizApp.java
   ```

3. **Run the Application**
   ```bash
   java QuizApp
   ```

## Code Structure and Explanation

### 1. Question.java

```java
public class Question {
    private String questionText;
    private String[] options;
    private String correctAnswer;

    public Question(String questionText, String[] options, String correctAnswer) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String[] getOptions() {
        return options;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public boolean isCorrect(String answer) {
        return correctAnswer.equals(answer);
    }
}
```

This class defines a `Question` object with:
- `questionText`: The question prompt.
- `options`: Array containing answer choices.
- `correctAnswer`: The correct answer for validation.

### 2. Quiz.java

```java
import java.util.ArrayList;
import java.util.List;

public class Quiz {
    private List<Question> questions;
    private int currentQuestionIndex;
    private int score;

    public Quiz() {
        questions = new ArrayList<>();
        currentQuestionIndex = 0;
        score = 0;
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public Question getNextQuestion() {
        if (currentQuestionIndex < questions.size()) {
            return questions.get(currentQuestionIndex++);
        } else {
            return null;
        }
    }

    public int getScore() {
        return score;
    }

    public void incrementScore() {
        score++;
    }

    public int getTotalQuestions() {
        return questions.size();
    }
}
```

This class manages:
- A list of `Question` objects.
- `currentQuestionIndex`: Tracks which question is being asked.
- `score`: Keeps track of correct answers.

### 3. QuizApp.java

```java
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuizApp extends JFrame {
    private Quiz quiz;
    private Question currentQuestion;

    private JLabel questionLabel;
    private JRadioButton[] optionButtons;
    private ButtonGroup optionsGroup;
    private JButton nextButton;

    public QuizApp() {
        quiz = new Quiz();
        setupQuestions();
        setupUI();
        loadNextQuestion();
    }

    private void setupQuestions() {
        quiz.addQuestion(new Question("What is the capital of France?", new String[]{"Paris", "Rome", "Berlin", "Madrid"}, "Paris"));
        quiz.addQuestion(new Question("Which planet is known as the Red Planet?", new String[]{"Earth", "Mars", "Jupiter", "Venus"}, "Mars"));
        quiz.addQuestion(new Question("What is the largest mammal?", new String[]{"Elephant", "Whale", "Tiger", "Shark"}, "Whale"));
    }

    private void setupUI() {
        setTitle("Quiz Application");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        questionLabel = new JLabel("Question");
        add(questionLabel, BorderLayout.NORTH);

        JPanel optionsPanel = new JPanel();
        optionsPanel.setLayout(new GridLayout(4, 1));
        optionButtons = new JRadioButton[4];
        optionsGroup = new ButtonGroup();

        for (int i = 0; i < 4; i++) {
            optionButtons[i] = new JRadioButton();
            optionsGroup.add(optionButtons[i]);
            optionsPanel.add(optionButtons[i]);
        }
        add(optionsPanel, BorderLayout.CENTER);

        nextButton = new JButton("Next");
        nextButton.addActionListener(new NextButtonListener());
        add(nextButton, BorderLayout.SOUTH);
    }

    private void loadNextQuestion() {
        currentQuestion = quiz.getNextQuestion();
        if (currentQuestion != null) {
            questionLabel.setText(currentQuestion.getQuestionText());
            String[] options = currentQuestion.getOptions();
            for (int i = 0; i < options.length; i++) {
                optionButtons[i].setText(options[i]);
                optionButtons[i].setSelected(false);
            }
        } else {
            showScore();
        }
    }

    private void showScore() {
        JOptionPane.showMessageDialog(this, "Quiz Over! Your score is " + quiz.getScore() + " out of " + quiz.getTotalQuestions());
        System.exit(0);
    }

    private class NextButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (currentQuestion == null) {
                showScore();
                return;
            }

            String selectedAnswer = null;
            for (JRadioButton optionButton : optionButtons) {
                if (optionButton.isSelected()) {
                    selectedAnswer = optionButton.getText();
                    break;
                }
            }

            if (selectedAnswer == null) {
                JOptionPane.showMessageDialog(QuizApp.this, "Please select an answer.");
                return;
            }

            if (currentQuestion.isCorrect(selectedAnswer)) {
                quiz.incrementScore();
            }

            loadNextQuestion();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            QuizApp app = new QuizApp();
            app.setVisible(true);
        });
    }
}
```

The main class creates the GUI, loads questions, and manages user interactions.

## How to Add More Questions

To add more questions:
1. Open the `setupQuestions()` method in `QuizApp`.
2. Use the `addQuestion()` method to add questions, following the existing format.

Example:
```java
quiz.addQuestion(new Question("What is the largest planet?", new String[]{"Earth", "Mars", "Jupiter", "Saturn"}, "Jupiter"));
```

## Future Improvements

- **Randomized Questions**: Shuffle the questions for a more dynamic experience.
- **Leaderboard**: Track high scores.
- **Persistence**: Save scores and user data in a file or database.
- **Time Limit**: Implement a timer for each question.
