package edu.eci.dosw.challenge5;

public class MintTopping extends ToppingDecorator {
    public MintTopping(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + " + Mint";
    }

    @Override
    public double getPrice() {
        return coffee.getPrice() + 1300;
    }
}