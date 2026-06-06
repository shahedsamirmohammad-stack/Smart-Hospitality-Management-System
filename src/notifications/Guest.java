// Name: Shahed Samir Mohammed
// ID: 220231639

package notifications;

public class Guest implements Observer {
    private String name;
    private String email;
    private String phone;
    
    public Guest(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }
    
    @Override
    public void update(String eventType, String message) {
        System.out.println("  🧑 GUEST [" + name + "] Notification: " + eventType + " - " + message);
    }
    
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
}