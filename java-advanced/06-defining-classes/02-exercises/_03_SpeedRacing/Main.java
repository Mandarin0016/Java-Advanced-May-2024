package _03_SpeedRacing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Car> cars = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            //AudiA4 23 0.3
            String carInfo = scanner.nextLine();
            String[] carData = carInfo.split(" ");
            String model = carData[0];
            double fuel = Double.parseDouble(carData[1]);
            double costPerKm = Double.parseDouble(carData[2]);
            Car car = new Car(model, fuel, costPerKm);
            cars.add(car);
        }

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            //Drive AudiA4 5
            String model = input.split(" ")[1];
            int kmToDrive = Integer.parseInt(input.split(" ")[2]);
            Car car = getCarByModel(cars, model);
            car.drive(kmToDrive);
            input = scanner.nextLine();
        }

        for (Car car : cars) {
            // Автоматиично ще се извика метода .toString()
            System.out.println(car);
        }
    }

    private static Car getCarByModel(List<Car> cars, String model) {

        for (Car car : cars) {
            if (car.getModel().equals(model)) {
                return car;
            }
        }
        return null;
    }
}
