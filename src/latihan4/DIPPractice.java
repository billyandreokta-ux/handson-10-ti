package latihan4;
import latihan4.good.*;


public class DIPPractice {

    public static void main(String[] args) {

        System.out.println("\n=== BAD PRACTICE: Melanggar DIP ===\n");

        latihan4.bad.PaymentService bad = new latihan4.bad.PaymentService();
        bad.processPayment("4532-1234-5678-9010", 150000.0, "user@example.com");

        System.out.println("\n".repeat(2));
        System.out.println("======================================================================\n");

        System.out.println("=== GOOD PRACTICE: Mengikuti DIP ===\n");

        System.out.println("--- Setup 1: Stripe Payment Gateway ---");

        PaymentService stripeService = new PaymentService(
                new LuhnCardValidator(),
                new RuleBasedFraudDetector(),
                new StripePaymentGateway(),
                new DatabaseTransactionLogger(),
                new EmailNotificationSender()
        );

        stripeService.processPayment("4532-1234-5678-9010", 150000.0, "user@example.com");

        System.out.println("\n======================================================================\n");

        System.out.println("--- Setup 2: PayPal Payment Gateway ---");

        PaymentService paypalService = new PaymentService(
                new LuhnCardValidator(),
                new RuleBasedFraudDetector(),
                new PayPalPaymentGateway(),
                new DatabaseTransactionLogger(),
                new EmailNotificationSender()
        );

        paypalService.processPayment("4532-9876-5432-1098", 250000.0, "buyer@example.com");
    }
}
