package latihan4.bad;

public class NotificationSender {
    public void send(String email) {
        System.out.println("[NotificationSender] Sending notification to: " + email);
        System.out.println("[NotificationSender] Subject: Payment Successful");
    }
}
