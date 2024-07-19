package vehicleShop.models.worker;

public class SecondShift extends BaseWorker {

    public SecondShift(String name) {
        super(name, 70);
    }

    @Override
    public void working() {

        int newStrength = getStrength() - 15;
        if (newStrength < 0) {
            newStrength = 0;
        }
        setStrength(newStrength);
    }
}
