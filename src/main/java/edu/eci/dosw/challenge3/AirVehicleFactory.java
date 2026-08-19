package edu.eci.dosw.challenge3;

public class AirVehicleFactory implements VehicleFactory {
    @Override
    public Vehicle createVehicle(String model, Category category) {
        switch(model) {
            case "airplane":
                return new Airplane(category);
            case "lightaircraft":
                return new LightAircraft(category);
            case "helicopter":
                return new Helicopter(category);
            default:
                throw new IllegalArgumentException("Unknown vehicle model: " + model);
        }
    }
}