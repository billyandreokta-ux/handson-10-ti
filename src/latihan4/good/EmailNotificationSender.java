package latihan4.good;

public class EmailNotificationSender implements NotificationSender {
    @Override
    public void send(String email, double amount) {
        System.out.println("[EmailNotificationSender] Sending email to: " + email);
        System.out.println("[EmailNotificationSender] Subject: Payment Successful - Amount: Rp " + amount);
    }
}
