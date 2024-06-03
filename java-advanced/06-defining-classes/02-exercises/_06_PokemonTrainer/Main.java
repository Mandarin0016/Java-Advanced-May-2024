package _06_PokemonTrainer;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Trainer> trainers = new ArrayList<>();

        String input = scanner.nextLine();
        while (!input.equals("Tournament")) {

            String[] data = input.split(" ");
            //Peter Pikachu Electricity 10
            String trainerName = data[0];
            String pokemonName = data[1];
            String pokemonElement = data[2];
            int pokemonHealth = Integer.parseInt(data[3]);

            Trainer trainer = getTrainerByName(trainers, trainerName);
            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
            trainer.addPokemon(pokemon);

            input = scanner.nextLine();
        }

        String element = scanner.nextLine();
        while (!element.equals("End")) {

            for (Trainer trainer : trainers) {
                trainer.checkIfPokemonExistByElement(element);
            }

            element = scanner.nextLine();
        }

        Collections.sort(trainers, Comparator.comparing(Trainer::getBadges).reversed());
        for (Trainer trainer : trainers) {
            System.out.println(trainer);
        }
    }

    private static Trainer getTrainerByName(List<Trainer> trainers, String trainerName) {

        for (Trainer trainer : trainers) {
            if (trainer.getName().equals(trainerName)) {
                return trainer;
            }
        }

        Trainer trainer = new Trainer(trainerName);
        trainers.add(trainer);
        return trainer;
    }
}
