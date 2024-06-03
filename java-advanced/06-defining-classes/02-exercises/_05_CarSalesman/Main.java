package _05_CarSalesman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Engine> engines = new ArrayList<>();
        List<Car> cars = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String engineInfo = scanner.nextLine();
            String[] engineDate = engineInfo.split(" ");
            //V4-33 140 28 B
            String model = engineDate[0];
            String power = engineDate[1];
            String displacement = "n/a";
            String efficiency = "n/a";
            if (engineDate.length == 4) {
                displacement = engineDate[2];
                efficiency = engineDate[3];
            } else if (engineDate.length == 3) {
                //V4-33 140 28
                //V4-33 140 E
                if (Character.isDigit(engineDate[2].charAt(0))) {
                    displacement = engineDate[2];
                } else {
                    efficiency = engineDate[2];
                }
            }
            Engine engine = new Engine(model, power, displacement, efficiency);
            engines.add(engine);
        }

        int m = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < m; i++) {

            //{Model} {Engine} {Weight} {Color}
            String carInfo = scanner.nextLine();
            String[] carData = carInfo.split(" ");
            String carModel = carData[0];
            String engineModel = carData[1];
            String carWeight = "n/a";
            String carColor = "n/a";
            if (carData.length == 4) {
                carWeight = carData[2];
                carColor = carData[3];
            } else if (carData.length == 3) {
                if (Character.isDigit(carData[2].charAt(0))) {
                    //FordFocus V4-33 1300
                    carWeight = carData[2];
                } else {
                    //VolkswagenGolf V4-33 Orange
                    carColor = carData[2];
                }
            }
            Engine engine = getEngineByModel(engines, engineModel);
            Car car = new Car(carModel, engine, carWeight, carColor);
            cars.add(car);
        }

        for (Car car : cars) {
            System.out.println(car);
        }
    }

    private static Engine getEngineByModel(List<Engine> engines, String engineModel) {
        for (Engine engine : engines) {
            if (engine.getModel().equals(engineModel)) {
                return engine;
            }
        }
        return null;
    }
}
