package edu.eci.dosw.challenge3;

public class Airplane extends Vehicle {
    public Airplane(Category category) {
        super("Airplane", 5000000, 900, category);
    }

    @Override
    public String getSpecialEquipment() {
        if (category.getName().equalsIgnoreCase("Economy")) {
            return "standard controls";
        } else if (category.getName().equalsIgnoreCase("Used")) {
            return "no extra equipment";
        } else if (category.getName().equalsIgnoreCase("Luxury")) {
            return "leather seats + entertainment screens";
        }
        return "";
    }
}