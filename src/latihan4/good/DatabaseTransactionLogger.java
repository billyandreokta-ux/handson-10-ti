package latihan4.good;

public class DatabaseTransactionLogger implements TransactionLogger {
    @Override
    public void log(String transactionId, double amount) {
        System.out.println("[DatabaseTransactionLogger] Logging to database: " + transactionId
                + ", Amount: " + amount + ", Status: SUCCESS");
    }
}
