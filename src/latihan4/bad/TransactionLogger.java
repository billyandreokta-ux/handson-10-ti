package latihan4.bad;

public class TransactionLogger {
    public void log(String transactionId, double amount) {
        System.out.println("[TransactionLogger] Logging transaction: " + transactionId
                + ", Amount: " + amount + ", Status: SUCCESS");
    }
}
