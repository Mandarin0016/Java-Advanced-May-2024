package unmodifiableexample;

import sortbynameandage.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Team {
    private String name;
    private int capacity;
    private List<Person> players;

    public Team(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.players = new ArrayList<>();
    }

    public void addPlayer(Person p) {
        if (players.size() == capacity) {
            throw new IllegalStateException("Team full");
        }
        players.add(p);
    }

    public List<Person> getPlayers() {
        return Collections.unmodifiableList(players);
    }
}
