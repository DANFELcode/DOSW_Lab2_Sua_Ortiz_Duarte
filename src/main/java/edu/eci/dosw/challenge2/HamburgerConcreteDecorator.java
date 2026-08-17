package edu.eci.dosw.challenge2;

/**
 * Adds the ingredients from the original hamburger and the new ingredients to a new hamburger.
 *
 * @author Daniel Felipe Sua Siempira
 * @author Juan Pablo Duarte Silva
 * @author David Felipe Ortiz Salcedo
 */

public class HamburgerConcreteDecorator extends HamburgerDecorator {
    private final String extraIngredient;
    private final int extraPrice;

    public HamburgerConcreteDecorator(HamburgerComponent hamComponent,
                                      String extraIngredient, int extraPrice) {
        super(hamComponent);
        this.extraIngredient = extraIngredient;
        this.extraPrice = extraPrice;
    }

    @Override
    public String getIngredient() {
        return hamComponent.getIngredient() + ", " + extraIngredient;
    }

    @Override
    public int getPrice() {
        return hamComponent.getPrice() + extraPrice;
    }
}
