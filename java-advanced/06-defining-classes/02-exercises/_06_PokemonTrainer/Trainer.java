package _06_PokemonTrainer;

import java.util.ArrayList;
import java.util.List;

public class Trainer {

    private String name;
    private int badges;
    private List<Pokemon> pokemons;

    public Trainer(String name) {
        this.name = name;
        this.badges = 0;
        this.pokemons = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public int getBadges() {
        return this.badges;
    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemons.add(pokemon);
    }

    public void checkIfPokemonExistByElement(String element) {

        boolean isAtLeastOneExist = false;
        for (Pokemon pokemon : this.pokemons) {
            if (pokemon.getElement().equals(element)) {
                isAtLeastOneExist = true;
                break;
            }
        }

        if (isAtLeastOneExist) {
            badges++;
        } else {
            for (Pokemon pokemon : this.pokemons) {
                pokemon.loseHealth();
            }
            this.pokemons.removeIf(pokemon -> pokemon.getHealth() <= 0);
        }
    }

    public String toString() {
        //"{TrainerName} {Badges} {NumberOfPokemon}"
        return String.format("%s %d %d", this.name, this.badges, this.pokemons.size());
    }
}
