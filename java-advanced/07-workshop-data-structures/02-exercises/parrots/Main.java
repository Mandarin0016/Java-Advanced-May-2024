package parrots;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        //Initialize the repository (Cage)
        Cage cage = new Cage("Wildness", 20);
        //Initialize entity
        Parrot parrot = new Parrot("Fluffy", "Loriinae");
        //Print Parrot
        System.out.println(parrot); // Parrot (Loriinae): Fluffy

        //Add Parrot
        cage.add(parrot);
        System.out.println(cage.count()); //1
        //Remove Parrot
        cage.remove("Parrot Name"); //false

        Parrot secondParrot = new Parrot("Bunny", "Cacatuidae");
        Parrot thirdParrot = new Parrot("Jumpy", "Strigopoidea");
        Parrot fourthParrot = new Parrot("Puffy", "Strigopoidea");
        Parrot fifthParrot = new Parrot("Marlin", "Arinae");

        //Add Parrots
        cage.add(secondParrot);
        cage.add(thirdParrot);
        cage.add(fourthParrot);
        cage.add(fifthParrot);

        //Sell Parrot by name
        System.out.println(cage.sellParrot("Bunny")); //Parrot (Cacatuidae): Bunny
        //Sell Parrot by species
        List<Parrot> soldSpecies = cage.sellParrotBySpecies("Strigopoidea");

        soldSpecies.forEach(f -> {
            System.out.println(f.getName());
        });
        //Jumpy
        //Puffy

        System.out.println(cage.report());
        //Parrots available at Wildness:
        //Parrot (Loriinae): Fluffy
        //Parrot (Arinae): Marlin

    }
}
