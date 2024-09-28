import java.util.Scanner;

public class CurrencyConverter {
    private static final double Default = 1.0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Currency Converter!");
        System.out.println("Please select base currency (e.g., USD, EUR, GBP, INR): ");
        String baseCurrency = scanner.nextLine().toUpperCase();
        System.out.println("Please select target currency (e.g., USD, EUR, GBP, INR): ");
        String targetCurrency = scanner.nextLine().toUpperCase();

        System.out.println("Enter the amount to convert from " + baseCurrency + " to " + targetCurrency + ": ");
        double amount = scanner.nextDouble();

        double exchangeRate = fetchExchangeRate(baseCurrency, targetCurrency);
        double convertedAmount = amount * exchangeRate;

        System.out.println("Converting " + amount + " " + baseCurrency + " to " + targetCurrency + "...");
        System.out.println("Result: " + convertedAmount + " " + targetCurrency);
    }

    private static double fetchExchangeRate(String baseCurrency, String targetCurrency) {
        // USD conversions
        if (baseCurrency.equals("USD") && targetCurrency.equals("EUR")) {
            return 0.85;
        } else if (baseCurrency.equals("USD") && targetCurrency.equals("GBP")) {
            return 0.72;
        } else if (baseCurrency.equals("USD") && targetCurrency.equals("INR")) {
            return 74.50;
        }
        // EUR conversions
        else if (baseCurrency.equals("EUR") && targetCurrency.equals("USD")) {
            return 1.18;
        } else if (baseCurrency.equals("EUR") && targetCurrency.equals("GBP")) {
            return 0.85;
        } else if (baseCurrency.equals("EUR") && targetCurrency.equals("INR")) {
            return 88.00;
        }
        // GBP conversions
        else if (baseCurrency.equals("GBP") && targetCurrency.equals("USD")) {
            return 1.39;
        } else if (baseCurrency.equals("GBP") && targetCurrency.equals("EUR")) {
            return 1.17;
        } else if (baseCurrency.equals("GBP") && targetCurrency.equals("INR")) {
            return 102.50;
        }
        // INR conversions
        else if (baseCurrency.equals("INR") && targetCurrency.equals("USD")) {
            return 0.013;
        } else if (baseCurrency.equals("INR") && targetCurrency.equals("EUR")) {
            return 0.011;
        } else if (baseCurrency.equals("INR") && targetCurrency.equals("GBP")) {
            return 0.0097;
        }
        // Default case
        else {
            System.out.println("Exchange rate unavailable for the selected currencies. Using default rate.");
            return Default;
        }
    }
}
