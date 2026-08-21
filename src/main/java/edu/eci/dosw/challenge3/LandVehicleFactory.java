package edu.eci.dosw.challenge3;

public class LandVehicleFactory implements VehicleFactory{
    @Override
    public Vehicle createVehicle(String model, Category category) {
        switch(model) {
            case "car":
                return new Car(category);
            case "bicycle":
                return new Bicycle(category);
            case "motorcycle":
                return new Motorcycle(category);
            default:
                throw new IllegalArgumentException("Unknown vehicle model: " + model);
        }
    }
}
