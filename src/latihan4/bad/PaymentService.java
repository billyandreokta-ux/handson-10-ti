package latihan4.bad;

public class PaymentService {

    private CardValidator validator = new CardValidator();
    private FraudDetector fraudDetector = new FraudDetector();
    private PaymentGateway paymentGateway = new PaymentGateway();
    private TransactionLogger logger = new TransactionLogger();
    private NotificationSender notifier = new NotificationSender();

    public void processPayment(String cardNumber, double amount, String email) {

        validator.validate(cardNumber);
        fraudDetector.check(amount);
        String transactionId = paymentGateway.process(cardNumber, amount);
        logger.log(transactionId, amount);
        notifier.send(email);
    }
}
