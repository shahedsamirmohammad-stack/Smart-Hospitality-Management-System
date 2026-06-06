package rooms;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class RoomFactory {

    private static final Map<String, Supplier<Room>> roomCreators = new HashMap<>();

    static {
        roomCreators.put("standard", StandardRoom::new);
        roomCreators.put("deluxe", DeluxeRoom::new);
        roomCreators.put("suite", SuiteRoom::new);
    }

    public static Room createRoom(String type) {
        Supplier<Room> creator = roomCreators.get(type.toLowerCase());

        if (creator == null) {
            throw new IllegalArgumentException("Invalid room type: " + type);
        }

        return creator.get();
    }
}