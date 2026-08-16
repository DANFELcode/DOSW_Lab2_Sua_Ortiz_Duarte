package edu.eci.dosw.challenge1;

import java.util.*;

/**
 * This is Don Pepe's store system allowing him to have an organized store.
 *
 * @author Daniel Felipe Sua Siempira
 * @author Juan Pablo Duarte Silva
 * @author David Felipe Ortiz Salcedo
 */

public class Challenge1PepeStore {
    public static void run() {
        System.out.println("Welcome to Pepe's Store :D\n" +
                "Which type of client are you?\n" +
                "1) New Client\n" +
                "2) Frequent Client");

        Scanner clientProducts = new Scanner(System.in);
        System.out.println("Select:");
        int typeClient = clientProducts.nextInt();

        DiscountInterface discount = switch(typeClient) {
            case 1 -> new NewCustomerDiscount();
            case 2 -> new FrequentCustomerDiscount();
            default -> throw new IllegalArgumentException("Invalid type :(");
        };

        System.out.println("Select your products:\n" +
                "1) T-shirt\n" +
                "Cost: 20000\n" +
                "2) Pants\n" +
                "Cost: 50000\n" +
                "3) Cookies\n" +
                "Cost: 500\n" +
                "4) Natural Juice\n" +
                "Cost: 3000\n" +
                "5) Stop selecting"
        );

        List<Product> selectedProducts = new ArrayList<>();

        int nextProductOption = clientProducts.nextInt();

        while(nextProductOption < 5) {
            Product productsInList = switch(nextProductOption) {
                case 1 -> new Product("T-shirt", 20000);
                case 2 -> new Product("Pants", 50000);
                case 3 -> new Product("Cookies", 500);
                case 4 -> new Product("Natural Juice", 3000);
                default -> throw new IllegalArgumentException("Wrong option");
            };

            selectedProducts.add(productsInList);
            nextProductOption = clientProducts.nextInt();
        }

        clientProducts.close();

        ReceiptOperations receiptOp = new ReceiptOperations(discount);
        int totalPrice = receiptOp.calculateTotalPrice(selectedProducts);

        int applyDiscount = receiptOp.calculateClientDiscount(selectedProducts);
        int finalPayingAmount = receiptOp.calculateFinalAmount(totalPrice, applyDiscount);

        Receipt clientReceipt = new Receipt(selectedProducts, totalPrice, finalPayingAmount);

        System.out.println("Your receipt!!");
        selectedProducts.stream().forEach(product ->
                System.out.println(product.getProductName() + ": " + product.getPrice()));
        System.out.println("\nTotal price: " + clientReceipt.getTotalPrice()
        + "\n" + "Discount: " + applyDiscount +
                "\n" + "Total: " + clientReceipt.getFinalPayingAmount());
    }
}