import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AddUnitTest {

    // void add(Transaction transaction);
    // 1. Когато добавям транцакции - запазвам само уникалните (по тяхното id)

    @Test
    public void whenAddMultipleTransactions_storeUniqueOnly() {

        ChainblockImpl database = new ChainblockImpl();

        Transaction transactionA = new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Vik", "Enzo", 10.00);
        Transaction transactionB = new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Vik", "Enzo", 10.00);
        Transaction transactionC = new TransactionImpl(2, TransactionStatus.SUCCESSFUL, "Vik", "Enzo", 10.00);
        Transaction transactionD = new TransactionImpl(3, TransactionStatus.SUCCESSFUL, "Vik", "Enzo", 10.00);

        Assertions.assertEquals(0, database.getCount());
        database.add(transactionA);
        database.add(transactionB);
        database.add(transactionC);
        database.add(transactionD);
        Assertions.assertEquals(3, database.getCount());
    }
}
