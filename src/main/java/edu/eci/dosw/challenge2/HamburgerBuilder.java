package edu.eci.dosw.challenge2;

public class HamburgerBuilder {
    private String ingredientSelected;
    private String ingredientSelected;

    public HamburgerBuilder withBread(String bread) {
        String bread = bread;
        return this;
    }

    public HamburgerBuilder withMeat(String meat) {
        String meat = meat;
        return this;
    }

    public HamburgerBuilder withCheese(String cheese) {
        String cheese = cheese;
        return this;
    }

    public HamburgerBuilder withVegetables(String vegetables) {
        String vegetables = vegetables;
        return this;
    }

    public HamburgerBuilder withSauces(String sauces) {
        String sauces = sauces;
        return this;
    }

    public HamburgerBuilder withOptionalIngredient(String optionalIngredient) {
        String optionalIngredient = optionalIngredient;
        return this;
    }

    public Ingredient build() {
        return new Ingredient();
    }
}
