import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class GetByTransactionStatusAndMaximumAmountUnitTest {


    // 1. Ако имам транзакции с този статус и сума по-малка или равна на позволената сума - връщам тези транзакции
    // 2. Ако нямам транзакции с този статус и сума по-малка или равна на позволената сума - връщам празна колекция

    @Test
    public void whenTransactionsExistWithThisStatusAndAmountLessThanMaxAllowed_thenReturnThem() {

        ChainblockImpl database = new ChainblockImpl();

        Transaction transactionA = new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Svetlio", "Dani", 20.00);
        Transaction transactionB = new TransactionImpl(2, TransactionStatus.SUCCESSFUL, "Dani", "Dani", 100.00);
        database.add(transactionA);
        database.add(transactionB);

        Iterable<Transaction> result = database.getByTransactionStatusAndMaximumAmount(TransactionStatus.SUCCESSFUL, 30.00);
        List<Transaction> transactions = new ArrayList<>();
        result.forEach(transactions::add);

        Assertions.assertEquals(1, transactions.size());
        Assertions.assertEquals(1, transactions.get(0).getId());
    }

    @Test
    public void whenTransactionsDoesNotExistWithThisStatusAndAmountLessThanMaxAllowed_thenReturnEmptyCollection() {

        ChainblockImpl database = new ChainblockImpl();

        Iterable<Transaction> result = database.getByTransactionStatusAndMaximumAmount(TransactionStatus.SUCCESSFUL, 30.00);
        List<Transaction> transactions = new ArrayList<>();
        result.forEach(transactions::add);

        Assertions.assertEquals(0, transactions.size());
    }
}
