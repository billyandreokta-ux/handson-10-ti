package latihan3;

// Java tidak mendukung "import X as Y"
// Perbaikan: gunakan import normal
import latihan3.bad.NotificationSender;
import latihan3.bad.EmailSender;
import latihan3.bad.ReadOnlySender;
import latihan3.good.*;

public class LSPPractice {
    public static void main(String[] args) {
        /*
         * LATIHAN 3: LISKOV SUBSTITUTION PRINCIPLE (LSP)
         *
         * Definisi:
         * "Objects of a superclass should be replaceable with objects of
         *  a subclass without breaking the application."
         *
         * Tujuan Latihan:
         * 1. Memahami violation dari LSP
         * 2. Mengidentifikasi masalah: throwing unexpected exceptions
         * 3. Memahami kontrak dari parent class
         * 4. Mendesain proper abstraction
         */

        // ===== PART 1: BAD PRACTICE - Melanggar LSP =====
        System.out.println("=== BAD PRACTICE: Melanggar LSP ===\n");

        // Polymorphic code - menggunakan parent class reference
        NotificationSender sender1 = new EmailSender();
        NotificationSender sender2 = new ReadOnlySender(); // PROBLEM!

        // Test sender1 (EmailSender)
        System.out.println("Testing EmailSender:");
        processNotification(sender1, "user@example.com", "Hello");

        // Test sender2 (ReadOnlySender)
        System.out.println("\nTesting ReadOnlySender:");
        try {
            processNotification(sender2, "user@example.com", "Hello");
        } catch (Exception e) {
            System.out.println("Exception thrown: " + e.getClass().getSimpleName() +
                    ": " + e.getMessage());
            System.out.println("Program crashed!");
        }

        System.out.println("\n--- Analisis Masalah ---");
        System.out.println("ReadOnlySender melanggar LSP karena:");
        System.out.println("1. Parent NotificationSender promise: bisa send notification");
        System.out.println("2. ReadOnlySender: throw exception instead");
        System.out.println("3. Cannot substitute parent class safely");
        System.out.println("4. Breaks polymorphic code");
        System.out.println("\nIni MELANGGAR LSP: subclass tidak bisa replace parent!");

        System.out.println("\n" + "=".repeat(70));

        // ===== PART 2: GOOD PRACTICE - Mengikuti LSP =====
        System.out.println("\n=== GOOD PRACTICE: Mengikuti LSP ===\n");

        /* (TETAP DIAMKAN, TIDAK DIUBAH)
         * INSTRUKSI REFACTORING:
         *
         * 1. Buka folder good/
         * 2. Lengkapi class-class berikut:
         * ...
         */


        System.out.println("Testing dengan semua implementation:");

        latihan3.good.NotificationSender goodSender1 =
                new latihan3.good.EmailSender();

        latihan3.good.NotificationSender goodSender2 =
                new latihan3.good.SmsSender();


        testSender(goodSender1, "user@example.com", "Hello");
        testSender(goodSender2, "081234567890", "Hello");

    }

    // Helper method untuk demonstrasi polymorphic code
    private static void processNotification(NotificationSender sender,
                                          String recipient, String message) {
        boolean success = sender.send(recipient, message);
        if (success) {
            System.out.println("✓ Notification sent successfully");
        } else {
            System.out.println("✗ Failed to send notification");
        }
    }


    private static void testSender(latihan3.good.NotificationSender sender,
                                   String recipient, String message)
    {
        boolean success = sender.send(recipient, message);
        if (success) {
            System.out.println("  → Success!");
        }
    }

}
