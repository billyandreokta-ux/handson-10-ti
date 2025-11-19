package latihan1.good;

/**
 * NotificationService (Orchestrator)
 * Tanggung jawab: Koordinasi semua komponen di atas saja
 * Alasan berubah: Workflow/orchestration logic berubah
 *
 * Ini adalah FACADE yang menggabungkan berbagai specialized classes
 * tanpa menangani detail implementasi dari masing-masing responsibility
 */
public class NotificationService {

    // TANGGUNG JAWAB 7: Orchestration (koordinasi semua class)
    // Class ini HANYA mengkoordinasikan, tidak melakukan detail implementation

    // TODO: Uncomment dan lengkapi
    // Class ini bertanggung jawab untuk:
    // 1. Menerima dependencies via constructor
    // 2. Mengkoordinasikan semua class untuk mengirim notification

    // Dependency Injection - semua dependencies diinject melalui constructor
    private MessageValidator validator;
    private MessageFormatter formatter;
    private EmailSender emailSender;
    private SmsSender smsSender;
    private NotificationLogger logger;
    private NotificationRepository repository;

    // Constructor untuk menginject semua dependencies
    public NotificationService(MessageValidator validator,
                               MessageFormatter formatter,
                               EmailSender emailSender,
                               SmsSender smsSender,
                               NotificationLogger logger,
                               NotificationRepository repository) {
        this.validator = validator;
        this.formatter = formatter;
        this.emailSender = emailSender;
        this.smsSender = smsSender;
        this.logger = logger;
        this.repository = repository;
    }

    // Koordinasi semua komponen untuk mengirim notification
    public void sendNotification(String message, String type, String recipient) {
        // Step 1: Validasi message
        validator.validate(message);

        // Step 2: Format message
        String formattedMessage = formatter.format(message);

        // Step 3: Kirim berdasarkan type (EMAIL atau SMS)
        if (type.equals("EMAIL")) {
            emailSender.send(recipient, formattedMessage);
        } else if (type.equals("SMS")) {
            smsSender.send(recipient, formattedMessage);
        }

        // Step 4: Logging
        logger.log(type, recipient);

        // Step 5: Save to repository
        repository.save(type, recipient, formattedMessage);
    }

}