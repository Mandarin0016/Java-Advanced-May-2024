import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class GetByReceiverAndAmountRangeUnitTest {

    // сума >= min && сума < max && получател

    @Test
    public void whenThereAreTransactions_thenReturned() {

        ChainblockImpl database = new ChainblockImpl();

        Transaction transactionA = new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Svetlio", "Dani", 20.00);
        Transaction transactionB = new TransactionImpl(2, TransactionStatus.SUCCESSFUL, "Dani", "Vik", 22.00);
        Transaction transactionC = new TransactionImpl(3, TransactionStatus.SUCCESSFUL, "Dani", "Enzo", 100.00);
        Transaction transactionD = new TransactionImpl(4, TransactionStatus.SUCCESSFUL, "Dani", "Vik", 15.00);
        database.add(transactionA);
        database.add(transactionB);
        database.add(transactionC);
        database.add(transactionD);

        Iterable<Transaction> result = database.getByReceiverAndAmountRange("Vik", 10, 30);
        List<Transaction> transactions = new ArrayList<>();
        result.forEach(transactions::add);

        Assertions.assertEquals(2, transactions.size());
        Assertions.assertEquals(2, transactions.get(0).getId());
        Assertions.assertEquals(4, transactions.get(1).getId());
    }

    @Test
    public void whenThereAreNoTransactions_throwsException() {

        ChainblockImpl database = new ChainblockImpl();

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            database.getByReceiverAndAmountRange("Vik", 10, 30);
        });
    }

}
