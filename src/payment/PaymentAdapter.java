// Name: Shahed Samir Mohammed
// ID: 220231639

package payment;

// Adapter Pattern: Adapts the LegacyPaymentProcessor to work with ModernPaymentSystem
public class PaymentAdapter implements ModernPaymentSystem {
    
    private LegacyPaymentProcessor legacyProcessor;
    private String lastPaymentStatus;
    private String lastCardNumber;
    
    public PaymentAdapter(LegacyPaymentProcessor legacyProcessor) {
        this.legacyProcessor = legacyProcessor;
        this.lastPaymentStatus = "Not processed";
        this.lastCardNumber = "";
    }
    
    public PaymentAdapter(String merchantId, String apiKey) {
        this.legacyProcessor = new LegacyPaymentProcessor(merchantId, apiKey);
        this.lastPaymentStatus = "Not processed";
        this.lastCardNumber = "";
    }
    
    @Override
    public boolean processPayment(double amount, String paymentMethod) {
        System.out.println("\n  🔄 [ADAPTER] Converting modern payment request to legacy format...");
        
        // Parse payment method (format: "card:1234567890123456|12/25|123")
        String cardNumber = "4111111111111111";
        String expiryDate = "12/25";
        String cvv = "123";
        
        if (paymentMethod != null && paymentMethod.startsWith("card:")) {
            String[] parts = paymentMethod.split("\\|");
            if (parts.length >= 1) {
                cardNumber = parts[0].substring(5); // Remove "card:" prefix
            }
            if (parts.length >= 2) {
                expiryDate = parts[1];
            }
            if (parts.length >= 3) {
                cvv = parts[2];
            }
        }
        
        this.lastCardNumber = cardNumber;
        
        // Call the legacy system with adapted parameters
        boolean result = legacyProcessor.makePayment(cardNumber, expiryDate, cvv, amount, "USD");
        
        lastPaymentStatus = result ? "APPROVED" : "DECLINED";
        
        System.out.println("  🔄 [ADAPTER] Legacy result converted to: " + lastPaymentStatus);
        
        return result;
    }
    
    @Override
    public String getPaymentStatus() {
        return lastPaymentStatus;
    }
    
    public String getLastCardNumber() {
        return "****" + lastCardNumber.substring(Math.max(0, lastCardNumber.length() - 4));
    }
}