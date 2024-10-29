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
        // Add questions here
        quiz.addQuestion(new Question("What is the capital of France?",
                new String[] { "Paris", "Rome", "Berlin", "Madrid" }, "Paris"));
        quiz.addQuestion(new Question("Which planet is known as the Red Planet?",
                new String[] { "Earth", "Mars", "Jupiter", "Venus" }, "Mars"));
        quiz.addQuestion(new Question("What is the largest mammal?",
                new String[] { "Elephant", "Whale", "Tiger", "Shark" }, "Whale"));
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
        JOptionPane.showMessageDialog(this,
                "Quiz Over! Your score is " + quiz.getScore() + " out of " + quiz.getTotalQuestions());
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
