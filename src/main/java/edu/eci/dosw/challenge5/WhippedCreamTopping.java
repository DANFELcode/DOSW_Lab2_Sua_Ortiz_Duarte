package edu.eci.dosw.challenge5;

public class WhippedCreamTopping extends ToppingDecorator {
    public WhippedCreamTopping(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + " + Whipped Cream";
    }
    @Override
    public double getPrice() {
        return coffee.getPrice() + 2000;
    }
}