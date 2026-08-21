package edu.eci.dosw.challenge5;

public class SimpleCoffee implements Coffee {
    @Override
    public String getDescription() {
        return "Coffee";
    }

    @Override
    public double getPrice() {
        return 3000;
    }
}