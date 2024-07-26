import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class GetAllReceiversWithTransactionStatusUnitTest {

    // getAllReceiversWithTransactionStatus(status)
    // 1. Ако има такива транзакции с този статус - имената на получателите
    // 2. Ако няма такива транзакции с този статус - throw IllegalArgumentException

    @Test
    public void whenTransactionExistWithThisStatus_thenReturnThem() {

        ChainblockImpl database = new ChainblockImpl();

        Transaction transactionA = new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Svetlio", "Enzo", 20.00);
        Transaction transactionB = new TransactionImpl(2, TransactionStatus.SUCCESSFUL, "Dani", "Vik", 100.00);
        Transaction transactionC = new TransactionImpl(3, TransactionStatus.SUCCESSFUL, "Niki", "Dani", 200.00);
        Transaction transactionD = new TransactionImpl(4, TransactionStatus.ABORTED, "Vik", "Dani", 200.00);
        database.add(transactionA);
        database.add(transactionB);
        database.add(transactionC);
        database.add(transactionD);

        Iterable<String> result = database.getAllReceiversWithTransactionStatus(TransactionStatus.SUCCESSFUL);
        List<String> names = new ArrayList<>();
        result.forEach(names::add);

        // Проверявам дали точно 3 на брой транзакции съм получил
        Assertions.assertEquals(3, names.size());

        // Проверявам подредбата
        String nameDani = names.get(0); // C - 200 lv
        String nameVik = names.get(1);// B - 100 lv
        String nameEnzo = names.get(2); // A - 20 lv
        Assertions.assertEquals("Dani", nameDani);
        Assertions.assertEquals("Vik", nameVik);
        Assertions.assertEquals("Enzo", nameEnzo);
    }

    @Test
    public void whenTransactionDoesNotExistWithThisStatus_thenThrownException() {

        ChainblockImpl database = new ChainblockImpl();

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            database.getAllReceiversWithTransactionStatus(TransactionStatus.FAILED);
        });
    }
}
