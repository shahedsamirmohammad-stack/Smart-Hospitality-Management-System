// Name: Shahed Samir Mohammed
// ID: 220231639

package rooms;

public class RoomFactory {
    
    // Factory Method - creates different room types
    public static Room createRoom(String roomType) {
        if (roomType == null) {
            return null;
        }
        
        switch (roomType.toLowerCase()) {
            case "standard":
                return new StandardRoom();
            case "deluxe":
                return new DeluxeRoom();
            case "suite":
                return new SuiteRoom();
            default:
                System.out.println("[FACTORY] Unknown room type: " + roomType);
                return null;
        }
    }
}