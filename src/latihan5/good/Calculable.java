package latihan5.good;

// Interface untuk capability CALCULATION
// HANYA Spreadsheet yang implement ini
public interface Calculable {

    // TODO: Uncomment dan implementasikan
    /*
     * Calculate formula
     * Hanya Spreadsheet yang punya capability ini
     *
     * @param formula - Formula to calculate (e.g., "SUM(A1:A10)")
     */

    void calculate(String formula);

}
