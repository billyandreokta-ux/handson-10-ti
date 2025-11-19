package latihan1;

// Perbaikan import — Java tidak punya fitur "as"
import latihan1.bad.NotificationService;  // BAD version
import latihan1.good.*;
// import latihan1_srp.good.*; // Uncomment setelah refactoring selesai

public class SRPPractice {
    public static void main(String[] args) {
        /*
         * LATIHAN 1: SINGLE RESPONSIBILITY PRINCIPLE (SRP)
         *
         * Definisi:
         * "A class should have one, and only one, reason to change."
         *
         * Tujuan Latihan:
         * 1. Memahami masalah multiple responsibilities dalam satu class
         * 2. Belajar mengidentifikasi different concerns
         * 3. Memisahkan responsibilities menjadi class-class focused
         * 4. Merasakan benefits dari SRP
         */

        // ===== PART 1: BAD PRACTICE - Melanggar SRP =====
        System.out.println("=== BAD PRACTICE: Melanggar SRP ===\n");

        NotificationService badService = new NotificationService();
        badService.sendNotification("Hello World", "EMAIL", "user@example.com");

        System.out.println("\n--- Analisis Masalah ---");
        System.out.println("NotificationService memiliki TERLALU BANYAK tanggung jawab:");
        System.out.println("1. Validasi message");
        System.out.println("2. Format message");
        System.out.println("3. Kirim via EMAIL");
        System.out.println("4. Kirim via SMS");
        System.out.println("5. Logging");
        System.out.println("6. Simpan ke database");
        System.out.println("\nSatu class, BANYAK alasan untuk berubah = MELANGGAR SRP!");

        System.out.println("\n" + "=".repeat(70));

        // ===== PART 2: GOOD PRACTICE - Mengikuti SRP =====
        System.out.println("\n=== GOOD PRACTICE: Mengikuti SRP ===\n");

        /*
         * INSTRUKSI REFACTORING:
         *
         * 1. Buka folder good/
         * 2. Lengkapi class-class berikut dengan uncomment dan isi implementation:
         *
         *    a. MessageValidator.java
         *    b. MessageFormatter.java
         *    c. EmailSender.java
         *    d. SmsSender.java
         *    e. NotificationLogger.java
         *    f. NotificationRepository.java
         *    g. NotificationService.java (Orchestrator)
         */

        // UNCOMMENT CODE DI BAWAH SETELAH REFACTORING SELESAI
        MessageValidator validator = new MessageValidator();
        MessageFormatter formatter = new MessageFormatter();
        EmailSender emailSender = new EmailSender();
        SmsSender smsSender = new SmsSender();
        NotificationLogger logger = new NotificationLogger();
        NotificationRepository repository = new NotificationRepository();

        // Karena ada dua NotificationService, kita spesifikasikan yang "good"
        latihan1.good.NotificationService goodService =
                new latihan1.good.NotificationService(
                        validator,
                        formatter,
                        emailSender,
                        smsSender,
                        logger,
                        repository
                );

        goodService.sendNotification("Hello World", "EMAIL", "user@example.com");

        System.out.println("\n--- Keuntungan Setelah Refactoring ---");
        System.out.println("✓ Easy to understand - Setiap class punya fokus jelas");
        System.out.println("✓ Easy to test - Bisa test setiap komponen terpisah");
        System.out.println("✓ Easy to maintain - Perubahan di satu area tidak affect yang lain");
        System.out.println("✓ Reusable - MessageFormatter bisa dipakai di tempat lain");
        System.out.println("✓ Low coupling - Komponen tidak saling bergantung berlebihan");

        /*
         * EKSPEKTASI OUTPUT:

        /*
         * EKSPEKTASI OUTPUT:
         *
         * === BAD PRACTICE: Melanggar SRP ===
         *
         * Sending EMAIL to: user@example.com
         * Content: HELLO WORLD [SENT AT: 1234567890]
         * LOG: Notification sent - Type: EMAIL
         * DB: Saving notification record...
         *
         * --- Analisis Masalah ---
         * NotificationService memiliki TERLALU BANYAK tanggung jawab:
         * 1. Validasi message
         * 2. Format message
         * 3. Kirim via EMAIL
         * 4. Kirim via SMS
         * 5. Logging
         * 6. Simpan ke database
         *
         * Satu class, BANYAK alasan untuk berubah = MELANGGAR SRP!
         *
         * ======================================================================
         *
         * === GOOD PRACTICE: Mengikuti SRP ===
         *
         * [Validator] Message validated successfully
         * [Formatter] Message formatted: HELLO WORLD [SENT AT: 1234567890]
         * [EmailSender] Sending EMAIL to: user@example.com
         * [EmailSender] Content: HELLO WORLD [SENT AT: 1234567890]
         * [Logger] LOG: Notification sent - Type: EMAIL
         * [Repository] DB: Saving notification record...
         *
         * --- Keuntungan Setelah Refactoring ---
         * ✓ Easy to understand - Setiap class punya fokus jelas
         * ✓ Easy to test - Bisa test setiap komponen terpisah
         * ✓ Easy to maintain - Perubahan di satu area tidak affect yang lain
         * ✓ Reusable - MessageFormatter bisa dipakai di tempat lain
         * ✓ Low coupling - Komponen tidak saling bergantung berlebihan
         */
    }
}