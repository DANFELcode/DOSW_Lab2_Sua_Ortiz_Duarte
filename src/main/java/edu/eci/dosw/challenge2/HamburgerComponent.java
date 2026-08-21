package edu.eci.dosw.challenge2;

/**
 * The interface to make the component and decorator understand each other
 * (this is so Java can see that the object is the same).
 *
 * @author Daniel Felipe Sua Siempira
 * @author Juan Pablo Duarte Silva
 * @author David Felipe Ortiz Salcedo
 */

public interface HamburgerComponent {
    String getIngredient();
    int getPrice();
}
