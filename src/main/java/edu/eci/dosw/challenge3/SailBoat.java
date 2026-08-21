package edu.eci.dosw.challenge3;

public class SailBoat extends Vehicle {
    public SailBoat(Category category) {
        super("SailBoat", 40000, 35, category);
    }

    @Override
    public String getSpecialEquipment() {
        if (category.getName().equalsIgnoreCase("Economy")) {
            return "standard sail";
        } else if (category.getName().equalsIgnoreCase("Used")) {
            return "no extra equipment";
        } else if (category.getName().equalsIgnoreCase("Luxury")) {
            return "premium sail + autopilot";
        }
        return "";
    }
}