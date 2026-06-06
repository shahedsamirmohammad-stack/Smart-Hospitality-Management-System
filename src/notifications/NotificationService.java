// Name: Shahed Samir Mohammed
// ID: 220231639

package notifications;

import java.util.ArrayList;
import java.util.List;

public class NotificationService implements Subject {
    
    private List<Observer> observers;
    
    public NotificationService() {
        this.observers = new ArrayList<>();
    }
    
    @Override
    public void attach(Observer observer) {
        observers.add(observer);
        System.out.println("  [NOTIFICATION] " + getObserverName(observer) + " subscribed to notifications");
    }
    
    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
        System.out.println("  [NOTIFICATION] " + getObserverName(observer) + " unsubscribed");
    }
    
    @Override
    public void notifyObservers(String eventType, String message) {
        System.out.println("\n  📢 [SYSTEM BROADCAST] " + eventType);
        for (Observer observer : observers) {
            observer.update(eventType, message);
        }
    }
    
    private String getObserverName(Observer observer) {
        if (observer instanceof Guest) {
            return ((Guest) observer).getName();
        } else if (observer instanceof Staff) {
            return ((Staff) observer).getName();
        } else if (observer instanceof Manager) {
            return ((Manager) observer).getName();
        }
        return "User";
    }
}