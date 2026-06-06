// Name: Shahed Samir Mohammed
// ID: 220231639

package notifications;

public interface Subject {
    void attach(Observer observer);
    void detach(Observer observer);
    void notifyObservers(String eventType, String message);
}