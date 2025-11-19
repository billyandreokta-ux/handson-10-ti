package latihan3.bad;

// Implementation yang SALAH - melanggar LSP
public class EmailSender extends NotificationSender {

    public EmailSender() {
        super("EMAIL");
    }

    @Override
    public boolean send(String recipient, String message) {
        // Melanggar kontrak:
        // Parent class mengharuskan: return true jika sukses,
        // validasi recipient/message, dan print pesan.
        // Tetapi di sini justru diabaikan.

        System.out.println("EmailSender ERROR: Can't send email for some reason.");
        return false; // selalu false → melanggar kontrak
    }
}
