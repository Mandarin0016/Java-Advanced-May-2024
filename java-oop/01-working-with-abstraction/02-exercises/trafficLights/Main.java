package trafficLights;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //GREEN RED YELLOW
        Light[] lights = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(light -> Light.valueOf(light))
                .toArray(Light[]::new);

        int numberOfUpdates = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfUpdates; i++) {
            // Update the lights
            updateLights(lights);
            // Print the light
            printLights(lights);
        }
    }

    private static void printLights(Light[] lights) {

        for (Light light : lights) {
            System.out.print(light + " ");
        }
        System.out.println();
    }

    private static void updateLights(Light[] lights) {

        //red -> green -> yellow -> red
        // Light light -> променливата е копие на реална стойност в тази структура от данни
        // ако се опитаме да променим това копие, то НЯМА да се промени самата стойност в структурата от данни
//        for (Light light : lights) {
//            switch (light){
//                case RED -> light = Light.GREEN;
//                case GREEN -> light = Light.YELLOW;
//                case YELLOW -> light = Light.RED;
//            }
//            System.out.println();
//        }

        for (int index = 0; index < lights.length; index++) {
            switch (lights[index]) {
                case RED -> lights[index] = Light.GREEN;
                case GREEN -> lights[index] = Light.YELLOW;
                case YELLOW -> lights[index] = Light.RED;
            }
        }
    }
}
