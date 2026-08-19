package edu.eci.dosw.challenge3;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public final class Challenge3TheKingdomOfVehicles {

    public static void run() {
        System.out.println("Running Challenge 3 - The Kingdom of Vehicles");

        List<Vehicle> vehicles = new ArrayList<>();
        boolean decision = true;
        Scanner scanner = new Scanner(System.in);

        Category economy = new Category("Economy", 1.0, 1.0, "no extra equipment");
        Category luxury = new Category("Luxury", 1.5, 1.2, "premium package");
        Category used = new Category("Used", 0.6, 0.9, "no extra equipment");

        while (decision){
            System.out.println("Welcome to the The Kingdom of Vehicles, select a vehicle family\n" +
                    "press 1 for Land (car, bicycle, motorcycle)\n" +
                    "press 2 for Water (boat, sailboat, jetski)\n" +
                    "press 3 for Air(airplane, lightaircraft, helicopter)\n" +
                    "Press 0 to exit");
            int familyOption = scanner.nextInt();

            String modelOption;
            VehicleFactory factory;

            if (familyOption == 0){
                decision = false;
                break;
            }

            if (familyOption == 1){
                System.out.println("Land family selected, select a model:\n" +
                        "car, bicycle or motorcycle");
                modelOption = scanner.next();
                factory = new LandVehicleFactory();

            } else if (familyOption == 2){
                System.out.println("Water family selected, select a model:\n" +
                        "boat, sailboat or jetski");
                modelOption = scanner.next();
                factory = new WaterVehicleFactory();

            } else if (familyOption == 3){
                System.out.println("Air family selected, select a model:\n" +
                        "airplane, lightaircraft or helicopter");
                modelOption = scanner.next();
                factory = new AirVehicleFactory();

            } else {
                System.out.println("Invalid family");
                continue;
            }

            System.out.println("Select a category: \n" +
                    "press 1 for Economy\n" +
                    "press 2 for Luxury\n" +
                    "press 3 for Used");
            System.out.print("Select category: ");
            int categoryOption = scanner.nextInt();

            Category category;
            if (categoryOption == 1) {
                category = economy;
            } else if (categoryOption == 2) {
                category = luxury;
            } else if (categoryOption == 3) {
                category = used;
            } else {
                System.out.println("Invalid category");
                continue;
            }

            try {
                Vehicle vehicle = factory.createVehicle(modelOption, category);
                vehicles.add(vehicle);
                System.out.println("Vehicle added: " + vehicle.getType() + " (" + vehicle.getCategory().getName() + ")");
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid model for that family");
            }
        }
        double subtotal = vehicles.stream()
                .mapToDouble(Vehicle::getFinalPrice)
                .sum();

        double discount = vehicles.size() >= 2 ? subtotal * 0.20 : 0.0;
        double total = subtotal - discount;

        vehicles.forEach(v -> System.out.println(
                v.getType() + " - " + v.getCategory().getName() +
                        " - Speed: " + v.getFinalSpeed() +
                        " - Price: " + v.getFinalPrice() +
                        " - Equipment: " + v.getSpecialEquipment()));

        System.out.println("Subtotal: " + subtotal);
        System.out.println("Discount: " + discount);
        System.out.println("Total: " + total);
    }
}