// Name: Shahed Samir Mohammed
// ID: 220231639
// Design Patterns Lab - Final Project
// Smart Hospitality Management System (SHMS)

package rooms;

public abstract class Room {
    protected String roomType;
    protected double price;
    protected int capacity;
    protected String features;
    
    public Room(String roomType, double price, int capacity, String features) {
        this.roomType = roomType;
        this.price = price;
        this.capacity = capacity;
        this.features = features;
    }
    
    public abstract void displayRoomInfo();
    
    public String getRoomType() { return roomType; }
    public double getPrice() { return price; }
    public int getCapacity() { return capacity; }
    public String getFeatures() { return features; }
    
    public void setPrice(double price) { this.price = price; }
}