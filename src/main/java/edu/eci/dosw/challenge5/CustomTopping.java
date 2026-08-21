package edu.eci.dosw.challenge5;

public class CustomTopping extends ToppingDecorator {
    private final String name;
    private final double extraPrice;

    public CustomTopping(Coffee coffee, String name, double extraPrice) {
        super(coffee);
        this.name = name;
        this.extraPrice = extraPrice;
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + " + " + name;
    }
    @Override
    public double getPrice() {
        return coffee.getPrice() + extraPrice;
    }
}