// Name: Shahed Samir Mohammed
// ID: 220231639

package workflows;

import notifications.NotificationService;

public class CheckInWorkflow extends HotelWorkflow {
    
    public CheckInWorkflow(NotificationService notificationService) {
        super("Guest Check-In Workflow", notificationService);
    }
    
    @Override
    protected void stepOne() {
        System.out.println("  📋 Step 1: Verify guest identity and booking confirmation");
        notificationService.notifyObservers("CHECKIN_VERIFY", "Verifying guest documents");
    }
    
    @Override
    protected void stepTwo() {
        System.out.println("  🔑 Step 2: Process payment and security deposit");
        notificationService.notifyObservers("PAYMENT_PROCESS", "Processing payment");
    }
    
    @Override
    protected void stepThree() {
        System.out.println("  🗝️ Step 3: Issue room keys and provide room information");
        notificationService.notifyObservers("KEYS_ISSUED", "Room keys issued");
    }
    
    @Override
    protected void stepFour() {
        System.out.println("  🅿️ Step 4: Arrange parking if requested");
        notificationService.notifyObservers("PARKING_ARRANGED", "Parking arranged");
    }
}