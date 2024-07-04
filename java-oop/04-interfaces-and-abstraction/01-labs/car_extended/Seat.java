package car_extended;

public class Seat extends CarImpl implements Sellable {

    private Double price;

    public Seat(String model, String color, Integer horsePower, String countryProduced, Double price) {
        super(model, color, horsePower, countryProduced);
        this.price = price;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        //This is Leon produced in Spain and have 4 tires
        //Leon sells for 11111,100000
        String firstRow = super.toString();
        String secondRow = "%s sells for %f".formatted(getModel(), price);

        sb.append(firstRow).append(System.lineSeparator());
        sb.append(secondRow);

        return sb.toString();
    }

    @Override
    public Double getPrice() {
        return this.price;
    }
}
