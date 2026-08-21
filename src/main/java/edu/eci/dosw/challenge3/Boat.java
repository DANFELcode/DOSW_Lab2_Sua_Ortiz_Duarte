package edu.eci.dosw.challenge3;

public class Boat extends Vehicle {
    public Boat(Category category) {
        super("Boat", 25000, 60, category);
    }

    @Override
    public String getSpecialEquipment() {
        if (category.getName().equalsIgnoreCase("Economy")) {
            return "basic lights";
        } else if (category.getName().equalsIgnoreCase("Used")) {
            return "no extra equipment";
        } else if (category.getName().equalsIgnoreCase("Luxury")) {
            return "GPS + small cabin";
        }
        return "";
    }
}