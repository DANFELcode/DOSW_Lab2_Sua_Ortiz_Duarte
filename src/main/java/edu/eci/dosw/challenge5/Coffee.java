package edu.eci.dosw.challenge5;

public interface Coffee {
    String getDescription();
    double getPrice();

    class MilkTopping extends ToppingDecorator {
        public MilkTopping(Coffee coffee) {
            super(coffee);
        }

        @Override
        public String getDescription() {
            return coffee.getDescription() + " + Milk";
        }

        @Override
        public double getPrice() {
            return coffee.getPrice() + 1000;
        }
    }
}