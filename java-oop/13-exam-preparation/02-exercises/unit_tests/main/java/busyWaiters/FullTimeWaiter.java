package unit_tests.main.java.busyWaiters;


public class FullTimeWaiter {

    private final String name;
    private final int efficiency;


    public FullTimeWaiter(String name, int efficiency) {
        this.name = name;
        this.efficiency = efficiency;
    }

    public String getName() {
        return name;
    }

    public int getEfficiency() {
        return efficiency;
    }
}
