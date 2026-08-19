package edu.eci.dosw.challenge3;

public class WaterVehicleFactory implements VehicleFactory {
    @Override
    public Vehicle createVehicle(String model, Category category) {
        switch(model) {
            case "boat":
                return new Boat(category);
            case "sailboat":
                return new SailBoat(category);
            case "jetski":
                return new JetSki(category);
            default:
                throw new IllegalArgumentException("Unknown vehicle model: " + model);
        }
    }
}