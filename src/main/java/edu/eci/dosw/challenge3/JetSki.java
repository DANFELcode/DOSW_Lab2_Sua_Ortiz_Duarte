package edu.eci.dosw.challenge3;

public class JetSki extends Vehicle {
    public JetSki(Category category) {
        super("JetSki", 12000, 100, category);
    }

    @Override
    public String getSpecialEquipment() {
        if (category.getName().equalsIgnoreCase("Economy")) {
            return "life vest";
        } else if (category.getName().equalsIgnoreCase("Used")) {
            return "no extra equipment";
        } else if (category.getName().equalsIgnoreCase("Luxury")) {
            return "speaker system + storage space";
        }
        return "";
    }
}