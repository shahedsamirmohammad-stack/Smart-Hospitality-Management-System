// Name: Shahed Samir Mohammed
// ID: 220231639

package payment;

// This is the interface our modern system expects
public interface ModernPaymentSystem {
    boolean processPayment(double amount, String paymentMethod);
    String getPaymentStatus();
}