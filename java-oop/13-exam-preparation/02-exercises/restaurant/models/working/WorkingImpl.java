package restaurant.models.working;

import restaurant.models.client.Client;
import restaurant.models.waiter.Waiter;

import java.util.Collection;

public class WorkingImpl implements Working {

    @Override
    public void takingOrders(Client client, Collection<Waiter> waiters) {

        Collection<String> orders = client.getClientOrders();

        for (Waiter waiter : waiters) {

            // Докато сервитьора може да работи:
            while (waiter.canWork() && orders.iterator().hasNext()) {

                // 4. Намлям efficiency-то на сервитьора
                waiter.work();
                // 1. Вземам поръчка от клиента
                String order = orders.iterator().next();
                // 2. Добавям поръчката към списъка на сервитьора
                waiter.takenOrders().getOrdersList().add(order);
                // 3. Премахвам поръчката от списъка на клиента
                orders.remove(order);
            }
        }
    }
}
