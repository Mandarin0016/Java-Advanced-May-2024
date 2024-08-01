package restaurant.models.waiter;

//TODO
public class FullTimeWaiter extends BaseWaiter {

    public FullTimeWaiter(String name) {
        super(name, 8);
    }

    @Override
    public void work() {

        int newEfficiency = getEfficiency() - 1;
        if (newEfficiency < 0){
            newEfficiency = 0;
        }
        setEfficiency(newEfficiency);
    }
}
