package restaurant.models.waiter;

//TODO
public class HalfTimeWaiter extends BaseWaiter{

    public HalfTimeWaiter(String name) {
        super(name, 4);
    }

    @Override
    public void work() {

        int newEfficiency = getEfficiency() - 2;
        if (newEfficiency < 0){
            newEfficiency = 0;
        }
        setEfficiency(newEfficiency);
    }
}
