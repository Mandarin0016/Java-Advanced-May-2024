import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RemoveTransactionByIdUnitTest {

    // removeTransactionById(id)
    // 1. Ако имам транзакция с това ид - премахвам транзакцията
    // 2. Ако нямам транзакция с това ид - throw IllegalArgumentException

    @Test
    public void whenTransactionExist_thenRemoveIt() {

        ChainblockImpl database = new ChainblockImpl();

        Transaction transactionA = new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Vik", "Dani", 200.00);
        database.add(transactionA);

        // Имам 1 транзакция
        Assertions.assertEquals(1, database.getCount());
        // Премахвам тази транзакция
        database.removeTransactionById(1);
        // Имам 0 транзакция
        Assertions.assertEquals(0, database.getCount());
    }

    @Test
    public void whenTransactionDoesNotExist_thenThrowsException() {

        ChainblockImpl database = new ChainblockImpl();

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            database.removeTransactionById(99);
        });
    }
}
