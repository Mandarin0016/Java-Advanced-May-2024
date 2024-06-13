package sharkHaunt;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Basin {
    private String name;
    private int capacity;
    private List<Shark> sharks;

    public Basin(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.sharks = new ArrayList<>();
    }

    public void addShark(Shark shark) {
        if (sharks.size() == capacity) {
            System.out.println("This basin is at full capacity!");
        } else {
            sharks.add(shark);
        }
    }

    public boolean removeShark(String kind) {
        return sharks.removeIf(s -> s.getKind().equals(kind));
    }

    public Shark getLargestShark() {
        return sharks.stream().max(Comparator.comparingInt(Shark::getLength))
                .orElse(null);
    }

    public Shark getShark(String kind) {
        return sharks.stream()
                .filter(s -> s.getKind().equals(kind))
                .findFirst()
                .orElse(null);
    }

    public int getCount() {
        return sharks.size();
    }

    public int getAverageLength() {
        return sharks.stream()
                .mapToInt(Shark::getLength)
                .sum() / sharks.size();
    }

    public String report() {
        String sharksData = sharks.stream()
                .map(Shark::toString)
                .collect(Collectors.joining(System.lineSeparator()));
        return String.format("Sharks in %s:%n", name) + sharksData;
    }

}
