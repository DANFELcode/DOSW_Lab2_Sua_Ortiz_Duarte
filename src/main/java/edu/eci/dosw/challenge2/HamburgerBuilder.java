package edu.eci.dosw.challenge2;

import java.util.ArrayList;
import java.util.List;

/**
 * Builds a hamburger step by step (uses the design pattern Builder).
 *
 * @author Daniel Felipe Sua Siempira
 * @author Juan Pablo Duarte Silva
 * @author David Felipe Ortiz Salcedo
 */

public class HamburgerBuilder {
    private String bread;
    private String meat;
    private String cheese;
    private String vegetables;
    private String sauces;

    private List<Ingredient> selectedIngredients = new ArrayList<>();

    public HamburgerBuilder withBread(Ingredient ingredient) {
        this.bread = ingredient.getIngredientSelected();
        selectedIngredients.add(ingredient);
        return this;
    }

    public HamburgerBuilder withMeat(Ingredient ingredient) {
        this.meat = ingredient.getIngredientSelected();
        selectedIngredients.add(ingredient);
        return this;
    }

    public HamburgerBuilder withCheese(Ingredient ingredient) {
        this.cheese = ingredient.getIngredientSelected();
        selectedIngredients.add(ingredient);
        return this;
    }

    public HamburgerBuilder withVegetables(Ingredient ingredient) {
        this.vegetables = ingredient.getIngredientSelected();
        selectedIngredients.add(ingredient);
        return this;
    }

    public HamburgerBuilder withSauces(Ingredient ingredient) {
        this.sauces = ingredient.getIngredientSelected();
        selectedIngredients.add(ingredient);
        return this;
    }

    public Hamburger build() {
        int total = CalculatePrice.calculateTotalPrice(selectedIngredients);
        return new Hamburger(bread, meat, cheese, vegetables, sauces, total);
    }
}
