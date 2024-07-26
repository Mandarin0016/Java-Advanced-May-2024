import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class GetBySenderAndMinimumAmountDescendingUnitTest {

    // изпращач и сума по-голяма от минималната
    // 1. Ако имам транзакции - връщам тези транзакции
    // 2. Ако нямам транзакции - throw Exception

    @Test
    public void whenThereAreTransactions_thenReturnThemOrdered() {

        ChainblockImpl database = new ChainblockImpl();

        Transaction transactionA = new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Svetlio", "Dani", 20.00);
        Transaction transactionB = new TransactionImpl(2, TransactionStatus.SUCCESSFUL, "Dani", "Dani", 100.00);
        Transaction transactionC = new TransactionImpl(3, TransactionStatus.SUCCESSFUL, "Dani", "Dani", 10.00);
        database.add(transactionA);
        database.add(transactionB);
        database.add(transactionC);

        Iterable<Transaction> result = database.getBySenderAndMinimumAmountDescending("Dani", 30.00);
        List<Transaction> transactions = new ArrayList<>();
        result.forEach(transactions::add);

        Assertions.assertEquals(1, transactions.size());
        Assertions.assertEquals(2, transactions.get(0).getId());
    }

    @Test
    public void whenThereAreNoTransactions_thenThrowException() {

        ChainblockImpl database = new ChainblockImpl();

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            database.getBySenderAndMinimumAmountDescending("Dani", 30.00);
        });
    }

}
