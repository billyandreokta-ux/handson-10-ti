package latihan4.good;

public class RuleBasedFraudDetector implements FraudDetector {
    @Override
    public boolean check(double amount) {
        System.out.println("[RuleBasedFraudDetector] Checking fraud with rules for amount: " + amount);
        System.out.println("[RuleBasedFraudDetector] No fraud detected ✓");
        return false;
    }
}
