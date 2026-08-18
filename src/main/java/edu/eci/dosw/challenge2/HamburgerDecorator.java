package edu.eci.dosw.challenge2;

/**
 * Wraps any original hamburger with a new hamburger.
 *
 * @author Daniel Felipe Sua Siempira
 * @author Juan Pablo Duarte Silva
 * @author David Felipe Ortiz Salcedo
 */

public abstract class HamburgerDecorator implements HamburgerComponent {
    protected final HamburgerComponent hamComponent;

    protected HamburgerDecorator(HamburgerComponent hamComponent) {
        this.hamComponent = hamComponent;
    }

    @Override
    public String getIngredient() {
        return hamComponent.getIngredient();
    }

    @Override
    public int getPrice() {
        return hamComponent.getPrice();
    }
}
