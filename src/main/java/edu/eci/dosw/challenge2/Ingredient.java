package edu.eci.dosw.challenge2;

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
