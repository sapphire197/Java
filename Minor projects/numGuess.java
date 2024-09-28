import java.util.Scanner;
import java.util.Random;

public class numGuess {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        Random random = new Random();
        int minRange = 1;
        int maxRange = 100;
        int limit = 6;
        int totalScore = 0;

        System.out.println("Welcome to the Random Number Guessing Game!");

        boolean play = true;
        while (play) {
            int secretNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            System.out.println("I've picked a number between " + minRange + " and " + maxRange + ". Can you guess it?");
            System.out.println("You will have 6 attempts to guess it correctly. All the best!");
            int attempts = 0;
            boolean guessedCorrectly = false;

            while (attempts < limit) {
                System.out.print("Enter your guess: ");
                int userGuess = inputScanner.nextInt();
                attempts++;
                int remAttempt = limit - attempts;

                if (userGuess == secretNumber) {
                    System.out.println("Congratulations on guessing the number in " + attempts + " attempts.");
                    totalScore++;
                    guessedCorrectly = true;
                    break;
                } else if (attempts < limit) {
                    if (userGuess < secretNumber) {
                        System.out.println("Low! Try again. Remember to guess above " + userGuess + ". " + remAttempt
                                + " attempts left.");
                    } else {
                        System.out.println("High! Try again. Remember to guess below " + userGuess + ". " + remAttempt
                                + " attempts left.");
                    }
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've run out of attempts. The correct number was: " + secretNumber);
            }

            System.out.print("Want to play again? (yes/no): ");
            String playAgainInput = inputScanner.next().toLowerCase();
            if (!playAgainInput.equals("yes")) {
                play = false;
            }
        }

        System.out.println("Game Over. Your total score is: " + totalScore);
        inputScanner.close();
    }
}
