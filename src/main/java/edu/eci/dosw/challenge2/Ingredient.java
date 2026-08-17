package edu.eci.dosw.challenge2;

/**
 * The Ingredient class which has the selected ingredient and their individual price.
 *
 * @author Daniel Felipe Sua Siempira
 * @author Juan Pablo Duarte Silva
 * @author David Felipe Ortiz Salcedo
 */

public class Ingredient {
    private final String ingredientSelected;
    private final int pricePerIngredient;

    public Ingredient(String ingredientSelected, int pricePerIngredient) {
        this.ingredientSelected = ingredientSelected;
        this.pricePerIngredient = pricePerIngredient;
    }

    public String getIngredientSelected() {
        return ingredientSelected;
    }

    public int getPricePerIngredient() {
        return pricePerIngredient;
    }
}
