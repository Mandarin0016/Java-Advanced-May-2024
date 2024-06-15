package spaceCrafts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LaunchPad {

    private String name;
    private int capacity;
    private List<Spacecraft> spacecrafts;

    public LaunchPad(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.spacecrafts = new ArrayList<>();
    }

    public void addSpacecraft(Spacecraft spacecraft) {
        if (spacecrafts.size() < capacity) {
            this.spacecrafts.add(spacecraft);
        } else {
            System.out.println("This launchpad is at full capacity!");
        }
    }

    public boolean removeSpacecraft(String name) {

        // Начин 1:
//        for (Spacecraft spacecraft : spacecrafts) {
//            if (spacecraft.getName().equals(name)) {
//                spacecrafts.remove(spacecraft);
//                return true;
//            }
//        }
//        return false;

        // Начин 2:
        return spacecrafts.removeIf(spacecraft -> spacecraft.getName().equals(name));
    }

    public String getHeaviestSpacecraft() {

        Spacecraft heaviestSpacecraft = Collections.max(spacecrafts, Comparator.comparing(Spacecraft::getWeight));
        return String.format("%s - %dkg.", heaviestSpacecraft.getName(), heaviestSpacecraft.getWeight());
    }

    public Spacecraft getSpacecraft(String name) {

        // Начин 1:
//        for (Spacecraft spacecraft : spacecrafts) {
//            if (spacecraft.getName().equals(name)) {
//                return spacecraft;
//            }
//        }
//        return null;

        // Начин 2:
        return spacecrafts.stream().filter(spacecraft -> spacecraft.getName().equals(name)).findFirst().orElse(null);
    }

    public int getCount() {
        return spacecrafts.size();
    }

    public List<Spacecraft> getSpacecraftsByMissionType(String missionType) {

        // Начин 1:
//        List<Spacecraft> spacecraftsByMissionType = new ArrayList<>();
//        for (Spacecraft spacecraft : spacecrafts) {
//            if (spacecraft.getMissionType().equals(missionType)) {
//                spacecraftsByMissionType.add(spacecraft);
//            }
//        }
//        return spacecraftsByMissionType;

        // Начин 2:
        List<Spacecraft> spacecraftsByMissionType = spacecrafts.stream().filter(spacecraft -> spacecraft.getMissionType().equals(missionType)).toList();
        if (spacecraftsByMissionType.isEmpty()) {
            System.out.println("There are no spacecrafts to respond this criteria.");
        }
        return spacecraftsByMissionType;
    }

    public String getStatistics() {

        StringBuilder sb = new StringBuilder();
        String launchPadOutput = String.format("Spacecrafts launched from %s:", this.name);
        sb.append(launchPadOutput).append(System.lineSeparator());

        if (spacecrafts.isEmpty()) {
            sb.append("none");
        } else {
            int spacecraftCounter = 1;
            for (Spacecraft spacecraft : spacecrafts) {
                String spacecraftOutput = String.format("%d. %s", spacecraftCounter, spacecraft.getName());
                sb.append(spacecraftOutput).append(System.lineSeparator());
                spacecraftCounter++;
            }
        }
        return sb.toString();
    }
}
