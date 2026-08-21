package edu.eci.dosw.challenge5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public final class Challenge5CustomizedCoffee {

    public static void run() {
        System.out.println("Running Challenge 5 - Customized Coffee");

        List<Coffee> coffees = new ArrayList<>();
        boolean decision = true;
        Scanner scanner = new Scanner(System.in);

        while (decision) {
            System.out.println("Press 1 for create a new coffee\n" +
                    "Press 0 to exit");
            int option = scanner.nextInt();

            if (option == 0) {
                break;
            } else if (option != 1) {
                System.out.println("Invalid option");
                continue;
            }

            Coffee coffee = new SimpleCoffee();
            boolean addingToppings = true;

            while (addingToppings) {
                System.out.println("Current coffee: " + coffee.getDescription() + " - $" + coffee.getPrice());
                System.out.println("Add a topping:\n" +
                        "1 Milk\n" +
                        "2 Chocolate\n" +
                        "3 Caramel\n" +
                        "4 Whipped Cream\n" +
                        "5 Mint\n" +
                        "6 Custom Topping\n" +
                        "0 Finish this coffee");
                int toppingOption = scanner.nextInt();

                if (toppingOption == 1) {
                    coffee = new MilkTopping(coffee);
                } else if (toppingOption == 2) {
                    coffee = new ChocolateTopping(coffee);
                } else if (toppingOption == 3) {
                    coffee = new CaramelTopping(coffee);
                } else if (toppingOption == 4) {
                    coffee = new WhippedCreamTopping(coffee);
                } else if (toppingOption == 5) {
                    coffee = new MintTopping(coffee);
                } else if (toppingOption == 6) {
                    scanner.nextLine(); // limpia el salto de línea pendiente del nextInt() anterior
                    System.out.print("Topping name: ");
                    String name = scanner.nextLine();
                    System.out.print("Topping price: ");
                    double price = scanner.nextDouble();
                    coffee = new CustomTopping(coffee, name, price);
                }else if (toppingOption == 0) {
                    addingToppings = false;
                } else {
                    System.out.println("Invalid topping option");
                }
            }

            coffees.add(coffee);
            System.out.println("Coffee added: " + coffee.getDescription() + " - $" + coffee.getPrice());
        }

        coffees.forEach(c -> System.out.println(c.getDescription() + " - $" + c.getPrice()));

        double total = coffees.stream()
                .mapToDouble(Coffee::getPrice)
                .sum();

        System.out.println("Total for all coffees: $" + total);
    }
}