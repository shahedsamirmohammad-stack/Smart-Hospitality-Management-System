// Name: Shahed Samir Mohammed
// ID: 220231639

package rooms;

public class SuiteRoom extends Room {
    
    public SuiteRoom() {
        super("Suite Room", 350.0, 4, "Separate Living Room, Kitchen, 2 TVs, WiFi, Jacuzzi, Balcony");
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