// Name: Shahed Samir Mohammed
// ID: 220231639
// Design Patterns Lab - Final Project
// Smart Hospitality Management System (SHMS)

import config.SystemConfig;
import rooms.*;
import booking.Booking;
import notifications.*;
import workflows.*;
import billing.*;
import payment.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        
        System.out.println("\n╔════════════════════════════════════════════════════════════════════╗");
        System.out.println("║     SMART HOSPITALITY MANAGEMENT SYSTEM (SHMS)                    ║");
        System.out.println("║     Name: Shahed Samir Mohammed                                   ║");
        System.out.println("║     ID: 220231639                                                ║");
        System.out.println("╚════════════════════════════════════════════════════════════════════╝\n");
        
        // ========== 1. SINGLETON PATTERN - Load System Configuration ==========
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("🔧 SINGLETON PATTERN - System Configuration");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        
        SystemConfig config = SystemConfig.getInstance();
        config.displayConfig();
        
        // ========== 2. OBSERVER PATTERN - Setup Notification System ==========
        System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("📢 OBSERVER PATTERN - Notification System");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        
        NotificationService notificationService = new NotificationService();
        
        // Create observers
        Guest guest1 = new Guest("Ahmed Al-Masri", "ahmed@email.com", "0599123456");
        Guest guest2 = new Guest("Fatima Al-Husseini", "fatima@email.com", "0599987654");
        Staff staff1 = new Staff("Omar Hassan", "Front Desk", 101);
        Staff staff2 = new Staff("Lina Khalid", "Housekeeping", 102);
        Manager manager1 = new Manager("Nadia Al-Barghouthi", "Operations", 201);
        
        // Subscribe to notifications
        notificationService.attach(guest1);
        notificationService.attach(guest2);
        notificationService.attach(staff1);
        notificationService.attach(staff2);
        notificationService.attach(manager1);
        
        // ========== 3. FACTORY METHOD PATTERN - Create Rooms ==========
        System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("🏨 FACTORY METHOD PATTERN - Room Creation");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        
        Room standardRoom = RoomFactory.createRoom("standard");
        Room deluxeRoom = RoomFactory.createRoom("deluxe");
        Room suiteRoom = RoomFactory.createRoom("suite");
        
        System.out.println("\nAvailable Rooms:");
        standardRoom.displayRoomInfo();
        deluxeRoom.displayRoomInfo();
        suiteRoom.displayRoomInfo();
        
        // ========== 4. BUILDER PATTERN - Create Booking ==========
        System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("📝 BUILDER PATTERN - Complex Booking Creation");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        
        Booking booking = new Booking.Builder(
            "Ahmed Al-Masri", 
            "ahmed@email.com", 
            "0599123456", 
            deluxeRoom,
            LocalDate.now().plusDays(5),
            LocalDate.now().plusDays(8),
            2
        )
        .addBreakfast()
        .addDinner()
        .addSpa()
        .addParking()
        .setSpecialRequests("Extra pillows and late checkout")
        .build();
        
        booking.displayBooking();
        
        // Booking confirmation notification
        notificationService.notifyObservers("BOOKING_CONFIRMED", "Booking #" + booking.getBookingId() + " confirmed for " + booking.getGuestName());
        
        // ========== 5. TEMPLATE METHOD PATTERN - Check-in Workflow ==========
        System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("🏨 TEMPLATE METHOD PATTERN - Check-in Workflow");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        
        HotelWorkflow checkIn = new CheckInWorkflow(notificationService);
        checkIn.executeWorkflow();
        
        // ========== 6. STRATEGY PATTERN - Billing with different strategies ==========
        System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("💰 STRATEGY PATTERN - Dynamic Billing");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        
        double originalAmount = booking.calculateTotalPrice();
        System.out.println("Original amount: $" + originalAmount);
        
        // Regular pricing
        BillingStrategy regularStrategy = new RegularPricing();
        System.out.println("\n  📊 " + regularStrategy.getStrategyName());
        System.out.println("  Total after discount: $" + regularStrategy.calculateTotal(originalAmount));
        
        // Member discount
        BillingStrategy memberStrategy = new MemberDiscount();
        System.out.println("\n  📊 " + memberStrategy.getStrategyName());
        System.out.println("  Total after discount: $" + memberStrategy.calculateTotal(originalAmount));
        
        // Seasonal pricing
        BillingStrategy seasonalStrategy = new SummerPricing();
        System.out.println("\n  📊 " + seasonalStrategy.getStrategyName());
        System.out.println("  Total after adjustment: $" + seasonalStrategy.calculateTotal(originalAmount));
        
        // ========== 7. ADAPTER PATTERN - Legacy Payment Integration ==========
        System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("💳 ADAPTER PATTERN - Legacy Payment Integration");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        
        // Use the selected billing strategy (let's use member discount for payment)
        double finalAmount = memberStrategy.calculateTotal(originalAmount);
        System.out.println("Final amount to pay: $" + finalAmount);
        
        // Create adapter for legacy payment system
        PaymentAdapter paymentAdapter = new PaymentAdapter("HOTEL_MERCHANT_001", "SECRET_API_KEY_123");
        
        // Process payment through adapter
        boolean paymentSuccess = paymentAdapter.processPayment(finalAmount, "card:4111111111111111|12/25|123");
        
        if (paymentSuccess) {
            System.out.println("\n  ✅ Payment successful! Status: " + paymentAdapter.getPaymentStatus());
            notificationService.notifyObservers("PAYMENT_COMPLETE", "Payment of $" + finalAmount + " completed successfully");
        } else {
            System.out.println("\n  ❌ Payment failed! Status: " + paymentAdapter.getPaymentStatus());
        }
        
        // ========== 8. TEMPLATE METHOD PATTERN - Check-out Workflow ==========
        System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("🏨 TEMPLATE METHOD PATTERN - Check-out Workflow");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        
        HotelWorkflow checkOut = new CheckOutWorkflow(notificationService);
        checkOut.executeWorkflow();
        
        // ========== 9. FINAL SUMMARY ==========
        System.out.println("\n╔════════════════════════════════════════════════════════════════════╗");
        System.out.println("║                    SYSTEM DEMO COMPLETE                           ║");
        System.out.println("╠════════════════════════════════════════════════════════════════════╣");
        System.out.println("║  All 7 Design Patterns Implemented:                               ║");
        System.out.println("║                                                              ║");
        System.out.println("║  ✓ Singleton      - System Configuration                   ║");
        System.out.println("║  ✓ Factory Method - Room Creation                          ║");
        System.out.println("║  ✓ Builder        - Complex Booking Construction          ║");
        System.out.println("║  ✓ Observer       - Event Notifications                   ║");
        System.out.println("║  ✓ Strategy       - Dynamic Billing                       ║");
        System.out.println("║  ✓ Template Method- Check-in/Check-out Workflows         ║");
        System.out.println("║  ✓ Adapter        - Legacy Payment Integration            ║");
        System.out.println("╠════════════════════════════════════════════════════════════════════╣");
        System.out.println("║  No if/switch statements used for behavior selection             ║");
        System.out.println("║  Loose coupling maintained throughout all modules                ║");
        System.out.println("╚════════════════════════════════════════════════════════════════════╝\n");
    }
}