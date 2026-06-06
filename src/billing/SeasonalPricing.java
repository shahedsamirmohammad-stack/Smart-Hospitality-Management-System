// Name: Shahed Samir Mohammed
// ID: 220231639

package billing;

public abstract class SeasonalPricing implements BillingStrategy {

    protected String season;
    protected double seasonalMultiplier;

    @Override
    public double calculateTotal(double originalPrice) {
        return originalPrice * seasonalMultiplier;
    }

    @Override
    public String getStrategyName() {
        return "Seasonal Pricing (" + season + " - "
                + (int) ((seasonalMultiplier - 1) * 100)
                + "% adjustment)";
    }
}