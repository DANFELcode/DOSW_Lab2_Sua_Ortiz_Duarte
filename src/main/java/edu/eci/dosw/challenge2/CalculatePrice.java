package edu.eci.dosw.challenge2;

import java.util.*;

/**
 * Calculates the total price of the hamburger with all ingredients used.
 *
 * @author Daniel Felipe Sua Siempira
 * @author Juan Pablo Duarte Silva
 * @author David Felipe Ortiz Salcedo
 */

public class CalculatePrice {
    public static int calculateTotalPrice(List<Ingredient> ingredients) {
        return ingredients.stream().mapToInt(Ingredient::getPricePerIngredient).filter(price -> price >= 0).sum();
    }
}
