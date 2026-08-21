package edu.eci.dosw.challenge5;

public abstract class ToppingDecorator implements Coffee {
    protected final Coffee coffee;
    protected ToppingDecorator(Coffee coffee) {
        this.coffee = coffee;
    }
}