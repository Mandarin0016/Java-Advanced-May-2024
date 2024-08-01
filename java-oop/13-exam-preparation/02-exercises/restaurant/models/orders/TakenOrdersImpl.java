package restaurant.models.orders;

import java.util.ArrayList;
import java.util.Collection;

public class TakenOrdersImpl implements TakenOrders {

    private Collection<String> ordersList;

    public TakenOrdersImpl() {
        this.ordersList = new ArrayList<>();
    }

    @Override
    public Collection<String> getOrdersList() {
        return ordersList;
    }
}
