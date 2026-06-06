// Name: Shahed Samir Mohammed
// ID: 220231639

package billing;

public class RegularPricing implements BillingStrategy {
    
    @Override
    public double calculateTotal(double originalPrice) {
        // Regular price - no discount
        return originalPrice;
    }
    
    @Override
    public String getStrategyName() {
        return "Regular Pricing (No Discount)";
    }
}