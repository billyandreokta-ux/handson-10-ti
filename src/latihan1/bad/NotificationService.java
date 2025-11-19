package latihan1.bad;

/**
 * NotificationService (BAD PRACTICE)
 * Class ini MELANGGAR SRP karena memiliki terlalu banyak tanggung jawab
 *
 * Tanggung jawab yang tercampur dalam 1 class:
 * 1. Validasi message
 * 2. Format message
 * 3. Kirim EMAIL
 * 4. Kirim SMS
 * 5. Logging
 * 6. Save to database
 *
 * Alasan untuk berubah (reasons to change): 6 alasan! ❌
 * - Jika validation logic berubah
 * - Jika format message berubah
 * - Jika EMAIL sending berubah
 * - Jika SMS sending berubah
 * - Jika logging requirement berubah
 * - Jika database provider berubah
 */
public class NotificationService {

    public void sendNotification(String message, String type, String recipient) {
        // 1. TANGGUNG JAWAB: Validasi message
        if (message == null || message.isEmpty()) {
            throw new IllegalArgumentException("Message cannot be empty");
        }

        // 2. TANGGUNG JAWAB: Format message
        String formattedMessage = message.toUpperCase() + " [SENT AT: " +
                System.currentTimeMillis() + "]";

        // 3. TANGGUNG JAWAB: Kirim berdasarkan type (EMAIL atau SMS)
        if (type.equals("EMAIL")) {
            System.out.println("Sending EMAIL to: " + recipient);
            System.out.println("Content: " + formattedMessage);
        } else if (type.equals("SMS")) {
            System.out.println("Sending SMS to: " + recipient);
            System.out.println("Content: " + formattedMessage);
        }

        // 4. TANGGUNG JAWAB: Logging
        System.out.println("LOG: Notification sent - Type: " + type);

        // 5. TANGGUNG JAWAB: Save to database
        System.out.println("DB: Saving notification record...");
    }
}