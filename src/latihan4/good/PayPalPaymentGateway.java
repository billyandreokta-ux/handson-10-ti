package latihan4.good;

public class PayPalPaymentGateway implements PaymentGateway {
    @Override
    public String process(String cardNumber, double amount) {
        System.out.println("[PayPalPaymentGateway] Processing payment via PayPal");
        System.out.println("[PayPalPaymentGateway] Charging " + amount + " to card: " + cardNumber);
        System.out.println("[PayPalPaymentGateway] Payment successful - Transaction ID: PAYPAL-TXN-67890");
        return "PAYPAL-TXN-67890";
    }
}
