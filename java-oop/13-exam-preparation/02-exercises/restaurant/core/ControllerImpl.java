package restaurant.core;

import restaurant.models.client.Client;
import restaurant.models.client.ClientImpl;
import restaurant.models.waiter.FullTimeWaiter;
import restaurant.models.waiter.HalfTimeWaiter;
import restaurant.models.waiter.Waiter;
import restaurant.models.working.Working;
import restaurant.models.working.WorkingImpl;
import restaurant.repositories.ClientRepository;
import restaurant.repositories.WaiterRepository;

import java.util.Collection;
import java.util.List;

import static restaurant.common.ConstantMessages.*;
import static restaurant.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private WaiterRepository waiterRepository;
    private ClientRepository clientRepository;
    private Working working;
    private int totalCountOfServedClients = 0;

    public ControllerImpl() {
        this.waiterRepository = new WaiterRepository();
        this.clientRepository = new ClientRepository();
        this.working = new WorkingImpl();
    }

    @Override
    public String addWaiter(String type, String waiterName) {

        Waiter waiter = null;
        if (type.equals("FullTimeWaiter")) {
            waiter = new FullTimeWaiter(waiterName);
        } else if (type.equals("HalfTimeWaiter")) {
            waiter = new HalfTimeWaiter(waiterName);
        } else {
            throw new IllegalArgumentException(WAITER_INVALID_TYPE);
        }

        waiterRepository.add(waiter);
        return WAITER_ADDED.formatted(type, waiterName);
    }

    @Override
    public String addClient(String clientName, String... orders) {

        Client client = new ClientImpl(clientName);
        client.getClientOrders().addAll(List.of(orders));
        clientRepository.add(client);
        return CLIENT_ADDED.formatted(clientName);
    }

    @Override
    public String removeWaiter(String waiterName) {

        Waiter waiter = waiterRepository.byName(waiterName); // null
        if (waiter == null) {
            throw new IllegalArgumentException(WAITER_DOES_NOT_EXIST.formatted(waiterName));
        }
        waiterRepository.remove(waiter);
        return WAITER_REMOVE.formatted(waiterName);
    }

    @Override
    public String removeClient(String clientName) {

        Client client = clientRepository.byName(clientName);
        if (client == null) {
            throw new IllegalArgumentException(CLIENT_DOES_NOT_EXIST.formatted(clientName));
        }
        clientRepository.remove(client);
        return CLIENT_REMOVE.formatted(clientName);
    }

    @Override
    public String startWorking(String clientName) {

        List<Waiter> waiters = waiterRepository.getCollection().stream().filter(Waiter::canWork).toList();
        if (waiters.isEmpty()) {
            throw new IllegalArgumentException(THERE_ARE_NO_WAITERS);
        }

        Client client = clientRepository.byName(clientName);
        working.takingOrders(client, waiters);
        totalCountOfServedClients++;

        return ORDERS_SERVING.formatted(clientName);
    }

    @Override
    public String getStatistics() {

        StringBuilder sb = new StringBuilder();
        String firstRow = FINAL_CLIENTS_COUNT.formatted(totalCountOfServedClients);
        sb.append(firstRow).append(System.lineSeparator());
        sb.append(FINAL_WAITERS_STATISTICS).append(System.lineSeparator());

        for (Waiter waiter : waiterRepository.getCollection()) {
            sb.append(FINAL_WAITER_NAME.formatted(waiter.getName())).append(System.lineSeparator());
            sb.append(FINAL_WAITER_EFFICIENCY.formatted(waiter.getEfficiency())).append(System.lineSeparator());
            String orders = "None";
            if (!waiter.takenOrders().getOrdersList().isEmpty()) {
                orders = String.join(FINAL_WAITER_ORDERS_DELIMITER, waiter.takenOrders().getOrdersList());
            }
            sb.append(FINAL_WAITER_ORDERS.formatted(orders)).append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
