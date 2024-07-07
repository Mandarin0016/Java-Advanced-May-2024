package _06_MilitaryElite;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Soldier> soldiers = new ArrayList<>();
        Map<Integer, Private> privates = new HashMap<>();

        String command = scanner.nextLine();
        while (!command.equals("End")) {

            String[] data = command.split("\\s+");
            String type = data[0];
            int id = Integer.parseInt(data[1]);
            String firstName = data[2];
            String lastName = data[3];

            double salary;

            switch (type) {
                case "Private":
                    salary = Double.parseDouble(data[4]);
                    PrivateImpl privateSoldier = new PrivateImpl(id, firstName, lastName, salary);
                    privates.put(id, privateSoldier);
                    soldiers.add(privateSoldier);
                    break;
                case "LieutenantGeneral":
                    salary = Double.parseDouble(data[4]);
                    LieutenantGeneralImpl general = new LieutenantGeneralImpl(id, firstName, lastName, salary);
                    for (int i = 5; i < data.length; i++) {
                        general.addPrivate(privates.get(Integer.parseInt(data[i])));
                    }
                    soldiers.add(general);
                    break;
                case "Engineer":
                    salary = Double.parseDouble(data[4]);
                    String corps = data[5];
                    try {
                        EngineerImpl engineer = new EngineerImpl(id, firstName, lastName, salary, corps);
                        for (int i = 6; i < data.length; i += 2) {
                            String partName = data[i];
                            int hoursWorked = Integer.parseInt(data[i + 1]);
                            engineer.addRepair(new RepairImpl(partName, hoursWorked));
                        }
                        soldiers.add(engineer);
                    } catch (IllegalArgumentException e) {
                    }
                    break;
                case "Commando":
                    salary = Double.parseDouble(data[4]);
                    corps = data[5];
                    try {
                        CommandoImpl commando = new CommandoImpl(id, firstName, lastName, salary, corps);
                        for (int i = 6; i < data.length; i += 2) {
                            String codeName = data[i];
                            String state = data[i + 1];
                            try {
                                commando.addMission(new MissionImpl(codeName, state));
                            } catch (IllegalArgumentException e) {
                            }
                        }
                        soldiers.add(commando);
                    } catch (IllegalArgumentException e) {
                    }
                    break;
                case "Spy":
                    String codeNumber = data[4];
                    SpyImpl spy = new SpyImpl(id, firstName, lastName, codeNumber);
                    soldiers.add(spy);
                    break;
            }

            command = scanner.nextLine();
        }

        for (Soldier soldier : soldiers) {
            System.out.println(soldier);
        }
    }
}




