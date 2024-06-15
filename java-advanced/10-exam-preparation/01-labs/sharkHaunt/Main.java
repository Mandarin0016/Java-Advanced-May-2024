package sharkHaunt;

public class Main {
    public static void main(String[] args) {
//Initialize the repositories (Basin)
        Basin pacific = new Basin("Pacific Ocean", 6);
        Basin atlantic = new Basin("Atlantic Ocean", 2);
        Basin ganges = new Basin("Ganges River", 1);
//Initialize entities (Shark)
        Shark tigerShark = new Shark("Tiger shark", 300, "mammals", "saltwater");
        Shark whaleShark = new Shark("Whale shark", 1200, "zooplankton", "saltwater");
        Shark dwarfShark = new Shark("Dwarf lantern shark", 20, "shrimp", "saltwater");
        Shark bullShark = new Shark("Bull shark", 330, "dolphins", "freshtwater");
        Shark gangesShark = new Shark("Ganges shark", 178, "fish", "freshwater");

//Add Shark
        pacific.addShark(tigerShark);
        pacific.addShark(whaleShark);
        pacific.addShark(dwarfShark);

        atlantic.addShark(bullShark);

        ganges.addShark(gangesShark);

//Remove Shark
        System.out.println(pacific.removeShark("Carpet shark")); //false

        System.out.println(atlantic.removeShark("Lemon shark")); //false
        System.out.println(atlantic.removeShark("Bull shark")); //true

//Get the largest shark
        System.out.println(pacific.getLargestShark().getKind()); //Whale shark

//Get the average length of sharks in given basin
        System.out.println(pacific.getAverageLength()); //506

        System.out.println(atlantic.getCount()); //0

//Get a report for the given basin
        System.out.println(pacific.report());
        System.out.println(ganges.report());

//Sharks in Pacific Ocean:
//The Tiger shark is 300 centimeters long, eats mammals and inhabits saltwater.
//The Whale shark is 1200 centimeters long, eats zooplankton and inhabits saltwater.
//The Dwarf lantern shark is 20 centimeters long, eats shrimp and inhabits saltwater.
//Sharks in Ganges River:
//The Ganges shark is 178 centimeters long, eats fish and inhabits freshwater.

    }
}
