// Name: Shahed Samir Mohammed
// ID: 220231639

package workflows;

import notifications.NotificationService;

public class CheckOutWorkflow extends HotelWorkflow {
    
    public CheckOutWorkflow(NotificationService notificationService) {
        super("Guest Check-Out Workflow", notificationService);
    }
    
    @Override
    protected void stepOne() {
        System.out.println("  📋 Step 1: Request room keys return and check room status");
        notificationService.notifyObservers("CHECKOUT_START", "Checking room status");
    }
    
    @Override
    protected void stepTwo() {
        System.out.println("  💰 Step 2: Calculate final bill (room + extras + taxes)");
        notificationService.notifyObservers("BILL_CALCULATION", "Calculating final amount");
    }
    
    @Override
    protected void stepThree() {
        System.out.println("  💳 Step 3: Process final payment and issue receipt");
        notificationService.notifyObservers("PAYMENT_COMPLETE", "Final payment processed");
    }
    
    @Override
    protected void stepFour() {
        System.out.println("  ⭐ Step 4: Request guest feedback and ratings");
        notificationService.notifyObservers("FEEDBACK_REQUEST", "Requesting guest feedback");
    }
    
    @Override
    protected void stepFive() {
        System.out.println("  👋 Step 5: Thank guest and offer future promotions");
        notificationService.notifyObservers("FAREWELL", "Guest farewell");
    }
}