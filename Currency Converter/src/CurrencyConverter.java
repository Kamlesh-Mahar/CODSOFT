import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CurrencyConverter {
    private static Map<String, Double> exchangeRates = new HashMap<>();

    static {
        // Predefined exchange rates (for demonstration purposes)
        exchangeRates.put("USD", 1.0);
        exchangeRates.put("EUR", 0.85);
        exchangeRates.put("GBP", 0.73);
        exchangeRates.put("JPY", 110.25);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Currency Converter!");
        System.out.println("Supported currencies: USD, EUR, GBP, JPY");

        System.out.print("Enter the base currency code: ");
        String baseCurrency = scanner.nextLine().toUpperCase();

        System.out.print("Enter the target currency code: ");
        String targetCurrency = scanner.nextLine().toUpperCase();

        // Validate input currencies
        if (!exchangeRates.containsKey(baseCurrency) || !exchangeRates.containsKey(targetCurrency)) {
            System.out.println("Invalid currency codes. Exiting.");
            return;
        }

        System.out.print("Enter the amount to convert: ");
        double amountToConvert = scanner.nextDouble();

        // Perform currency conversion
        double convertedAmount = convertCurrency(amountToConvert, baseCurrency, targetCurrency);

        // Display result
        System.out.printf("%.2f %s is equal to %.2f %s%n", amountToConvert, baseCurrency, convertedAmount, targetCurrency);

        scanner.close();
    }

    private static double convertCurrency(double amount, String baseCurrency, String targetCurrency) {
        double baseRate = exchangeRates.get(baseCurrency);
        double targetRate = exchangeRates.get(targetCurrency);

        // Conversion formula: convertedAmount = amount * (targetRate / baseRate)
        return amount * (targetRate / baseRate);
    }
}
