import java.util.Scanner;

public class Grade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Student Grade Calculator!!");
        System.out.println("Please enter marks obtained in each subject (out of 100).");

        int total = 0;
        int numSubjects;
        do {
            System.out.print("Enter the number of subjects: ");
            numSubjects = scanner.nextInt();
            if (numSubjects <= 0) {
                System.out.println("Number of subjects must be greater than zero. Please try again.");
            }
        } while (numSubjects <= 0);

        for (int i = 1; i <= numSubjects; i++) {
            System.out.print("Enter marks for subject " + i + ": ");
            int marks = scanner.nextInt();
            total += marks;
        }

        double avg = (double) total / numSubjects;

        String grade;
        if (avg >= 90) {
            grade = "A";
        } else if (avg >= 80) {
            grade = "B";
        } else if (avg >= 70) {
            grade = "C";
        } else if (avg >= 60) {
            grade = "D";
        } else if (avg >= 50) {
            grade = "E";
        } else {
            grade = "F";
        }

        System.out.println("\nCalculating...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\nResults:");
        System.out.println("Total Marks Obtained: " + total + " out of " + (numSubjects * 100));
        System.out.printf("Average Percentage: %.2f%%\n", avg);
        System.out.println("Your Grade: " + grade);

        scanner.close();
    }
}
