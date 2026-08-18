package edu.eci.dosw.challenge3;

public class Category {
    private final String name;
    private final double priceMultiplier;
    private final double speedMultiplier;
    private final String equipment;


    public Category(String name, double priceMultiplier, double speedMultiplier, String equipment){
        this.name = name;
        this.priceMultiplier = priceMultiplier;
        this.speedMultiplier = speedMultiplier;
        this.equipment = equipment;
    }

    public String getName() {
        return name;
    }

    public double getPriceMultiplier() {
        return priceMultiplier;
    }

    public double getSpeedMultiplier() {
        return speedMultiplier;
    }

    public String getEquipment(){
        return equipment;
    }
}
