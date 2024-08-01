package restaurant.models.client;

import java.util.ArrayList;
import java.util.Collection;

import static restaurant.common.ExceptionMessages.CLIENT_NAME_NULL_OR_EMPTY;

public class ClientImpl implements Client{

    private String name;
    private Collection<String> clientOrders;

    public ClientImpl(String name) {
        setName(name);
        this.clientOrders = new ArrayList<>();
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new NullPointerException(CLIENT_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public Collection<String> getClientOrders() {
        return this.clientOrders;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
