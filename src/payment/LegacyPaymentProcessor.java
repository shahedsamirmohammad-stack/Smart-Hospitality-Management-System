// Name: Shahed Samir Mohammed
// ID: 220231639
// Design Patterns Lab - Final Project
// Smart Hospitality Management System (SHMS)

package payment;

// This is the legacy (old) payment system with an incompatible interface
// We cannot change this code (pretend it's from a third-party library)
public class LegacyPaymentProcessor {
    
    private String merchantId;
    private String apiKey;
    
    public LegacyPaymentProcessor(String merchantId, String apiKey) {
        this.merchantId = merchantId;
        this.apiKey = apiKey;
    }
    
    // Old method signature - not compatible with our system
    public boolean makePayment(String cardNumber, String expiryDate, String cvv, double amount, String currency) {
        System.out.println("  [LEGACY SYSTEM] Processing payment of " + amount + " " + currency);
        System.out.println("  [LEGACY SYSTEM] Merchant ID: " + merchantId);
        System.out.println("  [LEGACY SYSTEM] Card: ****" + cardNumber.substring(cardNumber.length() - 4));
        
        // Simulate payment processing
        if (amount > 0) {
            System.out.println("  [LEGACY SYSTEM] Payment APPROVED");
            return true;
        } else {
            System.out.println("  [LEGACY SYSTEM] Payment FAILED");
            return false;
        }
    }
    
    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }
    
    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }
}