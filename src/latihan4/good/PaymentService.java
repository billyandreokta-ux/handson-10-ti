package latihan4.good;

public class PaymentService {

    private final CardValidator validator;
    private final FraudDetector fraudDetector;
    private final PaymentGateway gateway;
    private final TransactionLogger logger;
    private final NotificationSender notifier;

    public PaymentService(
            CardValidator validator,
            FraudDetector fraudDetector,
            PaymentGateway gateway,
            TransactionLogger logger,
            NotificationSender notifier
    ) {
        this.validator = validator;
        this.fraudDetector = fraudDetector;
        this.gateway = gateway;
        this.logger = logger;
        this.notifier = notifier;
    }

    public void processPayment(String cardNumber, double amount, String email) {
        validator.validate(cardNumber);
        fraudDetector.check(amount);
        String txn = gateway.process(cardNumber, amount);
        logger.log(txn, amount);
        notifier.send(email, amount);
    }
}
