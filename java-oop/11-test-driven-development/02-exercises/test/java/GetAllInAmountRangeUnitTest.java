import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class GetAllInAmountRangeUnitTest {

    // сума >= min && сума <= max

    @Test
    public void whenThereAreTransactions_thenReturned() {

        ChainblockImpl database = new ChainblockImpl();

        Transaction transactionA = new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Svetlio", "Dani", 20.00);
        Transaction transactionB = new TransactionImpl(2, TransactionStatus.SUCCESSFUL, "Dani", "Dani", 100.00);
        database.add(transactionA);
        database.add(transactionB);

        Iterable<Transaction> result = database.getAllInAmountRange(10, 30);
        List<Transaction> transactions = new ArrayList<>();
        result.forEach(transactions::add);

        Assertions.assertEquals(1, transactions.size());
        Assertions.assertEquals(1, transactions.get(0).getId());
    }

    @Test
    public void whenThereAreNoTransactions_thenReturnEmptyCollection() {

        ChainblockImpl database = new ChainblockImpl();

        Iterable<Transaction> result = database.getAllInAmountRange(10, 30);
        List<Transaction> transactions = new ArrayList<>();
        result.forEach(transactions::add);

        Assertions.assertEquals(0, transactions.size());
    }
}
