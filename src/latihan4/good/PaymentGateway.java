package latihan4.good;

public interface PaymentGateway {
    String process(String cardNumber, double amount);
}
