package unit_tests.main.java.busyWaiters;


import java.util.ArrayList;
import java.util.Collection;

public class Restaurant {
    private static final String INVALID_CLIENT = "Invalid client!";
    private static final String INVALID_CAPACITY = "Invalid capacity!";
    private static final String NO_MORE_PLACES = "No more places!";
    private static final String WAITER_EXIST = "The waiter %s already exist!";
    private static final int ZERO_CAPACITY = 0;

    private int capacity;
    private String name;
    private final Collection<FullTimeWaiter> waiters;

    // Ще тестваме създаването на ресторанта:
    // 1. име null - грешка
    // 2. име "" - грешка
    // 3. капацитета е отрицателно число - грешка
    // 4. валидно име и валиден капацитет - създавам обект
    public Restaurant(String name, int capacity) {
        this.setName(name);
        this.setCapacity(capacity);
        this.waiters = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public String getName() {
        return name;
    }

    public Collection<FullTimeWaiter> getWaiters() {
        return waiters;
    }

    public int getCount() {
        return this.waiters.size();
    }

    // Ще тестваме добавянето на сервитьор
    // 1. няма капацитет - грешка
    // 2. имам сервитьор с такова име - грешка
    // 3. успешно добавяме сервитьор
    public void addFullTimeWaiter(FullTimeWaiter waiter) {
        if (waiters.size() == this.getCapacity()) {
            throw new IllegalArgumentException(NO_MORE_PLACES);
        }
        boolean waiterExist = this.waiters
                .stream()
                .anyMatch(a -> a.getName().equals(waiter.getName()));

        if (waiterExist) {
            throw new IllegalArgumentException(String.format(WAITER_EXIST, waiter.getName()));
        }

        this.waiters.add(waiter);
    }

    // Ще тестваме премахването на сервитьор
    // 1. когато има такъв сервитьор с това име - true
    // 2. когато няма такъв сервитьор с това име - false
    public boolean removeFullTimeWaiter(String waiterName) {
        FullTimeWaiter waiter = this.waiters
                .stream()
                .filter(a -> a.getName().equals(waiterName))
                .findFirst()
                .orElse(null);

        return this.waiters.remove(waiter);
    }

    private void setCapacity(int capacity) {
        if (capacity < ZERO_CAPACITY) {
            throw new IllegalArgumentException(INVALID_CAPACITY);
        }
        this.capacity = capacity;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(INVALID_CLIENT);
        }
        this.name = name;
    }
}
