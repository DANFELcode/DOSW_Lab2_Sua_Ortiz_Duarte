package edu.eci.dosw.challenge3;

public class Car extends Vehicle{
    public Car(Category category) {
        super("Car", 35000, 150, category);
    }

    @Override
    public String getSpecialEquipment() {
        String specialEquipment = "";
        if (category.getName().equalsIgnoreCase("Economy")){
            specialEquipment = "radio fm";
        } else if(category.getName().equalsIgnoreCase("Used")){
            specialEquipment = "no extra equipment";
        } else if(category.getName().equalsIgnoreCase("Luxury")){
            specialEquipment ="radio fm + table ipod";
        }
        return specialEquipment;
    }
}
