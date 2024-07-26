import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class GetAllOrderedByAmountDescendingThenByIdUnitTest {

    // getAllOrderedByAmountDescendingThenById()
    // 1. Ако има транзакции - връщам подредени по сума в намалящ ред и по ИД в нарастващ ред
    // 2. Ако няма транзакции - throw IllegalArgumentException

    @Test
    public void whenThereAreMultipleTransactions_thenReturnThemOrdered() {

        ChainblockImpl database = new ChainblockImpl();

        Transaction transactionA = new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Svetlio", "Enzo", 20.00);
        Transaction transactionB = new TransactionImpl(2, TransactionStatus.SUCCESSFUL, "Dani", "Vik", 100.00);
        Transaction transactionC = new TransactionImpl(3, TransactionStatus.SUCCESSFUL, "Niki", "Dani", 200.00);
        Transaction transactionD = new TransactionImpl(4, TransactionStatus.ABORTED, "Vik", "Dani", 200.00);
        database.add(transactionA);
        database.add(transactionB);
        database.add(transactionC);
        database.add(transactionD);

        Iterable<Transaction> result = database.getAllOrderedByAmountDescendingThenById();
        List<Transaction> transactions = new ArrayList<>();
        result.forEach(transactions::add);

        Assertions.assertEquals(4, transactions.size());

        // C D B A
        Assertions.assertEquals(3, transactions.get(0).getId());
        Assertions.assertEquals(4, transactions.get(1).getId());
        Assertions.assertEquals(2, transactions.get(2).getId());
        Assertions.assertEquals(1, transactions.get(3).getId());
    }

    @Test
    public void whenThereAreNoTransactions_thenThrowException() {

        ChainblockImpl database = new ChainblockImpl();

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
           database.getAllOrderedByAmountDescendingThenById();
        });
    }

}
