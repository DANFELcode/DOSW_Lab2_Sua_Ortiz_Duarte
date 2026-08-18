package edu.eci.dosw.challenge3;

public class Helicopter extends Vehicle {
    public Helicopter(Category category) {
        super("Helicopter", 1500000, 280, category);
    }

    @Override
    public String getSpecialEquipment() {
        if (category.getName().equalsIgnoreCase("Economy")) {
            return "basic radio";
        } else if (category.getName().equalsIgnoreCase("Used")) {
            return "no extra equipment";
        } else if (category.getName().equalsIgnoreCase("Luxury")) {
            return "noise cancelling headsets + leather seats";
        }
        return "";
    }
}