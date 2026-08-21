package edu.eci.dosw.challenge5;

public class CaramelTopping extends ToppingDecorator {
    public CaramelTopping(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + " + Caramel";
    }
    @Override
    public double getPrice() {
        return coffee.getPrice() + 1200;
    }
}