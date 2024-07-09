package _02_Vehicles;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] carDetails = scanner.nextLine().split("\\s+");
        String[] truckDetails = scanner.nextLine().split("\\s+");
        String[] busDetails = scanner.nextLine().split("\\s+");

        //Car 30.4 0.4 70
        double carFuelQuantity = Double.parseDouble(carDetails[1]);
        double carFuelCostPerKm = Double.parseDouble(carDetails[2]);
        double carTankCapacity = Double.parseDouble(carDetails[3]);

        //Truck 99.34 0.9 300
        double truckFuelQuantity = Double.parseDouble(truckDetails[1]);
        double truckFuelCostPerKm = Double.parseDouble(truckDetails[2]);
        double truckTankCapacity = Double.parseDouble(truckDetails[3]);

        //Bus 40 0.3 150
        double busFuelQuantity = Double.parseDouble(busDetails[1]);
        double busFuelCostPerKm = Double.parseDouble(busDetails[2]);
        double busTankCapacity = Double.parseDouble(busDetails[3]);

        Car car = new Car(carFuelQuantity, carFuelCostPerKm, carTankCapacity);
        Truck truck = new Truck(truckFuelQuantity, truckFuelCostPerKm, truckTankCapacity);
        Bus bus = new Bus(busFuelQuantity, busFuelCostPerKm, busTankCapacity);

        //5
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {

            //Drive Car 500
            //Refuel Truck 10.300
            //DriveEmpty Bus 100
            String[] commandParts = scanner.nextLine().split("\\s+");
            String commandName = commandParts[0];
            String vehicleType = commandParts[1];
            double number = Double.parseDouble(commandParts[2]);

            switch (commandName) {
                case "Drive":
                    if (vehicleType.equals("Car")) {
                        System.out.println(car.drive(number));
                    } else if (vehicleType.equals("Bus")) {
                        System.out.println(bus.drive(number));
                    } else {
                        System.out.println(truck.drive(number));
                    }
                    break;
                case "DriveEmpty":
                    System.out.println(bus.driveEmpty(number));
                    break;
                case "Refuel":
                    if (vehicleType.equals("Car")) {
                        car.refuel(number);
                    } else if (vehicleType.equals("Bus")) {
                        bus.refuel(number);
                    } else {
                        truck.refuel(number);
                    }
                    break;
            }
        }

        System.out.println(car);
        System.out.println(truck);
        System.out.println(bus);
    }
}
