package _05_CarSalesman;

public class Engine {

    private String model;
    private String power;
    private String displacement;
    private String efficiency;

    public Engine(String model, String power, String displacement, String efficiency) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    public String getModel() {
        return model;
    }

    public String toString() {
        //{EngineModel}:
        //Power: {EnginePower}
        //Displacement: {EngineDisplacement}
        //Efficiency: {EngineEfficiency}
        StringBuilder sb = new StringBuilder();
        sb.append(this.model).append(":").append(System.lineSeparator());
        sb.append("Power: ").append(this.power).append(System.lineSeparator());
        sb.append("Displacement: ").append(this.displacement).append(System.lineSeparator());
        sb.append("Efficiency: ").append(this.efficiency);
        return sb.toString();
    }
}
