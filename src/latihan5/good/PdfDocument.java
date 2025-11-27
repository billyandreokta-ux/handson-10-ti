package latihan5.good;

// PdfDocument hanya implement capability yang dimiliki
// Readable + Printable saja
public class PdfDocument implements Readable, Printable {
    private String filename;

    // TODO: Uncomment dan implementasikan
    // Class ini hanya implement 2 interface:
    // 1. Readable - karena PDF bisa dibaca
    // 2. Printable - karena PDF bisa dicetak
    // TIDAK implement Editable, Calculable, Resizable


    public PdfDocument(String filename) {
        this.filename = filename;
    }

    @Override
    public void read() {
        System.out.println("[PdfDocument] Reading PDF: " + filename);
    }

    @Override
    public void print() {
        System.out.println("[PdfDocument] Printing PDF: " + filename);
    }

}
