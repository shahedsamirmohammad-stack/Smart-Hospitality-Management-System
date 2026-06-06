// Name: Shahed Samir Mohammed
// ID: 220231639
// Design Patterns Lab - Final Project
// Smart Hospitality Management System (SHMS)

package billing;

public interface BillingStrategy {
    double calculateTotal(double originalPrice);
    String getStrategyName();
}