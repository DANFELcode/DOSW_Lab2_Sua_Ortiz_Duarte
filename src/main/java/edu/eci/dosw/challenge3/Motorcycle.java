package edu.eci.dosw.challenge3;

public class Motorcycle extends Vehicle {
    public Motorcycle(Category category) {
        super("Motorcycle", 8000, 180, category);
    }

    @Override
    public String getSpecialEquipment() {
        if (category.getName().equalsIgnoreCase("Economy")) {
            return "basic helmet holder";
        } else if (category.getName().equalsIgnoreCase("Used")) {
            return "no extra equipment";
        } else if (category.getName().equalsIgnoreCase("Luxury")) {
            return "extra safety brakes + storage bags";
        }
        return "";
    }
}