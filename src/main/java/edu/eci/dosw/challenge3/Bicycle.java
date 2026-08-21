package edu.eci.dosw.challenge3;

public class Bicycle extends Vehicle {
    public Bicycle(Category category) {
        super("Bicycle", 300, 25, category);
    }

    @Override
    public String getSpecialEquipment() {
        if (category.getName().equalsIgnoreCase("Economy")) {
            return "bell";
        } else if (category.getName().equalsIgnoreCase("Used")) {
            return "no extra equipment";
        } else if (category.getName().equalsIgnoreCase("Luxury")) {
            return "lightweight frame + lights";
        }
        return "";
    }
}