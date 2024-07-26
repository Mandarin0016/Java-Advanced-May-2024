public interface Transaction {

    int getId();

    TransactionStatus getStatus();

    String getFrom();

    String getTo();

    double getAmount();

    void setStatus(TransactionStatus newStatus);
}
