package _07_Google;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private String name;
    private Company company;
    private List<Pokemon> pokemons;
    private List<Relative> parents;
    private List<Relative> children;
    private Car car;

    public Person(String name) {
        this.name = name;
        this.pokemons = new ArrayList<>();
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemons.add(pokemon);
    }

    public void addParent(Relative parent) {
        this.parents.add(parent);
    }

    public void addChild(Relative child) {
        this.children.add(child);
    }

    @Override
    public String toString() {

        //GeorgeJohnson
        //Company:
        //JeleInc Jelior 777.77
        //Car:
        //AudiA4 180
        //Pokemon:
        //Onyx Rock
        //Charizard Fire
        //Parents:
        //SaraJohnson 13/03/1933
        //Children:
        //SamJohnson 01/01/2001

        StringBuilder sb = new StringBuilder();
        sb.append(this.name).append(System.lineSeparator());
        sb.append("Company:").append(System.lineSeparator());
        if (this.company != null) {
            sb.append(this.company).append(System.lineSeparator());
        }
        sb.append("Car:").append(System.lineSeparator());
        if (this.car != null) {
            sb.append(this.car).append(System.lineSeparator());
        }
        sb.append("Pokemon:").append(System.lineSeparator());
        if (!this.pokemons.isEmpty()) {
            this.pokemons.forEach(pokemon -> sb.append(pokemon).append(System.lineSeparator()));
        }
        sb.append("Parents:").append(System.lineSeparator());
        if (!this.parents.isEmpty()) {
            this.parents.forEach(parent -> sb.append(parent).append(System.lineSeparator()));
        }
        sb.append("Children:").append(System.lineSeparator());
        if (!this.children.isEmpty()) {
            this.children.forEach(child -> sb.append(child).append(System.lineSeparator()));
        }
        return sb.toString();
    }
}
