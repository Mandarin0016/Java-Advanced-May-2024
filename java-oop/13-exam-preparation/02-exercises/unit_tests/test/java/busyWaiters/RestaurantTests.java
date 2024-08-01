package unit_tests.test.java.busyWaiters;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RestaurantTests {


    // Ще тестваме създаването на ресторанта:
    // 1. име null - грешка
    @Test
    public void whenNameNull_thenExceptionIsThrown() {

        Assertions.assertThrows(NullPointerException.class, () -> {
            Restaurant restaurant = new Restaurant(null, 10);
        });
    }

    // 2. име "" - грешка
    @Test
    public void whenNameEmptyString_thenExceptionIsThrown() {

        Assertions.assertThrows(NullPointerException.class, () -> {
            Restaurant restaurant = new Restaurant("", 10);
        });
    }

    // 3. капацитета е отрицателно число - грешка
    @Test
    public void whenCapacityIsNegativeNumber_thenExceptionIsThrown() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Restaurant restaurant = new Restaurant("Happy", -10);
        });
    }

    // 4. валидно име и валиден капацитет - създавам обект
    @Test
    public void whenNameAndCapacityAreValidValues_thenRestaurantIsCreated() {

        Restaurant restaurant = new Restaurant("Happy", 10);

        Assertions.assertEquals("Happy", restaurant.getName());
        Assertions.assertEquals(10, restaurant.getCapacity());
        Assertions.assertTrue(restaurant.getWaiters().isEmpty());
        Assertions.assertEquals(0, restaurant.getCount());

    }

    // Ще тестваме добавянето на сервитьор
    // 1. няма капацитет - грешка
    @Test
    public void whenNoCapacity_thenExceptionIsThrown(){

        Restaurant restaurant = new Restaurant("Happy", 0);

        FullTimeWaiter waiter = new FullTimeWaiter("Vik", 10);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            restaurant.addFullTimeWaiter(waiter);
        });
    }

    // 2. имам сервитьор с такова име - грешка
    // 3. успешно добавяме сервитьор
    @Test
    public void whenWaiterWithThisNameExist_thenExceptionIsThrown(){

        Restaurant restaurant = new Restaurant("Happy", 5);

        FullTimeWaiter waiter = new FullTimeWaiter("Vik", 10);
        restaurant.addFullTimeWaiter(waiter);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            restaurant.addFullTimeWaiter(waiter);
        });
    }

    // 1. когато има такъв сервитьор с това име - true
    @Test
    public void whenWaiterExistByThisName_thenReturnTrue(){

        Restaurant restaurant = new Restaurant("Happy", 5);

        FullTimeWaiter waiter = new FullTimeWaiter("Vik", 10);
        restaurant.addFullTimeWaiter(waiter);

        boolean result = restaurant.removeFullTimeWaiter("Vik");
        Assertions.assertTrue(result);
    }

    // 2. когато няма такъв сервитьор с това име - false
    @Test
    public void whenWaiterDoesNotExistByThisName_thenReturnFalse(){

        Restaurant restaurant = new Restaurant("Happy", 5);

        boolean result = restaurant.removeFullTimeWaiter("Vik");
        Assertions.assertFalse(result);
    }
}
