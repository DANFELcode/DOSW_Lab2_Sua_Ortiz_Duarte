package edu.eci.dosw.challenge4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public final class Challenge4CurrencyExchangeScam {

    public static void run() {
        RateSwitcher converter = new RateSwitcher(new FixedExchangeRate());

        System.out.println("Running Challenge 4 - The Currency Exchange Scam");
        System.out.println("Welcome to the currency conversion service \n" +
                "press 1 to star a transaction\n" +
                "press 2 to convert to multiple currencies\n" +
                "press 0 to exit\n");

        boolean decision = true;
        Scanner scanner = new Scanner(System.in);

        List<Transaction> transactions = new ArrayList<>();
        while(decision) {
            System.out.print("Select: ");
            int transactionOption = scanner.nextInt();
            scanner.nextLine();

            if (transactionOption == 0){
                decision = false;

            } else if (transactionOption == 2) {
                System.out.print("Amount?: ");
                double amount = scanner.nextDouble();
                scanner.nextLine();
                System.out.println("Coins supported: \n" +
                        "USD, COP, JPY, EUR");
                System.out.print("Source currency?: ");
                String sourceCurrency = scanner.nextLine();
                System.out.print("Destination currencies?: ");
                String destinationCurrenciesInput = scanner.nextLine();

                List<String> destinations = Arrays.stream(destinationCurrenciesInput.split(","))
                        .map(String::trim)
                        .toList();

                try {
                    List<Transaction> results = converter.convert(amount, sourceCurrency, destinations);
                    results.forEach(result ->
                            System.out.println(result.getOriginalAmount() + " " + result.getSourceCurrency() +
                                    " = " + result.getConvertedAmount() + " " + result.getDestinationCurrency()));
                    transactions.addAll(results);
                } catch (IllegalArgumentException e) {
                    System.out.println("Enter valid coins");
                }
                            } else{
                System.out.println("Invalid option");
            }
        }

        Map<String, Double> totals = transactions.stream().collect(Collectors.groupingBy(Transaction::getDestinationCurrency,
                Collectors.summingDouble(Transaction::getConvertedAmount)));

        totals.forEach((coin, total) -> System.out.println(coin + ":" + total));
    }
}
