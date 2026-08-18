package edu.eci.dosw.challenge3;

public abstract class Vehicle{
    protected String type;
    protected double basePrice;
    protected double baseSpeed;
    protected Category category;


    public Vehicle(String type, double basePrice, double baseSpeed, Category category){
        this.type = type;
        this.basePrice = basePrice;
        this.baseSpeed = baseSpeed;
        this.category = category;
    }

    public abstract String getSpecialEquipment();

    public double getFinalPrice(){
        return (basePrice * category.getPriceMultiplier());
    }

    public double getFinalSpeed(){
        return (baseSpeed * category.getSpeedMultiplier());
    }

    public String getType() {
        return type;
    }

    public Category getCategory() {
        return category;
    }
}
