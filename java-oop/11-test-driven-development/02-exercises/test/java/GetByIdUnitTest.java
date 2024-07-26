import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GetByIdUnitTest {

    // getById(id)
    // 1. Ако имам транзакция с това ид - връщам транзакцията
    // 2. Ако нямам транзакция с това ид - throw IllegalArgumentException

    @Test
    public void whenTransactionExists_thenReturnIt() {

        ChainblockImpl database = new ChainblockImpl();

        Transaction transactionA = new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Vik", "Dani", 200.00);
        database.add(transactionA);

        // НАЧИН 1:
        Transaction result = database.getById(1);
        Assertions.assertEquals(transactionA, result);

        // НАЧИН 2:
        Assertions.assertDoesNotThrow(() -> {
            database.getById(1);
        });
    }

    @Test
    public void whenTransactionDoesNotExists_thenThrowsException() {

        ChainblockImpl database = new ChainblockImpl();

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            database.getById(99);
        });
    }
}
