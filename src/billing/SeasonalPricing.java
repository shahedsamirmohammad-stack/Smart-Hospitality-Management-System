// Name: Shahed Samir Mohammed
// ID: 220231639

package billing;

public class SeasonalPricing implements BillingStrategy {
    
    private double seasonalMultiplier;
    private String season;
    
    public SeasonalPricing(String season) {
        this.season = season;
        switch (season.toLowerCase()) {
            case "summer":
                this.seasonalMultiplier = 1.3; // 30% higher in summer
                break;
            case "winter":
                this.seasonalMultiplier = 1.2; // 20% higher in winter
                break;
            case "spring":
            case "autumn":
                this.seasonalMultiplier = 1.0; // normal price
                break;
            default:
                this.seasonalMultiplier = 1.0;
        }
    }
    
    @Override
    public double calculateTotal(double originalPrice) {
        return originalPrice * seasonalMultiplier;
    }
    
    @Override
    public String getStrategyName() {
        return "Seasonal Pricing (" + season + " - " + (int)((seasonalMultiplier - 1) * 100) + "% adjustment)";
    }
}