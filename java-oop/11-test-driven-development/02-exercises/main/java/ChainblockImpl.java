import java.util.*;
import java.util.stream.Collectors;

public class ChainblockImpl implements Chainblock {

    private Map<Integer, Transaction> transactions;

    public ChainblockImpl() {
        this.transactions = new LinkedHashMap<>();
    }

    public int getCount() {
        return transactions.size();
    }

    public void add(Transaction transaction) {
        transactions.putIfAbsent(transaction.getId(), transaction);
    }

    public boolean contains(Transaction transaction) {

        return contains(transaction.getId());
    }

    public boolean contains(int id) {

        return transactions.containsKey(id);
    }

    public void changeTransactionStatus(int id, TransactionStatus newStatus) {

        validateTransactionExistById(id);
        Transaction transaction = transactions.get(id);
        transaction.setStatus(newStatus);
    }

    public void removeTransactionById(int id) {

        validateTransactionExistById(id);
        transactions.remove(id);
    }

    public Transaction getById(int id) {
        validateTransactionExistById(id);
        return transactions.get(id);
    }

    public Iterable<Transaction> getByTransactionStatus(TransactionStatus status) {

        List<Transaction> transactionsByStatus = transactions.values()
                .stream()
                .filter(transaction -> transaction.getStatus().equals(status))
                .collect(Collectors.toList());

        if (transactionsByStatus.isEmpty()) {
            throw new IllegalArgumentException();
        }

        transactionsByStatus.sort(Comparator.comparingDouble(Transaction::getAmount).reversed());

        return transactionsByStatus;
    }

    public Iterable<String> getAllSendersWithTransactionStatus(TransactionStatus status) {

        List<String> names = new ArrayList<>();
        getByTransactionStatus(status).forEach(transaction -> names.add(transaction.getFrom()));

        return names;
    }

    public Iterable<String> getAllReceiversWithTransactionStatus(TransactionStatus status) {

        List<String> names = new ArrayList<>();
        getByTransactionStatus(status).forEach(transaction -> names.add(transaction.getTo()));

        return names;
    }

    public Iterable<Transaction> getAllOrderedByAmountDescendingThenById() {

        if (transactions.isEmpty()) {
            throw new IllegalArgumentException();
        }

        List<Transaction> result = new ArrayList<>(transactions.values());
        sortByAmountDescendingAndByIdAscending(result);

        return result;
    }

    private static void sortByAmountDescendingAndByIdAscending(List<Transaction> result) {
        // Сортирам по сума в намалящ ред и по ID в нарастващ ред
        result.sort(
                Comparator
                        .comparingDouble(Transaction::getAmount).reversed()
                        .thenComparingInt(Transaction::getId)
        );
    }

    public Iterable<Transaction> getBySenderOrderedByAmountDescending(String sender) {

        List<Transaction> result = transactions.values()
                .stream()
                .filter(transaction -> transaction.getFrom().equals(sender))
                .collect(Collectors.toList());
        if (result.isEmpty()) {
            throw new IllegalArgumentException();
        }
        sortByAmountDescendingAndByIdAscending(result);

        return result;
    }

    public Iterable<Transaction> getByReceiverOrderedByAmountThenById(String receiver) {

        List<Transaction> result = transactions.values()
                .stream()
                .filter(transaction -> transaction.getTo().equals(receiver))
                .collect(Collectors.toList());
        if (result.isEmpty()) {
            throw new IllegalArgumentException();
        }
        sortByAmountDescendingAndByIdAscending(result);

        return result;
    }

    public Iterable<Transaction> getByTransactionStatusAndMaximumAmount(TransactionStatus status, double amount) {

        List<Transaction> result = transactions.values()
                .stream()
                .filter(transaction -> transaction.getStatus().equals(status))
                .filter(transaction -> transaction.getAmount() <= amount)
                .collect(Collectors.toList());

        sortByAmountDescendingAndByIdAscending(result);

        return result;
    }

    public Iterable<Transaction> getBySenderAndMinimumAmountDescending(String sender, double amount) {

        List<Transaction> result = transactions.values()
                .stream()
                .filter(transaction -> transaction.getFrom().equals(sender))
                .filter(transaction -> transaction.getAmount() >= amount)
                .collect(Collectors.toList());
        if (result.isEmpty()) {
            throw new IllegalArgumentException();
        }
        sortByAmountDescendingAndByIdAscending(result);

        return result;
    }

    public Iterable<Transaction> getByReceiverAndAmountRange(String receiver, double lo, double hi) {

        // сума >= min && сума < max && получател
        List<Transaction> result = transactions.values()
                .stream()
                .filter(transaction -> transaction.getTo().equals(receiver))
                .filter(transaction -> transaction.getAmount() >= lo && transaction.getAmount() < hi)
                .collect(Collectors.toList());
        if (result.isEmpty()) {
            throw new IllegalArgumentException();
        }
        sortByAmountDescendingAndByIdAscending(result);

        return result;
    }

    public Iterable<Transaction> getAllInAmountRange(double lo, double hi) {

        return transactions.values()
                .stream()
                .filter(transaction -> transaction.getAmount() >= lo && transaction.getAmount() <= hi)
                .collect(Collectors.toList());
    }

    public Iterator<Transaction> iterator() {
        return null;
    }

    private void validateTransactionExistById(int id) {
        if (!transactions.containsKey(id)) {
            throw new IllegalArgumentException();
        }
    }
}
