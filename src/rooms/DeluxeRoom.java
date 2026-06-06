// Name: Shahed Samir Mohammed
// ID: 220231639

package rooms;

public class DeluxeRoom extends Room {
    
    public DeluxeRoom() {
        super("Deluxe Room", 180.0, 3, "King Bed, TV, WiFi, Mini Bar, AC, Bathtub, City View");
    }
    
    @Override
    public void displayRoomInfo() {
        System.out.println("  ┌─────────────────────────────────┐");
        System.out.println("  │ Room Type: " + roomType);
        System.out.println("  │ Price: $" + price + " per night");
        System.out.println("  │ Capacity: " + capacity + " persons");
        System.out.println("  │ Features: " + features);
        System.out.println("  └─────────────────────────────────┘");
    }
}