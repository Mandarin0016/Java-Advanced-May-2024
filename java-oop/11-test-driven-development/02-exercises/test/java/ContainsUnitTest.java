import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContainsUnitTest {

    // boolean contains(Transaction transaction);
    // boolean contains(int id);
    // 1. Ако в базата от данни има транзакция с такова id - true
    // 2. Ако в базата от данни нямам транзакция с такова id - false

    @Test
    public void whenTransactionExistByThisId_thenReturnTrue() {

        ChainblockImpl database = new ChainblockImpl();

        Transaction transactionA = new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Vik", "Enzo", 10.00);
        database.add(transactionA);

        Assertions.assertTrue(database.contains(1));
        Assertions.assertTrue(database.contains(transactionA));
    }

    @Test
    public void whenTransactionDoesNotExistByThisId_thenReturnFalse() {

        ChainblockImpl database = new ChainblockImpl();

        Transaction transactionA = new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Vik", "Enzo", 10.00);

        Assertions.assertFalse(database.contains(1));
        Assertions.assertFalse(database.contains(transactionA));
    }
}
