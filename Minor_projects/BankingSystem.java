import java.util.Scanner;

class Account {
    private String accountNumber;
    private double balance;

    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public void displayBalance() {
        System.out.println("Account Number: " + accountNumber); // Display account number
        System.out.println("Balance: " + balance);
    }

    public String getAccountNumber() {
        return accountNumber; // Getter for accountNumber
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Account account = new Account("123456789", 5000);

        while (true) {
            System.out.println("\n1. Deposit\n2. Withdraw\n3. Balance\n4. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            if (choice == 4) {
                System.out.println("Exiting the banking system.");
                break; // Added exit message for clarity
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = sc.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = sc.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    account.displayBalance();
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
        sc.close(); // Close the scanner to prevent resource leaks
    }
}
