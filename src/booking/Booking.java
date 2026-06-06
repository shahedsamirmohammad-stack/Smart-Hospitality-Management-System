// Name: Shahed Samir Mohammed
// ID: 220231639
// Design Patterns Lab - Final Project
// Smart Hospitality Management System (SHMS)

package booking;

import rooms.Room;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Booking {
    private long bookingId;
    private String guestName;
    private String guestEmail;
    private String guestPhone;
    private Room room;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private int numberOfGuests;
    
    // Optional extras
    private boolean breakfast;
    private boolean dinner;
    private boolean spa;
    private boolean parking;
    private String specialRequests;
    
    private static long idCounter = 1000;
    
    // Private constructor - only Builder can create
    private Booking(Builder builder) {
        this.bookingId = ++idCounter;
        this.guestName = builder.guestName;
        this.guestEmail = builder.guestEmail;
        this.guestPhone = builder.guestPhone;
        this.room = builder.room;
        this.checkInDate = builder.checkInDate;
        this.checkOutDate = builder.checkOutDate;
        this.numberOfGuests = builder.numberOfGuests;
        this.breakfast = builder.breakfast;
        this.dinner = builder.dinner;
        this.spa = builder.spa;
        this.parking = builder.parking;
        this.specialRequests = builder.specialRequests;
    }
    
    // Calculate total price
    public double calculateTotalPrice() {
        long nights = java.time.temporal.ChronoUnit.DAYS.between(checkInDate, checkOutDate);
        double total = room.getPrice() * nights;
        
        if (breakfast) total += 15 * nights;
        if (dinner) total += 25 * nights;
        if (spa) total += 50;
        if (parking) total += 10 * nights;
        
        return total;
    }
    
    public void displayBooking() {
        System.out.println("\n  ╔══════════════════════════════════════════════════╗");
        System.out.println("  ║                 BOOKING CONFIRMATION              ║");
        System.out.println("  ╠══════════════════════════════════════════════════╣");
        System.out.println("  ║ Booking ID: " + bookingId);
        System.out.println("  ║ Guest: " + guestName);
        System.out.println("  ║ Email: " + guestEmail);
        System.out.println("  ║ Phone: " + guestPhone);
        System.out.println("  ║ Room: " + room.getRoomType());
        System.out.println("  ║ Check-in: " + checkInDate);
        System.out.println("  ║ Check-out: " + checkOutDate);
        System.out.println("  ║ Guests: " + numberOfGuests);
        System.out.println("  ╠══════════════════════════════════════════════════╣");
        System.out.println("  ║ Extras:");
        if (breakfast) System.out.println("  ║   ✓ Breakfast included");
        if (dinner) System.out.println("  ║   ✓ Dinner included");
        if (spa) System.out.println("  ║   ✓ Spa treatment");
        if (parking) System.out.println("  ║   ✓ Parking included");
        if (specialRequests != null && !specialRequests.isEmpty()) {
            System.out.println("  ║ Special Requests: " + specialRequests);
        }
        System.out.println("  ╠══════════════════════════════════════════════════╣");
        System.out.println("  ║ Total Price: $" + calculateTotalPrice());
        System.out.println("  ╚══════════════════════════════════════════════════╝\n");
    }
    
    // Getters
    public long getBookingId() { return bookingId; }
    public String getGuestName() { return guestName; }
    public Room getRoom() { return room; }
    public LocalDate getCheckInDate() { return checkInDate; }
    public LocalDate getCheckOutDate() { return checkOutDate; }
    
    // ========== BUILDER PATTERN (inner class) ==========
    
    public static class Builder {
        // Required fields
        private String guestName;
        private String guestEmail;
        private String guestPhone;
        private Room room;
        private LocalDate checkInDate;
        private LocalDate checkOutDate;
        private int numberOfGuests;
        
        // Optional fields (with defaults)
        private boolean breakfast = false;
        private boolean dinner = false;
        private boolean spa = false;
        private boolean parking = false;
        private String specialRequests = "";
        
        public Builder(String guestName, String guestEmail, String guestPhone, 
                       Room room, LocalDate checkInDate, LocalDate checkOutDate, int numberOfGuests) {
            this.guestName = guestName;
            this.guestEmail = guestEmail;
            this.guestPhone = guestPhone;
            this.room = room;
            this.checkInDate = checkInDate;
            this.checkOutDate = checkOutDate;
            this.numberOfGuests = numberOfGuests;
        }
        
        public Builder addBreakfast() {
            this.breakfast = true;
            return this;
        }
        
        public Builder addDinner() {
            this.dinner = true;
            return this;
        }
        
        public Builder addSpa() {
            this.spa = true;
            return this;
        }
        
        public Builder addParking() {
            this.parking = true;
            return this;
        }
        
        public Builder setSpecialRequests(String requests) {
            this.specialRequests = requests;
            return this;
        }
        
        public Booking build() {
            return new Booking(this);
        }
    }
}