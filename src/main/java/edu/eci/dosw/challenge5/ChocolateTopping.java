package edu.eci.dosw.challenge5;

public class ChocolateTopping extends ToppingDecorator {
    public ChocolateTopping(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + " + Chocolate";
    }
    @Override
    public double getPrice() {
        return coffee.getPrice() + 1500;
    }
}