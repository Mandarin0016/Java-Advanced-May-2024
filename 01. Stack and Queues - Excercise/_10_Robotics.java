import java.util.ArrayDeque;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _10_Robotics {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] inputRobot = scanner.nextLine().split(";");
        LinkedHashMap<String, Integer> robots = getLinkedHashMap(inputRobot);

        String time = scanner.nextLine();
        int hours = Integer.parseInt(time.split(":")[0]);
        int minutes = Integer.parseInt(time.split(":")[1]);
        int seconds = Integer.parseInt(time.split(":")[2]);

        long totalTimeInSeconds = hours * 3600 + minutes * 60 + seconds;

        ArrayDeque<String> products = new ArrayDeque<>();
        int[] workingTime = new int[robots.size()];

        String product = scanner.nextLine();
        while (!product.equals("End")) {
            products.offer(product);
            product = scanner.nextLine();
        }

        while (!products.isEmpty()) {
            String currentProduct = products.poll();
            totalTimeInSeconds++;
            boolean isAssigned = false;

            for (int robot = 0; robot < workingTime.length; robot++) {
                if (workingTime[robot] > 0) {
                    --workingTime[robot];
                }
            }

            for (int i = 0; i < workingTime.length; i++) {
                if (workingTime[i] == 0) {

                    int count = 0;
                    for (Map.Entry<String, Integer> robot : robots.entrySet()) {
                        if (count == i) {
                            workingTime[i] = robot.getValue();

                            long takenHour = totalTimeInSeconds / 3600 % 24;
                            long takenMinute = totalTimeInSeconds % 3600 / 60;
                            long takenSeconds = totalTimeInSeconds % 60;
                            System.out.printf("%s - %s [%02d:%02d:%02d]%n", robot.getKey(), currentProduct, takenHour, takenMinute, takenSeconds);
                            isAssigned = true;
                            break;
                        }
                        count++;
                    }
                    break;
                }
            }

            if (!isAssigned) {
                products.offer(currentProduct);
            }
        }
    }

    private static LinkedHashMap<String, Integer> getLinkedHashMap(String[] inputRobot) {
        LinkedHashMap<String, Integer> robots = new LinkedHashMap<>();
        for (int i = 0; i < inputRobot.length; i++) {
            String name = inputRobot[i].split("-")[0];
            int time = Integer.parseInt(inputRobot[i].split("-")[1]);
            robots.put(name, time);
        }
        return robots;
    }
}
