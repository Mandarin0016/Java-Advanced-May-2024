package unmodifiableexample;

import sortbynameandage.Person;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Team team = new Team("Germany", 1);

        team.addPlayer(new Person("Pesho", "Ivanov", 42, 480));
        List<Person> players = team.getPlayers();
        players.add(new Person("Pesho", "Ivanov", 42, 480));

        System.out.println();
    }
}
