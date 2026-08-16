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
        System.out.println("Welcome to the kitchen! Select your basic ingredients:\n");
        System.out.println("1) Bread\n" + "2) Meat\n" + "3) Cheese\n"
        + "4) Vegetables\n" + "5) Sauces\n" + "6) No basic ingredient\n" +
                "7) Select optional ingredient\n");

        Scanner selectIngredient = new Scanner(System.in);
        System.out.println("Select:");
        int nextBasicIngredients = selectIngredient.nextInt();

        List<Ingredient> ingredientsList = new ArrayList<>();

        while(nextBasicIngredients < 7) {
            Ingredient selectedIngredient = switch (nextBasicIngredients) {
                case 1 -> new Ingredient("Bread", 1500);
                case 2 -> new Ingredient("Meat", 1500);
                case 3 -> new Ingredient("Cheese", 500);
                case 4 -> new Ingredient("Vegetables", 250);
                case 5 -> new Ingredient("Sauces", 700);
                case 6 -> new Ingredient(null, 0);
                default -> throw new IllegalArgumentException("Invalid ingredient");
            };
            ingredientsList.add(selectedIngredient);
            nextBasicIngredients = selectIngredient.nextInt();
        }

        System.out.println("Write your optional ingredient:\n" + "Select:\n");
        String optionalIngredients = selectIngredient.nextLine();
        ingredientsList.add(optionalIngredients);
        selectIngredient.close();
    }
}