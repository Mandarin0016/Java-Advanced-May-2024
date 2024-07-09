package _01_Vehicles;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] carDetails = scanner.nextLine().split("\\s+");
        String[] truckDetails = scanner.nextLine().split("\\s+");

        //Car 30.4 0.4
        double carFuelQuantity = Double.parseDouble(carDetails[1]);
        double carFuelCostPerKm = Double.parseDouble(carDetails[2]);

        //Truck 99.34 0.9
        double truckFuelQuantity = Double.parseDouble(truckDetails[1]);
        double truckFuelCostPerKm = Double.parseDouble(truckDetails[2]);

        Car car = new Car(carFuelQuantity, carFuelCostPerKm);
        Truck truck = new Truck(truckFuelQuantity, truckFuelCostPerKm);

        //5
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {

            //Drive Car 500
            //Refuel Truck 10.300
            String[] commandParts = scanner.nextLine().split("\\s+");
            String commandName = commandParts[0];
            String vehicleType = commandParts[1];
            double number = Double.parseDouble(commandParts[2]);

            switch (commandName) {
                case "Drive":
                    if (vehicleType.equals("Car")) {
                        System.out.println(car.drive(number));
                    } else {
                        System.out.println(truck.drive(number));
                    }
                    break;
                case "Refuel":
                    if (vehicleType.equals("Car")) {
                        car.refuel(number);
                    } else {
                        truck.refuel(number);
                    }
                    break;
            }
        }

        System.out.println(car);
        System.out.println(truck);
    }
}
