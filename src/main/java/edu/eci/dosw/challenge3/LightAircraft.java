package edu.eci.dosw.challenge3;

public class LightAircraft extends Vehicle {
    public LightAircraft(Category category) {
        super("LightAircraft", 300000, 300, category);
    }

    @Override
    public String getSpecialEquipment() {
        if (category.getName().equalsIgnoreCase("Economy")) {
            return "basic controls";
        } else if (category.getName().equalsIgnoreCase("Used")) {
            return "no extra equipment";
        } else if (category.getName().equalsIgnoreCase("Luxury")) {
            return "autopilot + premium seats";
        }
        return "";
    }
}