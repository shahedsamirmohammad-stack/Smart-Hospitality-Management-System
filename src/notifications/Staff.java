// Name: Shahed Samir Mohammed
// ID: 220231639

package notifications;

public class Staff implements Observer {
    private String name;
    private String position;
    private int staffId;
    
    public Staff(String name, String position, int staffId) {
        this.name = name;
        this.position = position;
        this.staffId = staffId;
    }
    
    @Override
    public void update(String eventType, String message) {
        System.out.println("  👩‍💼 STAFF [" + name + " - " + position + "] Notification: " + eventType + " - " + message);
    }
    
    public String getName() { return name; }
    public String getPosition() { return position; }
    public int getStaffId() { return staffId; }
}