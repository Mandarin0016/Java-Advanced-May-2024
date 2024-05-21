import java.util.*;
import java.util.stream.Collectors;

public class _08_UserLogs {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Integer>> tracking = new TreeMap<>();

        String input = scanner.nextLine();
        while (!input.equals("end")) {

            //IP=192.23.30.41 message='Hello&yall.' user=destroyer
            String IP = input.split(" ")[0].split("=")[1]; // 192.23.30.41
            String username = input.split(" ")[2].split("=")[1]; // destroyer

            // Проверявам имам ли запис за този потребите
            if (tracking.containsKey(username)) {
                // а. Ако има:
                //    -> вземам мапа за този потребител (IP и брой пъти изпратено съобщение за този IP адрес)
                Map<String, Integer> IPAndCount = tracking.get(username);
                if (IPAndCount.containsKey(IP)) {
                    //    -> Ако потребителя е пращал съобщение от този IP адрес, увеличавам бройката с 1
                    int count = IPAndCount.get(IP) + 1;
                    IPAndCount.put(IP, count);
                } else {
                    //    -> Ако не е –> нов запис, че е пратил 1 съобщение от този IP адрес
                    IPAndCount.put(IP, 1);
                }
            } else {
                // б. Ако няма:
                //    -> правя нов запис с празен мап за неговите IP адреси
                tracking.put(username, new LinkedHashMap<>());
                //    -> добавям към празният мап на този потребите, че е изпратил съобщение 1 от този IP адрес (IP -> 1)
                tracking.get(username).put(IP, 1);
            }
            input = scanner.nextLine();
        }

        for (Map.Entry<String, Map<String, Integer>> entry : tracking.entrySet()) {

            String username = entry.getKey();
            Map<String, Integer> IPAndCounts = entry.getValue();

            //{IP} => {count}
            // .map -> променя от нещо към нещо
            String output = IPAndCounts.entrySet().stream()  // съвкупност от записи
                    .map(IPentry -> String.format("%s => %d", IPentry.getKey(), IPentry.getValue())) // съвкупност от текстове
                    .collect(Collectors.joining(", "));

            System.out.println(username + ":");
            System.out.println(output + ".");
        }
    }
}
