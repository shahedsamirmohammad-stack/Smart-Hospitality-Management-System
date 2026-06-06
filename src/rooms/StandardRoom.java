// Name: Shahed Samir Mohammed
// ID: 220231639

package rooms;

public class StandardRoom extends Room {
    
    public StandardRoom() {
        super("Standard Room", 100.0, 2, "TV, WiFi, Air Conditioning, Basic Furniture");
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