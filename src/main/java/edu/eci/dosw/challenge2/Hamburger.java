package edu.eci.dosw.challenge2;

/**
 * The object Hamburger which has all the basic ingredients and the price of each one.
 *
 * @author Daniel Felipe Sua Siempira
 * @author Juan Pablo Duarte Silva
 * @author David Felipe Ortiz Salcedo
 */

public class Hamburger {
    private final String bread;
    private final String meat;
    private final String cheese;
    private final String vegetables;
    private final String sauces;
    private final int price;

    public Hamburger(String bread, String meat, String cheese, String vegetables, String sauces, int price) {
        this.bread = bread;
        this.meat = meat;
        this.cheese = cheese;
        this.vegetables = vegetables;
        this.sauces = sauces;
        this.price = price;
    }

    public String getBread() {
        return bread;
    }

    public String getMeat() {
        return meat;
    }

    public String getCheese() {
        return cheese;
    }

    public String getVegetables() {
        return vegetables;
    }

    public String getSauces() {
        return sauces;
    }

    public int getPrice() {
        return price;
    }
}
