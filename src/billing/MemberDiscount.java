// Name: Shahed Samir Mohammed
// ID: 220231639

package billing;

public class MemberDiscount implements BillingStrategy {
    
    private double discountPercentage;
    
    public MemberDiscount() {
        this.discountPercentage = 0.15; // 15% discount for members
    }
    
    public MemberDiscount(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }
    
    @Override
    public double calculateTotal(double originalPrice) {
        double discount = originalPrice * discountPercentage;
        return originalPrice - discount;
    }
    
    @Override
    public String getStrategyName() {
        return "Member Discount (" + (int)(discountPercentage * 100) + "% off)";
    }
}