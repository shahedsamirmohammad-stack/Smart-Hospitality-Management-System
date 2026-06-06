// Name: Shahed Samir Mohammed
// ID: 220231639

package notifications;

public class Manager implements Observer {
    private String name;
    private String department;
    private int managerId;
    
    public Manager(String name, String department, int managerId) {
        this.name = name;
        this.department = department;
        this.managerId = managerId;
    }
    
    @Override
    public void update(String eventType, String message) {
        System.out.println("  👔 MANAGER [" + name + " - " + department + "] Notification: " + eventType + " - " + message);
    }
    
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public int getManagerId() { return managerId; }
}