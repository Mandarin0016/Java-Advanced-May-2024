import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class GetBySenderOrderedByAmountDescendingUnitTest {

    // Ако има такива транзакции с такъв изпращач - връща транзакциите подредени
    // Ако няма такива транзакции с такъв изпращач - throws IllegalArgumentException

    @Test
    public void whenTransactionsExistsWithGivenSender_thenReturnThemOrdered() {

        ChainblockImpl database = new ChainblockImpl();

        Transaction transactionA = new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Svetlio", "Dani", 20.00);
        Transaction transactionB = new TransactionImpl(2, TransactionStatus.SUCCESSFUL, "Dani", "Dani", 100.00);
        Transaction transactionC = new TransactionImpl(3, TransactionStatus.SUCCESSFUL, "Svetlio", "Dani", 200.00);
        database.add(transactionA);
        database.add(transactionB);
        database.add(transactionC);

        Iterable<Transaction> result = database.getBySenderOrderedByAmountDescending("Svetlio");
        List<Transaction> transactions = new ArrayList<>();
        result.forEach(transactions::add);

        Assertions.assertEquals(2, transactions.size());
        Assertions.assertEquals(3, transactions.get(0).getId());
        Assertions.assertEquals(1, transactions.get(1).getId());
    }

    @Test
    public void whenTransactionsDoesNotExistsWithGivenSender_thenThrowsException() {

        ChainblockImpl database = new ChainblockImpl();

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            database.getBySenderOrderedByAmountDescending("Svetlio");
        });
    }
}
