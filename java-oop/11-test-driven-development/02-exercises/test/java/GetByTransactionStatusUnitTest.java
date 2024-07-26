import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class GetByTransactionStatusUnitTest {

    //getByTransactionStatus(status)
    // 1. Ако има такива транзакции с този статус - получавам всичките транзакции
    // 2. Ако няма такива транзакции с този статус - throw IllegalArgumentException

    @Test
    public void whenTransactionExistWithThisStatus_thenReturnThem() {

        ChainblockImpl database = new ChainblockImpl();

        Transaction transactionA = new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Vik", "Dani", 20.00);
        Transaction transactionB = new TransactionImpl(2, TransactionStatus.SUCCESSFUL, "Vik", "Dani", 100.00);
        Transaction transactionC = new TransactionImpl(3, TransactionStatus.SUCCESSFUL, "Vik", "Dani", 200.00);
        Transaction transactionD = new TransactionImpl(4, TransactionStatus.ABORTED, "Vik", "Dani", 200.00);
        database.add(transactionA);
        database.add(transactionB);
        database.add(transactionC);
        database.add(transactionD);

        Iterable<Transaction> result = database.getByTransactionStatus(TransactionStatus.SUCCESSFUL);
        List<Transaction> transactions = new ArrayList<>();
        result.forEach(transactions::add);

        // Проверявам дали точно 3 на брой транзакции съм получил
        Assertions.assertEquals(3, transactions.size());

        // Проверявам подредбата
        Transaction firstTransaction = transactions.get(0); // C - 200 lv
        Transaction secondTransaction = transactions.get(1);// B - 100 lv
        Transaction thirdTransaction = transactions.get(2); // A - 20 lv
        Assertions.assertEquals(transactionC, firstTransaction);
        Assertions.assertEquals(transactionB, secondTransaction);
        Assertions.assertEquals(transactionA, thirdTransaction);
    }

    @Test
    public void whenTransactionDoesNotExistWithThisStatus_thenThrownException() {

        ChainblockImpl database = new ChainblockImpl();

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            database.getByTransactionStatus(TransactionStatus.FAILED);
        });
    }

}
