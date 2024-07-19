package vehicleShop.repositories;

import vehicleShop.models.worker.Worker;

import java.util.ArrayList;
import java.util.Collection;

public class WorkerRepository implements Repository<Worker> {

    private Collection<Worker> workers;

    public WorkerRepository() {
        this.workers = new ArrayList<>();
    }

    @Override
    public Collection<Worker> getWorkers() {
        return workers.stream().toList();
    }

    @Override
    public void add(Worker model) {
        this.workers.add(model);
    }

    @Override
    public boolean remove(Worker model) {
        return this.workers.remove(model);
    }

    @Override
    public Worker findByName(String name) {
        return this.workers.stream()
                .filter(worker -> worker.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}
