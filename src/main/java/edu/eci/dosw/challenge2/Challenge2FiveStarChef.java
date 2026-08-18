package edu.eci.dosw.challenge2;

import java.util.*;

/**
 * Here's where you can order your hamburger.
 *
 * @author Daniel Felipe Sua Siempira
 * @author Juan Pablo Duarte Silva
 * @author David Felipe Ortiz Salcedo
 */

public final class Challenge2FiveStarChef {
    public static void run() {
        System.out.println("Running Challenge 2 - The Five Star Chef...");
        System.out.println("Welcome to the kitchen! Select your basic ingredients:");
        System.out.println("1) Bread\n" + "2) Meat\n" + "3) Cheese\n"
        + "4) Vegetables\n" + "5) Sauces\n" + "6) Select optional ingredient");

        Scanner selectIngredient = new Scanner(System.in);
        HamburgerBuilder hamburgerBuilder = new HamburgerBuilder();

        System.out.println("Select:");
        int nextBasicIngredients = selectIngredient.nextInt();

        List<Ingredient> ingredientsList = new ArrayList<>();

        while(nextBasicIngredients != 6) {
            Ingredient selectedIngredient = switch (nextBasicIngredients) {
                case 1 -> new Ingredient("Bread", 1500);
                case 2 -> new Ingredient("Meat", 2000);
                case 3 -> new Ingredient("Cheese", 1000);
                case 4 -> new Ingredient("Vegetables", 500);
                case 5 -> new Ingredient("Sauces", 700);
                default -> throw new IllegalArgumentException("Invalid ingredient");
            };

            switch(nextBasicIngredients) {
                case 1 -> hamburgerBuilder.withBread(selectedIngredient);
                case 2 -> hamburgerBuilder.withMeat(selectedIngredient);
                case 3 -> hamburgerBuilder.withCheese(selectedIngredient);
                case 4 -> hamburgerBuilder.withVegetables(selectedIngredient);
                case 5 -> hamburgerBuilder.withSauces(selectedIngredient);
                default -> throw new IllegalArgumentException("This ingredient doesn't exists");
            }

            ingredientsList.add(selectedIngredient);
            System.out.println("Select:");
            nextBasicIngredients = selectIngredient.nextInt();
        }

        selectIngredient.nextLine();
        HamburgerComponent basicHamburger = new HamburgerBaseComponent(hamburgerBuilder.build());

        System.out.println("How many optionals ingredients do you want?:");
        int amountNewIngredients = selectIngredient.nextInt();
        selectIngredient.nextLine();

        for(int i = 0; i < amountNewIngredients; i++) {
            System.out.println("Write your optional ingredient:");
            String optionalIngredient = selectIngredient.nextLine().replace("\"", "");
            int extraPrice = 650;
            basicHamburger = new HamburgerConcreteDecorator(basicHamburger, optionalIngredient, extraPrice);
        }
        selectIngredient.close();

        System.out.println("Your hamburger is: " + basicHamburger.getIngredient());
        System.out.println("The total price is: " + basicHamburger.getPrice());
    }
}