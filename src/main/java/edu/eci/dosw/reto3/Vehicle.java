package edu.eci.dosw.reto3;

public class Vehicle {
    String vehicleFamily;
    String category;
    String model;


    public Vehicle(String vehicleFamily, String category, String model){
        this.vehicleFamily = vehicleFamily;
        this.category = category;
        this.model = model;

    }

    public String representation(){
        return "Family: " + this.vehicleFamily * ""
    }
}
