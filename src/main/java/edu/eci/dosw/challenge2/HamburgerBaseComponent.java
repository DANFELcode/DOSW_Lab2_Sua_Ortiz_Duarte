package edu.eci.dosw.challenge2;

import java.util.*;

/**
 * Lets the Hamburger class involve with the component interface
 * and the decorators (it's like adding a new friend to a group :D).
 *
 * @author Daniel Felipe Sua Siempira
 * @author Juan Pablo Duarte Silva
 * @author David Felipe Ortiz Salcedo
 */

public class HamburgerBaseComponent implements HamburgerComponent {
    private final Hamburger hamburger;

    public HamburgerBaseComponent(Hamburger hamburger) {
        this.hamburger = hamburger;
    }

    @Override
    public String getIngredient() {
        List<String> ingredientsList = Arrays.asList(hamburger.getBread(), hamburger.getMeat(),
                hamburger.getCheese(), hamburger.getVegetables(), hamburger.getSauces());

        List<String> noNull = ingredientsList.stream().filter(ingredient -> ingredient != null).toList();
        return String.join(", ", noNull);
    }

    @Override
    public int getPrice() {
        return hamburger.getPrice();
    }
}
